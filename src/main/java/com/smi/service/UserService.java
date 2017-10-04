package com.smi.service;

import com.smi.model.Users;
import java.util.List;

/**
 *
 * @author Nejm
 */
public interface UserService {

    Users findById(long id);

    Users findByUsername(String username);

    List<Users> findAll();

    Long addUser(Users user);

    void editUser(Users user);

    void deleteUser(Users user);
}
