package com.br.zamp.config;

import com.br.zamp.domain.Base;
import com.br.zamp.security.AuthenticatedUser;
import com.br.zamp.util.StringUtil;
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

  @PreUpdate
  private <T extends Base> void beforeUpdate(T object) {
    if (object.isDeleted()) {
      return;
    }

    AuthenticatedUser auth = applicationContext.getBean(AuthenticatedUser.class);
    var userId = auth.getUserId();

    if (userId == null) {
      return;
    }

    object.setVersion(object.getVersion() + 1);
    object.setUpdatedBy(userId);
    object.setLastUpdatedAt(LocalDateTime.now());
  }

  @PreRemove
  @SuppressWarnings("unchecked")
  private <T extends Base> void beforeRemove(T entity) {
    if (entity.isDeleted() || SecurityContextHolder.getContext().getAuthentication() == null) {
      return;
    }
    String className = StringUtil.toCamelCase(entity.getClass().getSimpleName());
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
  }
}