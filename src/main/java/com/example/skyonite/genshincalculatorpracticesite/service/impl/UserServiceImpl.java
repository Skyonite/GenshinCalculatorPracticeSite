package com.example.skyonite.genshincalculatorpracticesite.service.impl;

import com.example.skyonite.genshincalculatorpracticesite.model.User;
import com.example.skyonite.genshincalculatorpracticesite.model.enumeration.UserRole;
import com.example.skyonite.genshincalculatorpracticesite.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.skyonite.genshincalculatorpracticesite.model.exceptions.PasswordsDoNotMatchException;
import com.example.skyonite.genshincalculatorpracticesite.model.exceptions.UsernameExistsException;
import com.example.skyonite.genshincalculatorpracticesite.repository.UserRepository;
import com.example.skyonite.genshincalculatorpracticesite.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public User registerUser(String username, String password, String repeatpassword ) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if(!password.equals(repeatpassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameExistsException();
        User user = new User(username,passwordEncoder.encode(password),UserRole.ROLE_USER);
        userRepository.save(user);
        return user;
    }

    @Override
    public User registerAdmin(String username, String password, String repeatpassword ) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if(!password.equals(repeatpassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameExistsException();
        User user = new User(username,passwordEncoder.encode(password),UserRole.ROLE_ADMIN);
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
