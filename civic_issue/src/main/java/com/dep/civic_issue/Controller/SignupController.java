package com.dep.civic_issue.Controller;

import com.dep.civic_issue.Entity.User;
import com.dep.civic_issue.Repositories.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public SignupController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping(value = "/signup"  ,consumes = "application/json")
    private ResponseEntity<String> createUser(@RequestBody User myUser){
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        userRepo.save(myUser);
        return ResponseEntity.ok("user registered ");
    }
}
