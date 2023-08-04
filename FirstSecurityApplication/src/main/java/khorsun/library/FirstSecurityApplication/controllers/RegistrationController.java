package khorsun.library.FirstSecurityApplication.controllers;

import khorsun.library.FirstSecurityApplication.models.Person;
import khorsun.library.FirstSecurityApplication.services.SecurityService;
import khorsun.library.FirstSecurityApplication.utils.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class RegistrationController {

    private final SecurityService securityService;
    private final PersonValidator personValidator;
    @Autowired
    public RegistrationController(SecurityService securityService, PersonValidator personValidator) {
        this.securityService = securityService;
        this.personValidator = personValidator;
    }

    @GetMapping("/registration")
    public String formForRegistration(@ModelAttribute("person")Person person){
        return "auth/registration";
    }
    @PostMapping("/registration")
    public String registrationNewPerson(@ModelAttribute("person")@Valid Person person, BindingResult bindingResult){
        personValidator.validate(person,bindingResult);
        if (bindingResult.hasErrors())
            return "auth/registration";
        securityService.registration(person);
        return "redirect:/auth/login";
    }
}
