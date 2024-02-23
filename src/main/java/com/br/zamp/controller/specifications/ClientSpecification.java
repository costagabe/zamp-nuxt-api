package com.br.zamp.controller.specifications;

import com.br.zamp.domain.Client;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Or({
  @Spec(path = "name", spec = Like.class),
  @Spec(path = "cpf", spec = Like.class),
  @Spec(path = "cnpj", spec = Like.class)
})
public interface ClientSpecification extends Specification<Client> {
}
