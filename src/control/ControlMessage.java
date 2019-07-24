package control;

import model.MessageEMAIL;

import model.Settings;
import model.UserRepository;
import view.FrameException;

import javax.swing.*;


public class ControlMessage {

    public static void sendMessage(String userName,String text){
        if(!UserRepository.checkUser(userName.trim())){
            JFrame myWindow = new FrameException("Такого пользователя нет !!!");
            return;
        }
        Settings.setUserName(userName.trim());
        ControlTeamViewer.runTeamviewer();
        Settings.writeError(new Exception());
        // задержка времени
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            JFrame myWindow = new FrameException("Ошибка прерывания !!!");
            Settings.writeError(e);
            e.printStackTrace();
        }


        new MessageEMAIL(new ControlDateTime("dd.MM.yyyy hh-mm").getDateTime() +"-"+userName+"-"+text ,ControlScreenShot.getScreenShot());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            JFrame myWindow = new FrameException("Ошибка прерывания !!!");
            Settings.writeError(e);

            e.printStackTrace();
        }


        //свертывание программы  путем нажатия кнопок WINDOWS +M
        ControlTeamViewer.minimazeAllWindows();
    }


}
