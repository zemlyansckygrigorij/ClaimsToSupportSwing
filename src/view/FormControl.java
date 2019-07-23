package view;

import javax.swing.*;

import control.ControlMessage;
import model.ListError;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FormControl extends JFrame {
    Set<String> errors = new ListError().getListError();

    JButton sendClaim  = new JButton("Отправить заявку");
    JButton getSupport  = new JButton("Подключить тех.поддержку");
    JList listError = new JList(errors.toArray());
    JLabel selectError = new JLabel("Выберите ошибку");
    JLabel labelAdditionalInformation = new JLabel("Введите дополнительную информацию");
    JLabel warning = new JLabel("эту кнопку нажимать только после \n звонка из тех.поддержки ->" );
    JLabel labelUserName = new JLabel("Пользователь" );
    JLabel messageForUser = new JLabel("");
    JTextField userName = new TextFieldUserName();
    JTextArea additionalInformation = new JTextArea();

    JPanel panel = new JPanel();
    Container cp = getContentPane();
    JMenu helpMenu = new  JMenu("help");
    JMenuItem adminFileItem = new JMenuItem("для администраторов");
    JMenuItem userFileItem = new JMenuItem("для пользователей");
    public FormControl(){



        helpMenu.add(adminFileItem);


        helpMenu.add(userFileItem);

        panel.add( helpMenu);

        this.setTitle("Программа автоматизации заявок");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 700, 500);
        this.setBackground(new Color(255, 100, 100));
        this.setBounds(200, 100, 700, 500);

        ActionListener actionListenerSendClaim = new SendClaimActionListener();
        sendClaim.addActionListener(actionListenerSendClaim);

        ActionListener actionListenerSupportOnline = new SupportOnlineActionListener();
        getSupport.addActionListener(actionListenerSupportOnline);

        listError.setAutoscrolls(true);

        // обработка поля ввода дополнительной информации
        additionalInformation.setAutoscrolls(true);

        setFontComponents();
        setPanelSettings();
        setBoundsComponent();
        cp.add( panel);

        this.setVisible(true);
    }
    private void setBoundsComponent(){
        selectError.setBounds(10, 0, 200, 20);
        listError.setBounds(10, 30, 300, 300);
        labelAdditionalInformation.setBounds(320, 0, 300, 20);
        additionalInformation.setBounds(320, 30, 300, 300);
        labelUserName.setBounds(10, 330, 300, 20);
        userName.setBounds(10, 350, 300, 20);
        sendClaim.setBounds(320, 345, 300, 30);
        getSupport.setBounds(320, 345, 300, 30);
        //getSupport.setBounds(320, 375, 300, 30);
        warning.setBounds(10, 375, 300, 20);
        messageForUser.setBounds(10, 395, 300, 30);
    }
    private void setFontComponents(){
        selectError.setFont(new Font("Arial", Font.PLAIN, 16));
        labelAdditionalInformation.setFont(new Font("Arial", Font.PLAIN, 16));
        labelUserName.setFont(new Font("Arial", Font.PLAIN, 16));
        sendClaim.setFont(new Font("Arial", Font.PLAIN, 16));
        getSupport.setFont(new Font("Arial", Font.PLAIN, 16));
        warning.setFont(new Font("Arial", Font.PLAIN, 16));
        listError.setFont(new Font("Arial", Font.PLAIN, 14));
        messageForUser.setFont(new Font("Arial", Font.PLAIN, 18));
    }
    private void setPanelSettings(){
        panel.setLayout(null);
        panel.add(listError);
        //panel.add(sendClaim);
        panel.add(getSupport);
        panel.add(selectError);
        panel.add(labelAdditionalInformation);
       // panel.add(warning);
        panel.add(userName);
        panel.add(additionalInformation);
        panel.add(labelUserName);
        panel.add(messageForUser);
    }

    public class SendClaimActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println(123);

        }
    }

    public class SupportOnlineActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
// проверка выбрана ли ошибка из списка
            if(listError.isSelectionEmpty()){
                messageForUser.setText("Выберите ошибку !");
                return;
            }
            // проверка выбран ли пользователь
            if(userName.getText().isEmpty()){
                messageForUser.setText("Вставьте пользователя !");
                return;
            }
            if(additionalInformation.getText().isEmpty()){
                additionalInformation.setText("");
            }else{
                additionalInformation.setText("-"+additionalInformation.getText());
            }
            // отправка сообщения
            ControlMessage.sendMessage(userName.getText(),listError.getSelectedValue().toString()+additionalInformation.getText().toString());

        }
    }

}
