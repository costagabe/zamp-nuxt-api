package com.br.zamp.misc;

import com.br.zamp.domain.Company;
import com.br.zamp.domain.User;
import com.br.zamp.domain.UserProfile;
import com.br.zamp.domain.enums.UserSituation;
import com.br.zamp.domain.enums.UserType;
import com.br.zamp.enums.Permission;
import com.br.zamp.repository.CompanyRepository;
import com.br.zamp.repository.ParameterRepository;
import com.br.zamp.repository.UserProfileRepository;
import com.br.zamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@RequiredArgsConstructor
@Component
public class Initializer {
  private final ParameterRepository parameterRepository;
  private final UserRepository userRepository;
  private final PasswordEncoder pe;
  private final UserProfileRepository userProfileRepository;
  private final CompanyRepository companyRepository;

  public void init() {
    User user = new User();
    user.setName("Gabriel");
    user.setEmail("admin");
    user.setPassword(pe.encode("admin"));
    user.setSituation(UserSituation.ACTIVE);
    user.setUserProfiles(new HashSet<>());
    user.setType(UserType.ADMIN);


    User user2 = new User();
    user2.setName("Gabriel2");
    user2.setEmail("admin2");
    user2.setPassword(pe.encode("admin"));
    user2.setSituation(UserSituation.ACTIVE);
    user2.setUserProfiles(new HashSet<>());
    user2.setType(UserType.CUSTOMER);

    userRepository.save(user);
    userRepository.save(user2);

    Company c = new Company();
    c.setName("Zamp");
    c.setCnpj("12345678912");

    companyRepository.save(c);

    UserProfile p = new UserProfile();
    p.setName("Administrador");
    p.setLevel(20);
    p.getPermissions().add(Permission.ALL);
    p.getUsers().add(user);

    UserProfile p2 = new UserProfile();
    p2.setName("Administrador2");
    p2.setLevel(2);
    p2.getPermissions().add(Permission.COMPANIES_MENU);
    p2.getUsers().add(user2);

    userProfileRepository.save(p);
    userProfileRepository.save(p2);

    user.getUserProfiles().add(p);
    user2.getUserProfiles().add(p2);


    c.getUsers().add(user);
    c.getUsers().add(user2);
  }

}