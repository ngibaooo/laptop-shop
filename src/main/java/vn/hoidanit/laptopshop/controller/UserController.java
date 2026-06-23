package vn.hoidanit.laptopshop.controller;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping("/")
    public String getHomePage(Model model){
        List<User> users = this.userService.getAllUsersByEmail("ngbao840@gmail.com");
        // model.addAttribute("Bao", test); 
        System.out.println("User List: " + users);
        return "hello";
    }

    @RequestMapping("/admin/users")
    public String getAllUsers(Model model){
        List<User> users = this.userService.getAllUsers();
        System.out.println("All Users: " + users);
        // model đùng dể truyền biến users: gồm tất cả user mà nhận được từ repo query trong db qua cho biến users_list
        model.addAttribute("users_list", users);
        return "admin/user/users_list";
    }
    
    @RequestMapping ("/admin/user/{id}")
    public String getUserDetail(Model model, @PathVariable long id){
        User user = this.userService.getUserById(id);
        System.out.println("check path: " + id); //in path ra terminal để biết được controller đã lấy thành công id người dùng từ jsp
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "admin/user/user-details";
    }

    @RequestMapping("/admin/user/create") //method GET
    public String getCreateUser(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    @RequestMapping(value="/admin/user/create", method=RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("newUser") User bao) {
        this.userService.handleSaveUser(bao);
        return "redirect:/admin/users";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUser(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("currentUser", currentUser);
        return "/admin/user/update";
    }
    @PostMapping("/admin/user/update")
    public String updateUser(Model model, @ModelAttribute("currentUser") User bao) {
        User currentUser = this.userService.getUserById(bao.getId()); //currentUser là user thật hiện tại được lấy từ database
                                                                    //bao là user được lấy từ form nhập dữ liệu ở giao diện frontend
        if(currentUser != null){ //nếu repo tìm thấy user có id đó trong database thì set các data hiện tại của user thành data được nhập ở form update
            // currentUser.setEmail(bao.getEmail()); //do email bị disabled nên không cần update nó. Mặc định là data hiện tại
            currentUser.setPhone(bao.getPhone());
            currentUser.setFullName(bao.getFullName());
            currentUser.setAddress(bao.getAddress());            
        }
        this.userService.handleSaveUser(currentUser);                  
        return "redirect:/admin/users";
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
