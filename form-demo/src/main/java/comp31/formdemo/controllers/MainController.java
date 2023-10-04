package comp31.formdemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import comp31.formdemo.model.Person;
import comp31.formdemo.services.LoginService;

@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    LoginService loginService;

    public MainController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    String getRoot(Model model) {
        logger.info("---- At root.");
        Person person = new Person(); // Create backing object and
        model.addAttribute("person", person); // send it to login form
        return "login-form";
    }

    @PostMapping("/login")
    public String getForm(Person person, Model model) {
        logger.info("---- At /login.");
        logger.info("---- " + person.toString());
        Person currentUser = loginService.findByUserId(person.getUserId());
        String returnPage;
        if (currentUser == null) {
            model.addAttribute("person", person);
            returnPage = "login-form";
        } else {
            model.addAttribute("person", currentUser);
            returnPage = "welcome";
        }
        return returnPage;
    }

}
