package com.example.skyonite.genshincalculatorpracticesite;


import com.example.skyonite.genshincalculatorpracticesite.model.User;
import com.example.skyonite.genshincalculatorpracticesite.model.enumeration.UserRole;
import com.example.skyonite.genshincalculatorpracticesite.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.skyonite.genshincalculatorpracticesite.model.exceptions.PasswordsDoNotMatchException;
import com.example.skyonite.genshincalculatorpracticesite.model.exceptions.UsernameExistsException;
import com.example.skyonite.genshincalculatorpracticesite.repository.UserRepository;
import com.example.skyonite.genshincalculatorpracticesite.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationTest {

    @Mock
    private UserRepository userRepoTest;
    @Mock
    private PasswordEncoder passwordEncoder;

    private UserServiceImpl userService;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
        User user = new User("username","passowrd", UserRole.ROLE_USER);
        Mockito.when(this.userRepoTest.save(Mockito.any(User.class))).thenReturn(user);
        Mockito.when(this.passwordEncoder.encode(Mockito.anyString())).thenReturn("password");
        this.userService = Mockito.spy(new UserServiceImpl(this.passwordEncoder,this.userRepoTest));
    }


    @Test
    public void testSuccessRegister(){
        User user = this.userService.registerUser("username", "password",
                "password");

        Mockito.verify(this.userService).registerUser("username", "password",
                "password");

        Assert.assertNotNull("User is null", user);
        Assert.assertEquals("roles do not match", UserRole.ROLE_USER, user.getRole());
        Assert.assertEquals("passwords do not match", "password", user.getPassword());
        Assert.assertEquals("usernames do not match", "username", user.getUsername());

    }

    @Test
    public void testNullUsername() {
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsernameOrPasswordException.class,
                () -> this.userService.registerUser(null, "password", "password"));
        Mockito.verify(this.userService).registerUser(null, "password", "password");
    }

    @Test
    public void testEmptyUsername() {
        String username = "";
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsernameOrPasswordException.class,
                () -> this.userService.registerUser(username, "password", "password"));
        Mockito.verify(this.userService).registerUser(username, "password", "password");
    }

    @Test
    public void testEmptyPassword() {
        String username = "username";
        String password = "";
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsernameOrPasswordException.class,
                () -> this.userService.registerUser(username, password, "password"));
        Mockito.verify(this.userService).registerUser(username, password, "password");
    }

    @Test
    public void testNullPassword() {
        String username = "username";
        String password = null;
        Assert.assertThrows("InvalidArgumentException expected",
                InvalidUsernameOrPasswordException.class,
                () -> this.userService.registerUser(username, password, "password"));
        Mockito.verify(this.userService).registerUser(username, password, "password");
    }

    @Test
    public void testPasswordMismatch() {
        String username = "username";
        String password = "password";
        String confirmPassword = "otherPassword";
        Assert.assertThrows("PasswordsDoNotMatchException expected",
                PasswordsDoNotMatchException.class,
                () -> this.userService.registerUser(username, password, confirmPassword));
        Mockito.verify(this.userService).registerUser(username, password, confirmPassword);
    }


    @Test
    public void testDuplicateUsername() {
        User user = new User("username", "password",UserRole.ROLE_USER);
        Mockito.when(this.userRepoTest.findByUsername(Mockito.anyString())).thenReturn(Optional.of(user));
        String username = "username";
        Assert.assertThrows("UsernameAlreadyExistsException expected",
                UsernameExistsException.class,
                () -> this.userService.registerUser(username, "password", "password"));
        Mockito.verify(this.userService).registerUser(username, "password", "password");
    }
}
