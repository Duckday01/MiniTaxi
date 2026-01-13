package com.duclm.minitaxi.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duclm.minitaxi.dto.RegisterRequest;
import com.duclm.minitaxi.dto.UpdateUserRequest;
import com.duclm.minitaxi.model.Role;
import com.duclm.minitaxi.model.User;
import com.duclm.minitaxi.repository.RoleRepository;
import com.duclm.minitaxi.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User create(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getEmail(),
                request.getPhone(),
                request.getAddress()
        );

        Role customerRole = roleRepository.findByName("CUSTOMER")
            .orElseThrow(() -> new RuntimeException("ROLE CUSTOMER not found"));
        user.getRoles().add(customerRole);
        return userRepository.save(user);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }



    @Override
    public User update(Long id, UpdateUserRequest request) {

        User user = getById(id);

        if (request.getEnabled() != null) {
            user.setEnabled(request.getEnabled());
        }

        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }

        if (request.getPhone() != null) {
            user.setPhone(request.getPhone());
        }

        if (request.getAddress() != null) {
            user.setAddress(request.getAddress());
        }

        return userRepository.save(user);
    }


    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public void changePassword(Long id, String newPassword) {
        User user = getById(id);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

}
