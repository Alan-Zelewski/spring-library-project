package com.azelewski.springproject.service;

import com.azelewski.springproject.infrastructure.UserDTO;
import com.azelewski.springproject.model.User;
import com.azelewski.springproject.model.UserRole;
import com.azelewski.springproject.repository.UserRepository;
import com.azelewski.springproject.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void saveUser(User user) {
        userRepository.save(user);
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

    public User findById(Long id) {
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }else{
            throw new RuntimeException("User of Id " + id + " not found");
        }
    }


    public List<User> searchUsers(String searchValue) {
        return userRepository.findUsersBySearchValue(searchValue);
    }
}
