package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl usr = new UserDaoJDBCImpl();
        usr.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl usr = new UserDaoJDBCImpl();
        usr.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl usr = new UserDaoJDBCImpl();
        usr.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl usr = new UserDaoJDBCImpl();
        usr.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl usr = new UserDaoJDBCImpl();
        return usr.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl usr = new UserDaoJDBCImpl();
        usr.cleanUsersTable();
    }
}
