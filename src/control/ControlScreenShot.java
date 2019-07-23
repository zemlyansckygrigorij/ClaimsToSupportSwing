package control;

import model.Settings;
import view.FrameException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.*;
import java.util.*;


public class ControlScreenShot {
    private static String path = System.getProperty("user.dir");
    private static Path pathPictures = Paths.get(path+"\\pictures\\");
    private static String pictureName = "";


    public static File getScreenShot(){
        checkFolderPictures();
        Robot robot = null;
        File image =  new File(path+"\\pictures\\"+getPictureName());
        try {
            robot = new Robot();
        } catch (AWTException e) {
            JFrame myWindow = new FrameException(" Ошибка программы !!!");
            Settings.writeError(e);
            e.printStackTrace();
        }
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        try {

            ImageIO.write(screenShot, "JPG", image);
        } catch (IOException e) {
            JFrame myWindow = new FrameException(" Ошибка связи !!!");
            Settings.writeError(e);
            e.printStackTrace();

        }
        return image;
    }

    private static void checkFolderPictures(){
        if (!Files.exists(pathPictures)) {
            try {
                Files.createDirectories(pathPictures);
            } catch (IOException e) {
                JFrame myWindow = new FrameException(" Ошибка связи !!!");
                Settings.writeError(e);
                e.printStackTrace();

            }
        }
    }
    private static String getPictureName(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
        Calendar now = Calendar.getInstance();
        pictureName =  formatter.format(now.getTime())+".jpg";
        return pictureName;
    }

}
