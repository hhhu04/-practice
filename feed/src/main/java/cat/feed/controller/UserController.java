package cat.feed.controller;

import cat.feed.entity.User;
import cat.feed.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 1:성공 -1:아디중복

    @PostMapping("/user/join")
    @ResponseBody
    public int join(@RequestBody User user){
        if(!userService.checkUser(user)) {
            try {
                userService.userJoin(user);
                return 1;
            }catch (Exception e){
                return -2;
            }
        }
        else return -1;
    }

    @PostMapping("/user/login")
    @ResponseBody
    public String login(@RequestBody User user){
        if(userService.checkUser(user)) {
            try{
                String token = userService.createToken(user);
                System.out.println(token);
                return token;
            }catch (Exception e)
            {
                return "error";
            }
        }
        return "존재하지 않는 계정입니다.";

    }


}
