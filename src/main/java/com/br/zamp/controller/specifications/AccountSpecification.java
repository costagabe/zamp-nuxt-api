package com.br.zamp.controller.specifications;

import com.br.zamp.domain.Account;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.domain.NotEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
  @Spec(path = "id", params = "accountId", spec = NotEqual.class),
})
@Or({
  @Spec(path = "name", params = "name", spec = Like.class),
  @Spec(path = "id", params = "id", spec = Equal.class),
  @Spec(path = "type", params = "type", spec = In.class),
  @Spec(path = "code", spec = Like.class)
})
public interface AccountSpecification extends Specification<Account> {
}
