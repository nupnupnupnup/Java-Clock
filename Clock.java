import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Clock extends JFrame {

    private static final long serialVersionUID = 1L;

 
    private JTextField timeF;
    private JPanel panel;
    private ClockDisplay clockDisplay;

    public Clock() {

        super("Java Clock with Manual Time Setting");
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
 
        clockDisplay = new ClockDisplay();
        clockDisplay.setTime(9, 8, 0);  


        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.BLACK);


        timeF = new JTextField(10);
        timeF.setEditable(false);
        timeF.setFont(new Font("SansSerif", Font.BOLD, 48)); 
        timeF.setHorizontalAlignment(JTextField.CENTER);
        timeF.setBackground(Color.BLACK);
        timeF.setForeground(Color.GREEN);
        timeF.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

 
        panel.add(timeF);
        add(panel);

 
        Timer t = new Timer(1000, new Listener());
        t.start();
        
        setVisible(true);
    }


    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clockDisplay.timeTick(); 
            timeF.setText(clockDisplay.getTime());  
        }
    }

    public static void main(String[] args) {
        new Clock(); 
    }
}
