package com.personal.shivam.springBootJsp.authentication;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String name, String password) {
        boolean isValidName = name.equalsIgnoreCase("Shivam");
        boolean isValidPass = password.equalsIgnoreCase("pass");
        return isValidPass && isValidName;
    }
}
