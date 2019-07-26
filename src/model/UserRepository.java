package model;



import view.FrameException;

import javax.swing.*;
import java.util.HashSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class UserRepository {
    private static Set<String> userSet = new HashSet<String>();
    static{
        Connection connection = ConnectionDB.getConnection();
        try (Statement statement = connection.createStatement()) {
            String selectUser = "SELECT Alias FROM crat.UsersDb ;";
            ResultSet resultSetUser = statement.executeQuery(selectUser);
            while ( resultSetUser.next()) {
                //создаем обьект -клиент
                userSet.add(resultSetUser.getString(1));
            }
        } catch (SQLException e) {
            JFrame myWindow = new FrameException(" Отсутствует подключение к ббазе данных !!!");
            Settings.writeError(e);
            e.printStackTrace();
        }
    }
    private UserRepository(){}

    public static Set<String> getUserSet(){
        return userSet;
    }
    public static boolean checkUser(String user){
        return userSet.contains(user);
    }

}
