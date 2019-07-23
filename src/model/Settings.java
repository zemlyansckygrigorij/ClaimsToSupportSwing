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



import view.FrameException;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



public class Settings {

    private static Map<String, String> settings = new HashMap<String, String>();
    private static String userName = "";
    static{
        String path =System.getProperty("user.dir");

        try {
            FileInputStream inF = new FileInputStream(path+"\\localSetting.ini");
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
            JFrame myWindow = new FrameException(" файл localSetting.ini не найден !!!");
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
        String path = System.getProperty("user.dir");
        String filename= path+"\\programmError.txt";
        File file = new File(path+"\\programmError.txt");
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
