import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class WhackAMole extends JFrame {
    private int score = 0;
    private int currentLevel = 1;
    private int interval = 1000; // Initial mole appearance interval (in ms)
    private JButton[] moleButtons = new JButton[9];
    private Timer timer;
    private Random random = new Random();
    private ImageIcon moleIcon;
    private ImageIcon boomIcon;

    public WhackAMole() {
        // Load the mole image
        moleIcon = new ImageIcon("mole.png");
        Image moleImage = moleIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        moleIcon = new ImageIcon(moleImage);

        // Load the boom image
        boomIcon = new ImageIcon("boom.png");
        Image boomImage = boomIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        boomIcon = new ImageIcon(boomImage);

        // Set up the JFrame
        setTitle("Exercise 2: Whack-a-Mole");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Create the main panel for the game grid
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        gridPanel.setBackground(Color.DARK_GRAY); // Ensure grid panel has a background
        for (int i = 0; i < moleButtons.length; i++) {
            JButton button = new JButton();
            button.setBackground(Color.LIGHT_GRAY);
            button.setOpaque(true); // Ensure the button's background is opaque
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add a border for visibility
            button.addActionListener(new MoleActionListener(i));
            moleButtons[i] = button;
            gridPanel.add(button);
        }

        // Add the grid panel to the JFrame
        add(gridPanel, BorderLayout.CENTER);

        // Add a start button and score display
        JPanel controlPanel = new JPanel(new FlowLayout());
        JLabel scoreLabel = new JLabel("Score: 0");
        JLabel levelLabel = new JLabel("Level: 1");
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> startGame(scoreLabel, levelLabel));
        controlPanel.add(startButton);
        controlPanel.add(scoreLabel);
        controlPanel.add(levelLabel);

        // Add the control panel to the JFrame
        add(controlPanel, BorderLayout.SOUTH);

        // Make the JFrame visible
        setVisible(true);
    }

    private void startGame(JLabel scoreLabel, JLabel levelLabel) {
        score = 0;
        currentLevel = 1;
        interval = 1000; // Reset to initial interval
        scoreLabel.setText("Score: " + score);
        levelLabel.setText("Level: " + currentLevel);

        // Set up the timer to randomly highlight "moles"
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        timer = new Timer(interval, new ActionListener() {
            private int currentMole = -1;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentMole >= 0) {
                    moleButtons[currentMole].setIcon(null); // Remove mole image
                    moleButtons[currentMole].setBackground(Color.LIGHT_GRAY);
                }
                currentMole = random.nextInt(moleButtons.length);
                moleButtons[currentMole].setIcon(moleIcon); // Add mole image
                moleButtons[currentMole].setBackground(Color.WHITE); // Highlight the button
            }
        });
        timer.start();
    }

    private void levelUp(JLabel levelLabel) {
        currentLevel++;
        interval = Math.max(200, interval - 200); // Decrease interval, minimum 200 ms
        levelLabel.setText("Level: " + currentLevel);

        // Restart the timer with the new interval
        timer.setDelay(interval);
        timer.restart();
    }

    private class MoleActionListener implements ActionListener {
        private final int index;

        public MoleActionListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (moleButtons[index].getIcon() == moleIcon) {
                score++;
                ((JLabel) ((JPanel) getContentPane().getComponent(1)).getComponent(1)).setText("Score: " + score);

                // Temporarily show the boom effect
                moleButtons[index].setIcon(boomIcon); // Set boom icon
                moleButtons[index].setBackground(Color.RED);
                Timer boomTimer = new Timer(300, event -> {
                    moleButtons[index].setIcon(null); // Clear icon
                    moleButtons[index].setBackground(Color.LIGHT_GRAY);
                });
                boomTimer.setRepeats(false);
                boomTimer.start();

                // Check for level up
                if (score == 10 || score == 15 || score % 5 == 0) {
                    levelUp((JLabel) ((JPanel) getContentPane().getComponent(1)).getComponent(2));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WhackAMole::new);
    }
}
