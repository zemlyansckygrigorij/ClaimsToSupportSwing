package model;
/**
 * класс для получения настроек из json-файла
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * https://www.chillyfacts.com/java-send-json-request-read-json-response/
 * работа с json файлами
 * библиотеки java-json.jar  и org.apache.commons.io.jar
 * */



import control.ControlDateTime;
import control.WinRegistry;
import view.FrameException;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;



public class Settings {

    private static Map<String, String> settings = new HashMap<String, String>();
    private static String userName = "";
    private static String path =System.getProperty("user.dir");
    static{

        setSettingTest();
      //  setSettingWork();
    }
    private static void setSettingWork(){

        setSettingFromWinRegistry("Server");
        setSettingFromWinRegistry("DirServer");
        setSettingFromWinRegistry("UserName");
        setSetting(path+"\\localSetting.ini");
        settings.put("userName", settings.get("UserName"));
    }
    private static void setSettingFromWinRegistry(String valueName){
        String value = null;                                              //ValueName
        try {
            value = WinRegistry.readString(
                    WinRegistry.HKEY_CURRENT_USER,                             //HKEY
                    "SOFTWARE\\CRAT-SUCCI",           //Key
                    valueName);
            settings.put(valueName,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    private static void setSettingTest(){
        setSetting(path+"\\localSettingTest.ini");
    }
    private static void setSetting(String path){
        try {
            FileInputStream inF = new FileInputStream(path);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inF,"Cp1251"));
            String  line= "";
            while ((line = bufferedReader.readLine()) != null ) {
                String[] ary = line.split("=");
                if(ary.length>1){
                    settings.put(ary[0].trim(), ary[1].trim());
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            JFrame myWindow = new FrameException(" файл "+path+ "не найден !!!");
            Settings.writeError(e);
            e.printStackTrace();

        }
        catch (IOException e) {
            JFrame myWindow = new FrameException(" Ошибка связи !!!");
            Settings.writeError(e);
            e.printStackTrace();
        }
    }



    public static Map<String, String> getSettings(){
        return  settings;
    }

    public static  void setUserName(String userName){Settings.userName = userName;}

    public static  String getUserName() { return Settings.userName ;}

    public static void writeError(Exception e){

        Path pathError = Paths.get(path+"\\error\\");

        if (!Files.exists(pathError)) {
            try {
                Files.createDirectories(pathError);
            } catch (IOException ex) {
                JFrame myWindow = new FrameException(" Ошибка связи !!!");

                ex.printStackTrace();

            }
        }

        String filename= pathError+"\\"+userName+"-" +new ControlDateTime("dd-MM-yyyy hh-mm").getDateTime()+".txt";
        File file = new File(filename);
        if(!file.exists()){
            try {
                Files.createFile(Paths.get(path+"\\programmError.txt"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(filename));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        e.printStackTrace(pw);
        pw.close();

    }
}
