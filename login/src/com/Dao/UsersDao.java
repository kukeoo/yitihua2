package com.Dao;

import com.Entity.User;

public interface UsersDao {
    public boolean addUser(User user);
    public boolean checkUsername(String username);
    public boolean checkPassword(String username,String password);
}
