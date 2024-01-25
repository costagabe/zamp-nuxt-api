package com.br.zamp.service;

import com.br.zamp.domain.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;


public interface CrudService <Entity extends Base> {
   Entity create(Entity entity);
   Entity update(Entity entity);
   Entity findById(UUID uuid);
   Page<Entity> findAll(Specification<Entity> specification, Pageable pageable);
   void delete(UUID uuid);
}
