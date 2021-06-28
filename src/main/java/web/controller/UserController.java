package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/users")
@Transactional
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/adduser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edituser")
    public String editUser(Model model,
                           @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edituser";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.editUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(userService.getUser(id));
        return "redirect:/users";
    }
}