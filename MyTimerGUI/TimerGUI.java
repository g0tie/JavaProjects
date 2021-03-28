import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

public class TimerGUI {
    private JFrame frame;
    private JPanel buttonPanel;
    private JPanel timerPanel;
    private JPanel mainPanel;

    private JButton startBtn;
    private JButton stopBtn;
    private JButton resetBtn;

    private JTextField minutesField;
    private JTextField secondsField;

    public TimerGUI() {
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        resetBtn = new JButton("Reset");

        minutesField = new JTextField("00");
        secondsField = new JTextField("00");
        JLabel separator = new JLabel(":");
        minutesField.setHorizontalAlignment(JTextField.CENTER);
        secondsField.setHorizontalAlignment(JTextField.CENTER);
        separator.setHorizontalAlignment(JLabel.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 3));
        buttonPanel.add(startBtn);
        buttonPanel.add(stopBtn);
        buttonPanel.add(resetBtn);

        timerPanel = new JPanel();
        timerPanel.setLayout(new GridLayout(0, 3));
        timerPanel.add(minutesField);
        timerPanel.add(separator);
        timerPanel.add(secondsField);
        timerPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(timerPanel);
        mainPanel.add(buttonPanel);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        frame = new JFrame();
        frame.setTitle("Timer App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.pack();
    }


    public void setMinutes(String minutes) {
        minutesField.setText(minutes);
    }

    public void setSeconds(String seconds) {
        secondsField.setText(seconds);
    }
 
}