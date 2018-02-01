package by.academy.control.web.controller;

import by.academy.control.service.IUserService;
import by.academy.control.service.model.UserDTO;
import by.academy.control.service.model.UserRoleDTO;
import by.academy.control.web.model.UserPrincipal;
import by.academy.control.web.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users")
    public String showUsers(Model model) {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin/admin_page";
    }

    //ADD
    @GetMapping("/admin/users/add")
    public String addUser(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        userDTO.setRole(UserRoleDTO.USER);
        List<UserRoleDTO> roles = Arrays.asList(UserRoleDTO.values());
        model.addAttribute("roles", roles);
        return "admin/admin_add_user";
    }

    @PostMapping("/admin/users/add")
    public String saveNewUser(@Valid @ModelAttribute("user") UserDTO user,
                              BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            UserDTO userCheck = userService.getByLogin(user.getLogin());
            if (userCheck == null) {
                userService.create(user);
                return "redirect:/admin/users";
            } else {
                model.addAttribute("message", "User with the same login already exists.");
                return "admin/admin_add_user";
            }
        } else {
            return "admin/admin_add_user";
        }
    }

    //EDIT
    @GetMapping("/admin/users/{id}/edit")
    public String editUser(Model model, @PathVariable Long id) {
        UserDTO userDTO = userService.getById(id);
        model.addAttribute("user", userDTO);
        List<UserRoleDTO> roles = Arrays.asList(UserRoleDTO.values());
        model.addAttribute("roles", roles);
        return "admin/admin_add_user";
    }

    @PostMapping("/admin/users/{id}/edit")
    public String saveEditedUser(@Valid @ModelAttribute("user") UserDTO user,
                                 BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            UserDTO userCheck = userService.getByLogin(user.getLogin());
            if (userCheck == null || user.getId().equals(userCheck.getId())) {
                userService.update(user);
                return "redirect:/admin/users";
            } else {
                model.addAttribute("message", "User with the same login already exists.");
                return "admin/admin_add_user";
            }
        } else {
            return "admin/admin_add_user";
        }
    }

    //Delete
    @GetMapping("/admin/users/{id}/delete")
    public String deleteUser(Model model, @PathVariable Long id) {
        if (!id.equals(getPrincipal().getUserId())) {
            userService.delete(id);
        }
        return "redirect:/admin/users";
    }

    private UserPrincipal getPrincipal() {
        UserPrincipal user = null;
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != null) {
            user = (UserPrincipal) principal;
        }
        return user;
    }
}
