package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
//    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//    private final UserDAOImpl userDAO;
//
//    public UserController(UserDAOImpl userDAO) {
//        this.userDAO = userDAO;
//    }

    @GetMapping
    public String start(){
        System.out.println(userService.getAllUsers());
        return "user/start";
    }

    @GetMapping("/get")
    public String getAllUsers(Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "user/showUsers";
    }
    @GetMapping("/add_user")
    public String addUser(@ModelAttribute("user") User user){
//        model.addAttribute("user", new User());
        return "user/addUser";
    }
    @PostMapping("/get")
    public String create(@ModelAttribute("user") User user){
//        user.setId(2);
        userService.createUser(user);
        return "redirect:/users/get";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users/get";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute(userService.get(id));
        return "user/updateUser";
    }

    @PostMapping("/update/{id}")
    public String update_2(@PathVariable("id") int id, User user){
        userService.update(id, user);
        return "redirect:/users/get";
    }
}
