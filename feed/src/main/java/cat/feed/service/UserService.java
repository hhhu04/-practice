package cat.feed.service;

import cat.feed.entity.User;
import cat.feed.jwt.JwtTokenProvider;
import cat.feed.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService  {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public boolean checkUser(User user){
        return userRepository.existsByUserId(user.getUserId());
    }

    public void userJoin(User user) throws Exception{
        user = user.userJoin(user,passwordEncoder);
        userRepository.save(user);
    }


    public String createToken(User user) throws Exception{
        User user2 = userRepository.findByUserIdAndPassword(user.getUserId(),user.getPassword());
        System.out.println("123");
//        if (passwordEncoder.encode(user.getPassword()).equals(user2.getPassword())) {
//            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
//        }
            return jwtTokenProvider.createToken(user.getUserId(), user.getRoles());
    }
}
