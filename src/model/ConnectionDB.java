package model;

import view.FrameException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/**
 * класс для установки связи с базой данных через jdbc соединение
 * все необходимые данные беруться из класс Settings
 *
 * */

public class ConnectionDB {
    private static Connection connection;
    private static String dbName ;
    private static String userName ;
    private static String host  ;
    private static String port ;
    private static String password  ;
    private static boolean autoReconnect = true;
    private static boolean useSSL = false;
    private static boolean isConnect = false;
    static{
        Map<String, String> settings = Settings.getSettings();
        dbName = settings.get("dBName");
        userName  = settings.get("userDataBase");
        host = settings.get("Server");//settings.get("host");
        port = settings.get("port");
        password = settings.get("passwordDB");
    }


    public static void setSetting(String dbName, String userName, String password, String host, String port){
        ConnectionDB.dbName = dbName;
        ConnectionDB.userName = userName;
        ConnectionDB.password = password;
        ConnectionDB.host = host;
        ConnectionDB.port = port;
    }


    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbName+ "?autoReconnect="+autoReconnect+"&useSSL="+useSSL   , userName, password);
            ConnectionDB.setConnect(true);
        } catch (ClassNotFoundException e) {
            JFrame myWindow = new FrameException(" Отсутствует файл  mysql-connector-java!!!");
            Settings.writeError(e);
            e.printStackTrace();
        } catch (SQLException e) {
            JFrame myWindow = new FrameException(" Ошибка подключения к базе данных !!!");
            Settings.writeError(e);
            e.printStackTrace();
        }
        return connection;
    }


    public static boolean isConnect(){
        return  ConnectionDB.isConnect;
    }
    private static void setConnect(boolean connect){
        ConnectionDB.isConnect = connect;
    }
}
