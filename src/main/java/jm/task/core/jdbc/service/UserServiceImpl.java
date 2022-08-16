package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl usr = new UserDaoJDBCImpl();
    private UserDaoHibernateImpl hbr = new UserDaoHibernateImpl();

    public void createUsersTable() {
        //usr.createUsersTable();
        hbr.createUsersTable();
    }

    public void dropUsersTable() {
        //usr.dropUsersTable();
        hbr.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        //usr.saveUser(name,lastName,age);
        hbr.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        //usr.removeUserById(id);
        hbr.removeUserById(id);
    }

    public List<User> getAllUsers() {
        //return usr.getAllUsers();
        return hbr.getAllUsers();
    }

    public void cleanUsersTable() {
        //usr.cleanUsersTable();
        hbr.cleanUsersTable();
    }
}
