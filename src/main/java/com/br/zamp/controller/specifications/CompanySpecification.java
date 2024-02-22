package com.br.zamp.controller.specifications;

import com.br.zamp.domain.Company;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Or({
  @Spec(path = "name", spec = Like.class),
  @Spec(path = "cnpj", spec = Like.class)
})
public interface CompanySpecification extends Specification<Company> {
}
