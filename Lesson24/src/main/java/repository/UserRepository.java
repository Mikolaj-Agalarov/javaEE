package repository;

import model.User;

import java.util.List;

public interface UserRepository {

    List<User> findUsers();

    void addUser(String name, String password);

    boolean doesUserExists(String name);

    List<User> filterUsers(String prefix);
}
