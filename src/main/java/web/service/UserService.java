package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void createUser(User user);

    User get(int id);
//
    void update(int id, User updatedUser);
//
    void delete(int id);
}
