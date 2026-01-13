package com.duclm.minitaxi.service;

import com.duclm.minitaxi.dto.RegisterRequest;
import com.duclm.minitaxi.dto.UpdateUserRequest;
import com.duclm.minitaxi.model.User;

import java.util.List;

public interface UserService {
    User create(RegisterRequest request);
    List<User> getAll();
    User getById(Long id);
    User update(Long id, UpdateUserRequest request);
    void delete(Long id);
    void changePassword(Long id, String newPassword);
}