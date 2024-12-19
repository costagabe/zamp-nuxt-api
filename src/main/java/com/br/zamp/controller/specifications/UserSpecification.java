package com.br.zamp.controller.specifications;

import com.br.zamp.domain.User;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Or({@Spec(path = "name", spec = Like.class), @Spec(path = "email", spec = Like.class)})
public interface UserSpecification extends Specification<User> {}
