package com.br.zamp.misc;

import com.br.zamp.domain.Company;
import com.br.zamp.domain.User;
import com.br.zamp.domain.UserProfile;
import com.br.zamp.domain.enums.UserSituation;
import com.br.zamp.enums.Permission;
import com.br.zamp.repository.CompanyRepository;
import com.br.zamp.repository.ParameterRepository;
import com.br.zamp.repository.UserProfileRepository;
import com.br.zamp.repository.UserRepository;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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

    User user2 = new User();
    user2.setName("Gabriel2");
    user2.setEmail("admin2");
    user2.setPassword(pe.encode("admin"));
    user2.setSituation(UserSituation.ACTIVE);
    user2.setUserProfiles(new HashSet<>());

    User user3 = new User();
    user3.setName("Juliana");
    user3.setEmail("a3dmin");
    user3.setPassword(pe.encode("admin"));
    user3.setSituation(UserSituation.ACTIVE);
    user3.setUserProfiles(new HashSet<>());

    User user4 = new User();
    user4.setName("Teste");
    user4.setEmail("emailTeste@gmail.com");
    user4.setPassword(pe.encode("admin"));
    user4.setSituation(UserSituation.INACTIVE);
    user4.setUserProfiles(new HashSet<>());

    userRepository.save(user);
    userRepository.save(user2);
    userRepository.save(user3);
    userRepository.save(user4);

    Company c = new Company();
    c.setName("Zamp");
    c.setCnpj("12345678912");

    companyRepository.save(c);

    UserProfile p = new UserProfile();
    p.setName("Administrador");
    p.setLevel(20);
    p.getPermissions().add(Permission.ALL);
    user.getUserProfiles().add(p);

    UserProfile p2 = new UserProfile();
    p2.setName("OutroAdministrador");
    p2.setLevel(2);
    p2.getPermissions().add(Permission.COMPANIES_MENU);
    user2.getUserProfiles().add(p);
    user4.getUserProfiles().add(p);

    userProfileRepository.save(p);
    userProfileRepository.save(p2);

    userRepository.save(user);
    userRepository.save(user2);
    userRepository.save(user4);

    c.getUsers().add(user);
    c.getUsers().add(user2);
  }
}