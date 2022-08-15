package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS kata.users (\n" +
                "  id INT NOT NULL AUTO_INCREMENT,\n" +
                "  name VARCHAR(45) NOT NULL,\n" +
                "  lastName VARCHAR(45) NOT NULL,\n" +
                "  age INT NOT NULL,\n" +
                "  PRIMARY KEY (id));";
        try (Connection dbConnection = Util.getDBConnection();
             Statement statement = dbConnection.createStatement()) {
            dbConnection.setAutoCommit(false);
            statement.execute(createTableSQL);
            dbConnection.commit();
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String dropTable = "DROP TABLE IF EXISTS kata.users;";
        try (Connection dbConnection = Util.getDBConnection();
             Statement statement = dbConnection.createStatement()) {
            dbConnection.setAutoCommit(false);
            statement.execute(dropTable);
            dbConnection.commit();
            System.out.println("Table dropped");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String createUserSQL = String.format("INSERT INTO kata.users (name, lastname, age) VALUES (\"%s\", \"%s\",\"%s\");", name, lastName, age);
        try (Connection dbConnection = Util.getDBConnection();
             Statement statement = dbConnection.createStatement()) {
            dbConnection.setAutoCommit(false);
            statement.execute(createUserSQL);
            dbConnection.commit();
            System.out.printf("User with name - %s added into DB\n", name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String removeUserSQL = String.format("DELETE FROM kata.users WHERE id=%s", id);
        try (Connection dbConnection = Util.getDBConnection();
             Statement statement = dbConnection.createStatement()) {
            dbConnection.setAutoCommit(false);
            statement.execute(removeUserSQL);
            dbConnection.commit();
            System.out.println("User removed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        String getAllUsersSQL = "SELECT * FROM kata.users";
        List<User> list = new ArrayList<>();
        try (Connection dbConnection = Util.getDBConnection();
             Statement statement = dbConnection.createStatement()) {
            dbConnection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery(getAllUsersSQL);
            dbConnection.commit();
            while (resultSet.next()) {
                list.add(new User(resultSet.getString("name"), resultSet.getString("lastName"), (byte) resultSet.getInt("age")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cleanUsersTable() {
        String truncateSQL = "TRUNCATE TABLE kata.users;";
        try (Connection dbConnection = Util.getDBConnection();
             Statement statement = dbConnection.createStatement()) {
            dbConnection.setAutoCommit(false);
            statement.execute(truncateSQL);
            dbConnection.commit();
            System.out.println("Table truncated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
