package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

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

        executeSQL(createTableSQL);
        System.out.println("Table created");
    }

    public void dropUsersTable() {
        String dropTable = "DROP TABLE IF EXISTS kata.users;";
        executeSQL(dropTable);
        System.out.println("Table dropped");
    }

    public void saveUser(String name, String lastName, byte age) {
        String createUserSQL = String.format("INSERT INTO kata.users (name, lastname, age) VALUES (\"%s\", \"%s\",\"%s\");", name, lastName, age);
        executeSQL(createUserSQL);
        System.out.printf("User with name - %s added into DB\n", name);
    }

    public void removeUserById(long id) {
        String removeUserSQL = String.format("DELETE FROM kata.users WHERE id=%s", id);
        executeSQL(removeUserSQL);
        System.out.println("User removed");
    }

    public List<User> getAllUsers() {
        String getAllUsersSQL = "SELECT * FROM kata.users";
        List<User> list = new ArrayList<>();

        Connection dbConnection = null;
        Statement statement;

        try {
            dbConnection = Util.getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsersSQL);
            while (resultSet.next()) {
                list.add(new User(resultSet.getString("name"), resultSet.getString("lastName"), (byte) resultSet.getInt("age")));
            }
        } catch (SQLException e) {
            try { dbConnection.rollback(); } catch (SQLException ex) {System.out.println(ex.getMessage());}
            System.out.println(e.getMessage());
        } finally {
            if (dbConnection != null) try {dbConnection.close();} catch (SQLException e) {System.out.println(e.getMessage());}
        }
        return list;
    }

    public void cleanUsersTable() {
        String truncateSQL = "TRUNCATE TABLE kata.users;";
        executeSQL(truncateSQL);
        System.out.println("Table truncated");
    }

    private void executeSQL(String sql) {
        try (Connection dbConnection = Util.getDBConnection()) {
            try (Statement statement = dbConnection.createStatement()) {
                statement.execute(sql);
            } catch (SQLException e) {
                dbConnection.rollback();
                System.out.println(e.getMessage());
            }
            dbConnection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
