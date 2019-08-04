package control;
/**
 * @author Землянский Григорий Михайлович
 * @version 1.7
 *
 * класс для запуска программы TeamViewer
 *
 */
import model.Settings;
import view.FrameException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ControlTeamViewer {
    private static String path = System.getProperty("user.dir");
    private ControlTeamViewer(){}
    public static void runTeamviewer(){
        try {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command(path +"\\TeamViewerQS.exe");
            pb.start();
            JFrame myWindow = new FrameException("Подождите запускается программа!!!");
        }
        catch (IOException e) {
            JFrame myWindow = new FrameException(" Ошибка программы !!!");
            Settings.writeError(e);
            e.printStackTrace();
        }
    }

    //свернуть все окна
    public static void minimazeAllWindows(){
        try {
            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_WINDOWS);
            rb.keyPress(KeyEvent.VK_D);
            rb.keyRelease(KeyEvent.VK_WINDOWS);
            rb.keyRelease(KeyEvent.VK_D);
        }
        catch (AWTException e) {

            JFrame myWindow = new FrameException(" Ошибка AWT !!!");
            Settings.writeError(e);
            e.printStackTrace();
        };
    }
}