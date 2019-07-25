package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameException extends JFrame {
    JButton closeForm  = new JButton("OK");
    JLabel messageAboutError = new JLabel("");
    JPanel panel = new JPanel();
    Container cp = getContentPane();
    public FrameException(   String message){
        this.setTitle("Сообщение об ошибке !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 300, 200);
        this.setBackground(new Color(255, 100, 100));
        this.setBounds(300, 200, 300, 200);

        closeForm.setFont(new Font("Arial", Font.PLAIN, 16));
        closeForm.setBounds(90, 100, 100, 40);
        closeForm.addActionListener(new SendClaimActionListener());
        messageAboutError.setFont(new Font("Arial", Font.PLAIN, 14));
        messageAboutError.setBounds(20, 20, 300, 40);
        panel.setLayout(null);
        panel.add(messageAboutError);
        panel.add(closeForm);
        messageAboutError.setText(message);
        cp.add( panel);

        this.setVisible(true);
    }
    private void closeForm(){
            this.dispose();
    }
    public class SendClaimActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeForm();
        }
    }
}
