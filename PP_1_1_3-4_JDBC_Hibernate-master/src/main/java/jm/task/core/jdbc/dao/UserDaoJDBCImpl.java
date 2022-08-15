package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
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
            statement.execute(createTableSQL);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String dropTable = "DROP TABLE IF EXISTS `kata`.`users`;";
        try (Connection dbConnection = Util.getDBConnection();
             Statement statement = dbConnection.createStatement()) {

            statement.execute(dropTable);
            System.out.println("Table dropped");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String createUserSQL = String.format("INSERT INTO kata.users (name, lastname, age) VALUES (\"%s\", \"%s\",\"%s\");",name,lastName,age);
        try (Connection dbConnection = Util.getDBConnection();
             Statement statement = dbConnection.createStatement()) {

            statement.execute(createUserSQL);
            System.out.println("User successfully added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
