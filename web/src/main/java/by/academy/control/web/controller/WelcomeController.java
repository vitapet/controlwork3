package by.academy.control.web.controller;

import by.academy.control.service.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class WelcomeController {
    @GetMapping
    public String showLoginPage() {
        return "redirect:/login";
    }
}
