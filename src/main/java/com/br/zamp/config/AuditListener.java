package com.br.zamp.config;

import com.br.zamp.domain.Base;
import com.br.zamp.mapper.BaseMapper;
import com.br.zamp.security.AuthenticatedUser;
import com.br.zamp.util.ObjectUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class AuditListener {
  private final ApplicationContext applicationContext;


  @PrePersist
  private <T extends Base> void beforeInsert(T object) {
    if (object.isDeleted() || SecurityContextHolder.getContext().getAuthentication() == null) {
      return;
    }

    AuthenticatedUser auth = applicationContext.getBean(AuthenticatedUser.class);
    var userId = auth.getUserId();

    object.setCreatedBy(userId);
  }

  @SuppressWarnings("unchecked")
  @PreUpdate
  private <T extends Base> void beforeUpdate(T object) {
    if (object.isDeleted()) {
      return;
    }

    String className = toCamelCase(object.getClass().getSimpleName());

    JpaRepository<T, UUID> repository = applicationContext.getBean(className + "Repository", JpaRepository.class);
    BaseMapper<T, Object, Object> mapper = applicationContext.getBean(className + "MapperImpl", BaseMapper.class);
    EntityManager entityManager = applicationContext.getBean(EntityManager.class);
    AuthenticatedUser auth = applicationContext.getBean(AuthenticatedUser.class);
    var userId = auth.getUserId();

    if (userId == null) {
      return;
    }

    var newObject = mapper.copy(object);

    var entity = repository.findById(object.getId()).orElseThrow();

    entityManager.refresh(entity);

    var oldEntity = mapper.copy(entity);
    oldEntity.setId(entity.getId());

    var copy = mapper.copy(entity);
    copy.setDeleted(true);

    if (!ObjectUtil.isEqual(newObject, oldEntity)) {
      repository.save(copy);
    }

    mapper.update(newObject, entity);

    entity.setVersion(entity.getVersion() + 1);
    entity.setUpdatedBy(auth.getUserId());
    entity.setLastUpdatedAt(LocalDateTime.now());
  }

  @SuppressWarnings("unchecked")
  @PreRemove
  private <T extends Base> void beforeRemove(T entity) {

    if (entity.isDeleted() || SecurityContextHolder.getContext().getAuthentication() == null) {
      return;
    }
    String className = toCamelCase(entity.getClass().getSimpleName());
    JpaRepository<T, UUID> repository = applicationContext.getBean(className + "Repository", JpaRepository.class);
    EntityManager entityManager = applicationContext.getBean(EntityManager.class);

    AuthenticatedUser auth = applicationContext.getBean(AuthenticatedUser.class);
    var userId = auth.getUserId();

    var id = entity.getId();

    entity.setDeletedBy(userId);
    repository.save(entity);
    entityManager.flush();
    entity.setId(id);
    entityManager.refresh(entity);

    System.out.println("Deleted: " + entity);
  }

  private String toCamelCase(String input) {
    if (input == null || input.isEmpty()) {
      return input;
    }
    return Character.toLowerCase(input.charAt(0)) + input.substring(1);
  }


}