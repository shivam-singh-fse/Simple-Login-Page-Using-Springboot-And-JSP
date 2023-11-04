package com.personal.shivam.springBootJsp;

import com.personal.shivam.springBootJsp.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginWebApplicationController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        modelMap.put("name", "Shivam");
        return "login/welcome";
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String welcome(@RequestParam String name, @RequestParam String password, ModelMap map) {
//        if (authenticationService.authenticate(name, password)) {
//            map.put("name", name);
//            return "login/welcome";
//        }
//        map.put("errorMessage", "Invalid credentials!! Please enter valid credentials.");
//        return "login/login";
//    }
}
