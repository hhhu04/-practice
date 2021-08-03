package com.example.security.signup;

import com.example.security.account.Account;
import com.example.security.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignController {

    private final AccountService accountService;

    @GetMapping
    public String signupForm(Model model){
        model.addAttribute("account",new Account());
        return "signup";
    }

    @PostMapping
    public String processSignup(@ModelAttribute Account account){
        account.setRole("USER");
        accountService.createNew(account);
        return "redirect:/";
    }


}
