
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class task3_BricksBreaker extends JPanel implements ActionListener
{
    private int ballX = 250; // Ball's X position
    private int ballY = 250; // Ball's Y position
    private int ballXSpeed = 3; // Ball's X direction speed
    private int ballYSpeed = 3; // Ball's Y direction speed
    private int paddleX = 200; // Paddle's X position
    private int paddleY = 400; // Paddle's Y position
    private int score = 0;

    public task3_BricksBreaker() 
    {
        Timer timer = new Timer(10, this);
        timer.start();

        addKeyListener(new KeyAdapter());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        moveBall();
        repaint();
    }

    private void moveBall() 
    {
        if (ballX + ballXSpeed < 0 || ballX + ballXSpeed > getWidth()) 
        {
            ballXSpeed = -ballXSpeed;
        }

        if (ballY + ballYSpeed < 0) 
        {
            ballYSpeed = -ballYSpeed;
        } 
        else if (ballY + ballYSpeed > paddleY - 10 && ballX >= paddleX && ballX <= paddleX + 60) 
        {
            ballYSpeed = -ballYSpeed;
            score++;
        } 
        else if (ballY + ballYSpeed > getHeight()) 
        {
            // Game over
            System.exit(0);
        }

        ballX += ballXSpeed;
        ballY += ballYSpeed;
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 20, 20);

        g.setColor(Color.BLUE);
        g.fillRect(paddleX, paddleY, 60, 10);

        g.setColor(Color.RED);
        g.drawString("Score: " + score, 10, 20);
    }

    private class KeyAdapter extends java.awt.event.KeyAdapter 
    {
        @Override
        public void keyPressed(KeyEvent e) 
        {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT && paddleX > 0) 
            {
                paddleX -= 20;
            } else if (keyCode == KeyEvent.VK_RIGHT && paddleX < getWidth() - 60) 
            {
                paddleX += 20;
            }
        }
    }

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Brick Breaker");
        task3_BricksBreaker game = new task3_BricksBreaker();
        frame.add(game);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

