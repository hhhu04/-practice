package cat.feed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class BaseController {

    @GetMapping("/")
    public String main(Model model, Principal principal){
        if(principal != null) model.addAttribute("user",principal.getName());
        else model.addAttribute("user","손님");
        return "main";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }


}
