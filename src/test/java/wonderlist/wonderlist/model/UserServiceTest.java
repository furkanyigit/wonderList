package wonderlist.wonderlist.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import wonderlist.wonderlist.repository.UserRepository;
import wonderlist.wonderlist.service.UserServiceImpl;

import java.util.ArrayList;

public class UserServiceTest {

    private UserServiceImpl userService;
    private UserRepository userRepository;


    @BeforeEach
    public void setUp() throws Exception {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void whenUserCalledWithValidRequest_itShouldReturnValidUser(){
        final String userName = "furkan@mail.com";
        User user = new User("furkan",
                "yigit",
                   userName,
                "1234",
                new ArrayList<>());
       Mockito.when(userRepository.findByUserEmail(userName)).thenReturn(user);
       UserDetails userDetails = userService.loadUserByUsername(userName);

       Assertions.assertEquals(userName, userDetails.getUsername());
       Assertions.assertEquals(user.getPassword(), userDetails.getPassword());
    }

    @Test
    public void whenUserCalledWithNullRequest_itShouldThrowsException(){
        final String userName = null;
        Mockito.when(userRepository.findByUserEmail(userName)).thenReturn(null);

        UsernameNotFoundException exception = Assertions.assertThrows(
                UsernameNotFoundException.class, () -> {
                    userService.loadUserByUsername(userName);
        });
       Assertions.assertEquals("Invalid username and password", exception.getMessage());

    }


    @AfterEach
    public void tearDown() {
    }
}