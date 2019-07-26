package view;

import javax.swing.*;

import model.Settings;
import model.UserName;

import java.io.UnsupportedEncodingException;

public class TextFieldUserName extends JTextField {
    public TextFieldUserName(){
       String text =Settings.getSettings().get("UserName");
        byte[] array = new byte[0];
        try {
            System.out.println("Server - " +Settings.getSettings().get("Server"));
            array = text.getBytes("UTF-32");
            System.out.println(new String(array) );
            this.setText(UserName.getUserName());
            System.out.println("arra - " +array[0]);
            System.out.println("arra - " +array[1]);
            System.out.println("arra - " +array[2]);
            System.out.println("arra - " +array[3]);
            System.out.println("(char) arra - "+(char) array[0]);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}