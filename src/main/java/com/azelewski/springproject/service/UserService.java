package com.azelewski.springproject.service;

import com.azelewski.springproject.exception.UserAlreadyExistsException;
import com.azelewski.springproject.infrastructure.UserDTO;
import com.azelewski.springproject.model.User;
import com.azelewski.springproject.model.UserRole;
import com.azelewski.springproject.repository.UserRepository;
import com.azelewski.springproject.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }

    public boolean checkIfUserAlreadyExist(UserDTO userDTO) {
        if (emailExists(userDTO.getEmail())) {
            return true;
        }
        if (usernameExists(userDTO.getUsername())) {
            return true;
        }
        return false;
    }
    public void save(UserDTO userDTO){
        User user = new User();
        UserRole role = userRoleRepository.findUserRoleByRole("USER");
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(Set.of(role));
        userRepository.save(user);
    }
    public boolean emailExists(String email){
        return userRepository.findByEmail(email).isPresent();
    }
    public boolean usernameExists(String username){
        return userRepository.findByUsername(username).isPresent();
    }
}
