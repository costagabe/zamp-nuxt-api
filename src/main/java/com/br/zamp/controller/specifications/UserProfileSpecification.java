package com.br.zamp.controller.specifications;

import com.br.zamp.domain.UserProfile;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Spec(path = "name", spec = Like.class)
public interface UserProfileSpecification extends Specification<UserProfile> {}
