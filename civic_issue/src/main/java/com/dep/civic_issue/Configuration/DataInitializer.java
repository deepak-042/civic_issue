package com.dep.civic_issue.Configuration;

import com.dep.civic_issue.Entity.Role;
import com.dep.civic_issue.Entity.User;
import com.dep.civic_issue.Repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initSuperAdmin(UserRepo userRepo , PasswordEncoder passwordEncoder){
        return args -> {
            String superAdminUsername = "superadmin";

            if (userRepo.findByUsername(superAdminUsername).isEmpty()){
                User superadmin = new User();
                superadmin.setName("Super Admin");
                superadmin.setEmail("superAdmin@ex.com");
                superadmin.setUsername(superAdminUsername);
                superadmin.setPassword(passwordEncoder.encode("superpassword"));
                superadmin.setRole(Role.Super_admin);

                userRepo.save(superadmin);
                System.out.println("super admin created");
            }else {
                System.out.println("super admin was created before ");
            }
        };
    }
}
