package view;

import javax.swing.*;

import model.UserName;
public class TextFieldUserName extends JTextField {
    public TextFieldUserName(){
        this.setText( UserName.getUserName());
    }
}