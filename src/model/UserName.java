package model;

import view.FrameException;

import javax.swing.*;
import java.io.*;
import java.util.*;
public class UserName {
    private static String userName;
    private static String path = System.getProperty("user.dir");
    static{

        try {
            FileInputStream inF = new FileInputStream(path+"/user.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inF,"Cp1251"));
            userName = "";
            while ((userName = bufferedReader.readLine()) != null ) {
                break;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JFrame myWindow = new FrameException(" файл user.txt не найден !!!");
            Settings.writeError(e);
        }
        catch (IOException e) {
            e.printStackTrace();
            JFrame myWindow = new FrameException(" Ошибка связи !!!");
            Settings.writeError(e);
        }

    }
    public static String getUserName(){
        return userName;
    }
}
