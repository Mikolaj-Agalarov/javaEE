package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUsersRepository implements UserRepository {

    private final Connection connection;

    private static final String SHOW_All_USERS = "SELECT name,password FROM users";
    private static final String ADD_USER = "INSERT INTO users (name, password) VALUES (?,?)";
    private static final String GET_USER = "select name, password from users where name = ?";
    private static final String FIND_USER = "select * from users WHERE name=? AND password=?";

    public JdbcUsersRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findUsers() {
        try {
            Statement statement = connection.createStatement();
            String sql = "Select name from users";
            ResultSet rs = statement.executeQuery(sql);
            final List<User> users = new ArrayList<>();
            while (rs.next()) {
                final User user = new User(rs.getString("name"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUser(String name, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_USER);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean doesUserExists(String name, String password) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_USER)) {
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> filterUsers(String prefix) {
        return findUsers().stream()
                .filter(user -> user.getName().startsWith(prefix)).toList();
    }
}


