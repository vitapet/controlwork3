package by.academy.control.web.controller;

import by.academy.control.service.IUserService;
import by.academy.control.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public String getLoginPage(Model map, HttpServletRequest request) {
        UserDTO user = new UserDTO();
        if (request.getParameter("error") != null) {
            map.addAttribute("error", true);
        }
        map.addAttribute("user", user);
        return "login";
    }
}
