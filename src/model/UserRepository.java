package model;
import view.FrameException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserRepository {
    private static Map<String, User> userMap = new HashMap<String, User>();
    private static String querySQL = "SELECT USer, TelE,EmailE, Empl.NameE, Empl.NameE2 , Empl.NameE3  FROM cratu.user inner JOIN crat.usersdb ON user.USer = usersdb.Alias inner JOIN crat.Empl ON usersdb.idEmpl = Empl.idEmpl;";
    static{
        Connection connection = ConnectionDB.getConnection();
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSetUser = statement.executeQuery(querySQL);
            while ( resultSetUser.next()) {
                User user = new User(resultSetUser.getString(1));
                String phone = resultSetUser.getString(2);
                String email = resultSetUser.getString(3);
                String fullName =  resultSetUser.getString(4) +" "+ resultSetUser.getString(5)+" "+   resultSetUser.getString(6);
                if(phone != null){
                    user.setPhone(resultSetUser.getString(2));
                }
                if(email != null){
                    user.setEmail(resultSetUser.getString(3));
                }
                if(fullName != null){
                    user.setFullName(fullName);
                }

                //создаем обьект -клиент
                userMap.put(user.getName(),user);
            }
        } catch (SQLException e) {
            JFrame myWindow = new FrameException(" Отсутствует подключение к ббазе данных !!!");
            Settings.writeError(e);
            e.printStackTrace();
        }
    }
    private UserRepository(){}

    public static Map<String, User> getUserMapuserMap(){
        return userMap;
    }

    public static boolean checkUser(String user){
        if (userMap.containsKey(user)){
            return true;
        }
        return false;
    }
    public static User getUser(String userName){

        if (userMap.containsKey(userName)){
            return userMap.get(userName);
        }
        return null;
    }
}
