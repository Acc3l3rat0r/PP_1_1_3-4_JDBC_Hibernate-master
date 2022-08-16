package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*UserServiceImpl impl = new UserServiceImpl();

        //Создание таблицы User(ов)
        impl.createUsersTable();

        //Добавление 4 User(ов) в таблицу
        for(int i = 0; i<4;i++){
            impl.saveUser("user","resu", (byte) 5);
        }

        //Получение всех User из базы и вывод в консоль
        List<User> list = impl.getAllUsers();
        list.forEach(System.out::println);

        //Очистка таблицы User(ов)
        impl.cleanUsersTable();

        //Удаление таблицы
        impl.dropUsersTable();*/


        UserDaoHibernateImpl hbr = new UserDaoHibernateImpl();
        //hbr.createUsersTable();
        //hbr.dropUsersTable();
        //hbr.saveUser("lol","kek", (byte) 15);
    }
}
