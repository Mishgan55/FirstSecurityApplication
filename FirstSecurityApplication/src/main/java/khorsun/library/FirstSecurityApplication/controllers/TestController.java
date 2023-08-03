package khorsun.library.FirstSecurityApplication.controllers;

import khorsun.library.FirstSecurityApplication.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/hello")
    public String helloPage(){
        return "hello";
    }
    @GetMapping("/show")
    public String showPersonInfo(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        PersonDetails principal = (PersonDetails) authentication.getPrincipal();
        System.out.println(principal.getPerson());
        return "hello";
    }
}
