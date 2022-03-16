package com.example.skyonite.genshincalculatorpracticesite.service;

import com.example.skyonite.genshincalculatorpracticesite.model.User;
import com.example.skyonite.genshincalculatorpracticesite.model.enumeration.UserRole;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User registerUser(String username, String password, String repeatpassword);
    User registerAdmin(String username, String password, String repeatpassword);
}
