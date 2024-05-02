import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setTitle("Game");
        frame.setSize(1000,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

        frame.setIconImage(new ImageIcon("Game Assets/Logo.jpg").getImage());
        

        JLabel image = new JLabel();
        
        
    }
}
