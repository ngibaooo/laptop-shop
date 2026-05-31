package vn.hoidanit.laptopshop.controller;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping("/")
    public String getHomePage(Model model){
        String test = this.userService.handleHello();
        model.addAttribute("Bao", test);
        return "hello";
    }
    
    @RequestMapping("/admin/user")
    public String getCreateUser(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    @RequestMapping(value="/admin/user/create", method=RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("newUser") User bao) {
        System.out.println("User was created: " + bao);
        return "hello";
    }
    
}

// @RestController
// public class UserController {
//     private UserService userService;

//     public UserController(UserService userService){
//         this.userService = userService;
//     }
    
//     @GetMapping("")
//     public String getHomePage(){
//         return this.userService.handleHello();
//     }
// }
