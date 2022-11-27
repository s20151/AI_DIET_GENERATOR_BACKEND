package pjwstk.aidietgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjwstk.aidietgenerator.entity.User;
import pjwstk.aidietgenerator.request.RegisterRequest;
import pjwstk.aidietgenerator.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public void register(@RequestBody RegisterRequest registerRequest, HttpServletResponse response){

        if(userService.doesUserExist (registerRequest.getUsername ())){
            response.setStatus (HttpStatus.CONFLICT.value ()); //User already exists.
        }else {
            if(registerRequest.getPassword () == null || registerRequest.getPassword () == ""){
                response.setStatus (HttpStatus.CONFLICT.value ()); //Invalid password.
            }else {
                User newUser = new User(registerRequest.getFirst_name(), registerRequest.getLast_name(), registerRequest.getEmail() ,registerRequest.getUsername(),registerRequest.getPassword()); //New user created.
                if(userService.isEmpty ()){
                    GrantedAuthority adminAuthority = () -> "ROLE_ADMIN";
                    newUser.addAuthority(adminAuthority);
                }
                GrantedAuthority defaultAuthority = () -> "ROLE_USER";
                newUser.addAuthority(defaultAuthority);
                userService.saveUser(newUser);
            }
        }
    }
}