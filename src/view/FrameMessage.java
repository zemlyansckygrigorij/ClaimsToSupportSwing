package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMessage extends JFrame {
    JLabel message = new JLabel("");
    JPanel panel = new JPanel();
    JButton closeForm  = new JButton("OK");
    Container cp = getContentPane();
    public FrameMessage(String text){

        this.setTitle("Сообщение !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 300, 200);
        this.setBackground(new Color(255, 100, 100));
        this.setBounds(300, 200, 300, 200);
        closeForm.setFont(new Font("Arial", Font.PLAIN, 16));
        closeForm.setBounds(90, 120, 100, 40);
        closeForm.addActionListener(new CloseActionListener ());
        message.setText(text);
        message.setFont(new Font("Arial", Font.PLAIN, 14));
        message.setBounds(20, 20, 300, 40);
        panel.setLayout(null);
        panel.add(message);
        panel.add(closeForm);
        cp.add(panel);

        this.setVisible(true);
    }
    private void closeForm(){
        this.setVisible(false);
    }
    public class CloseActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeForm();
        }
    }
}
