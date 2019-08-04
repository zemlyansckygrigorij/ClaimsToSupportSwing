package model;

import test.ControlTest;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ControlMenu {
    private static String path = System.getProperty("user.dir");
    public static void getHtmlForUser(){

        File htmlFile = new File(path+"/help.html");
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getHtmlForAdmin(){

        File htmlFile = new File(path+"/helpAdmin.html");
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runTest(){
        ControlTest.runTest();
    }
}
