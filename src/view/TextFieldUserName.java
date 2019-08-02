package view;
/**
 * @author Землянский Григорий Михайлович
 * @version 1.7
 * класс пользовательского интерфейса пользователя
 *
 * поле текущего пользователя
 *
 * */
import javax.swing.*;
import model.Settings;

public class TextFieldUserName extends JTextField {
    public TextFieldUserName()
    {
        this.setText(Settings.getSettings().get("UserName"));
    }
}