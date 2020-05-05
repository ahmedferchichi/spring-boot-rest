package com.devglan.service;

import com.devglan.model.user.User;
import com.devglan.model.user.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();

   // User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
    
	void delete(int id);
}
