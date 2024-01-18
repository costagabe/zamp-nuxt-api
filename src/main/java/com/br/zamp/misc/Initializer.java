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

        userRepository.save(user);

        Company c = new Company();
        c.setName("Zamp");
        c.setCnpj("12345678912");

        companyRepository.save(c);

        UserProfile p = new UserProfile();
        p.setDescription("Administrador");
        p.setLevel(20);
        p.getPermissions().add(Permission.ALL);
        p.getUsers().add(user);

        userProfileRepository.save(p);

        c.getUsers().add(user);
    }

}