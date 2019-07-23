package control;

import model.Settings;
import view.FrameException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlTeamViewer {
    private static String path = System.getProperty("user.dir");
    public static void runTeamviewer(){
        try {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command(path +"\\TeamViewerQS.exe");
            pb.start();
        }
        catch (Exception e) {
            JFrame myWindow = new FrameException(" Ошибка программы !!!");
            Settings.writeError(e);
        }
    }
    public static void minimazeAllWindows(){
        try {
            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_WINDOWS);
            rb.keyPress(KeyEvent.VK_D);
            rb.keyRelease(KeyEvent.VK_WINDOWS);
            rb.keyRelease(KeyEvent.VK_D);
        }
        catch (AWTException e) {
            System.err.println("robot");
            JFrame myWindow = new FrameException(" Ошибка AWT !!!");
            Settings.writeError(e);
        };
    }
}
