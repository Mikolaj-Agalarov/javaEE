package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUsersRepository implements UserRepository {

    private final Connection connection;
    private static final String ADD_USER = "INSERT INTO users (name, password) VALUES (?,?)";
    private static final String FIND_USER = "select * from users WHERE name=?";

    public JdbcUsersRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findUsers() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select id, name, password, created_at from users";
            ResultSet rs = statement.executeQuery(sql);
            final List<User> users = new ArrayList<>();
            while (rs.next()) {
                final User user = new User(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getDate("created_at"));
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
            if (!doesUserExists(name)) {
                PreparedStatement statement = connection.prepareStatement(ADD_USER);
                statement.setString(1, name);
                statement.setString(2, password);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean doesUserExists(String name) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_USER)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            return rs.next();
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


