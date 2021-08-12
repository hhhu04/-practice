package cat.feed.repository;

import cat.feed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserId(String userId);

    User findByUserIdAndPassword(String userId,String password);

    Optional<User> findByUserId(String username);
}
