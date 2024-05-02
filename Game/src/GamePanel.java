import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    final int OriginalTileSize = 16;
    final int scale = 3;

    final int tileSize = OriginalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 7;

    final int FPS = 60;
    KeyHandler KeyH = new KeyHandler();
    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            System.out.println(delta);
            lastTime = currentTime;
            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        if(KeyH.upPressed && playerY >= 0){
            playerY -= playerSpeed;
        }
        if(KeyH.downPressed && playerY < screenHeight - tileSize){
            playerY += playerSpeed;
        }
        if(KeyH.leftPressed && playerX >= 0){
            playerX -= playerSpeed;
        }
        if(KeyH.rightPressed && playerX < screenWidth - tileSize){
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
