package wonderlist.wonderlist.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import wonderlist.wonderlist.model.User;
import wonderlist.wonderlist.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
    User save (UserRegistrationDto registrationDto);
}
