package il.ac.hit.quizzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UIGUI implements IUIMedia {
    private JFrame gameScreen;
    @Override
    public void initialize(int quizLength,String quizName) {
        gameScreen = new JFrame(quizName);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.setSize(400,200);
        gameScreen.setLocationRelativeTo(null);
        gameScreen.setLayout(new BorderLayout());
        JLabel startingInfo = new JLabel("You will be asked " + quizLength + " questions");
        gameScreen.add(startingInfo);
        JButton startButton = new JButton("Press here to start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        });
        gameScreen.add(startButton);
        gameScreen.setVisible(true);

    }

    @Override
    public void showQuestion(String title, String question, List<String> answers) {

    }

    @Override
    public void showScore(int score, int length) {

    }

    @Override
    public int getUserInput() {
        return 0;
    }
}
