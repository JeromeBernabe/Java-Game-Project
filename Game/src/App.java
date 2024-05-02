import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class App {
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame();
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.pack();
        
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("Assets/Logo.jpg").getImage());
        
        panel.startGameThread();
        
    }
}
