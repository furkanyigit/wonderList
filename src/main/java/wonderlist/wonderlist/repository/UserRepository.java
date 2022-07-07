package wonderlist.wonderlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wonderlist.wonderlist.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String email);

}
