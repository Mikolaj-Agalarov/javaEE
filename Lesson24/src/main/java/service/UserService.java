package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsers() {
        return userRepository.findUsers();
    }

    public void addUser(String name, String password) {
        userRepository.addUser(name, password);
    }

    public boolean doesUserExists(String name, String password) {
        return userRepository.doesUserExists(name, password);
    }

    public List<User> filterUsers(String prefix) {
        return userRepository.filterUsers(prefix);
    }

}
