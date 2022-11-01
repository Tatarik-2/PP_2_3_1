package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
//    void createUsersTable();

//    void dropUsersTable();

    void saveUser(User user);

    void update(int id, User user);

    User get(int id);

    void removeUserById(int id);

    List<User> getAllUsers();

//    void cleanUsersTable();
}
