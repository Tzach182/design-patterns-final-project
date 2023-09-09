package il.ac.hit.quizzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * The {@code GUIQuiz} class represents a graphical user interface (GUI) for conducting quizzes.
 * It implements the {@code IQuiz} interface and provides methods for managing quiz questions,
 * displaying questions and answer options, scoring, and user interaction through a GUI.
 */
public class GUIQuiz implements IQuiz{
    private String name;
    private int score = 0;
    private final QuizType quizType = QuizType.GUI;
    private final List<IQuizQuestion> questionList = new LinkedList<>();
    private JFrame gameScreen;

    /**
     * Constructs a new {@code GUIQuiz} instance with default values.
     */
    public GUIQuiz() { }

    /**
     * Constructs a new {@code GUIQuiz} instance with the specified name.
     *
     * @param name The name of the quiz.
     */
    public GUIQuiz(String name) {
        setName(name);
    }

    private void setQuestionList(LinkedList<IQuizQuestion> questionList) {
        if(!questionList.isEmpty()) {
            for (IQuizQuestion question : questionList) {
                addQuestion(question);
            }
        }
    }

    @Override
    public void start() {
        gameScreen = new JFrame(getName());
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.setSize(700,500);
        gameScreen.setLocationRelativeTo(null);
        gameScreen.setLayout(new BorderLayout());
        gameScreen.setVisible(true);
        showQuestion(0);

    }

    private void showQuestion(int counter) {
        if(counter < questionList.size()) {
            // Create and add the question label
            String questionText = questionList.get(counter).getQuestion();
            JLabel questionLabel = renderLabel(questionText);
            gameScreen.add(questionLabel, BorderLayout.NORTH);


            JPanel answerPanel = renderAnswerPanel(questionList.get(counter));
            // Create and add radio buttons for answers

            gameScreen.add(answerPanel, BorderLayout.CENTER);
            Component[] answerRadioButtons = answerPanel.getComponents();

            // Create and add a submit button
            JButton submitButton = new JButton("Submit Answer");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int idx = 0; idx < answerRadioButtons.length; idx ++ ) {

                        if (answerRadioButtons[idx] instanceof JRadioButton) {
                            JRadioButton radioButton = (JRadioButton) answerRadioButtons[idx];
                            boolean isSelected = radioButton.isSelected();
                            if(isSelected && questionList.get(counter).isAnswerCorrect(idx)) {
                                setScore(score + 1);
                            }
                        }
                    }
                    gameScreen.remove(questionLabel);
                    gameScreen.remove(answerPanel);
                    gameScreen.remove(submitButton);
                    showQuestion(counter + 1);
                }
            });

            submitButton.setHorizontalAlignment(JButton.CENTER);
            gameScreen.add(submitButton, BorderLayout.SOUTH);

        }
        else{
            gameScreen.add(renderScore());
            endGame();
        }
        gameScreen.revalidate();
        gameScreen.repaint();

    }

    private void endGame() {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameScreen.dispose();
            }
        });
        exitButton.setHorizontalAlignment(JButton.CENTER);
        gameScreen.add(exitButton, BorderLayout.SOUTH);
    }

    private JLabel renderLabel(String question) {
        JLabel questionLabel = new JLabel(question);
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        return questionLabel;
    }
    private JLabel renderScore() {
        JLabel scoreLabel = new JLabel("Your score is: " + getScore() + "/" + questionList.size());
        Font font = new Font("Arial", Font.BOLD, 24); // Font name, style, size
        scoreLabel.setFont(font);
        scoreLabel.setPreferredSize(new Dimension(250, 100));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        return scoreLabel;
    }

    private JPanel renderAnswerPanel(IQuizQuestion currentQuestion) {
        List<String> answersText = currentQuestion.getAnswerText();
        int answerCount = answersText.size();

        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(answerCount, 1)); // Adjust the number of rows based on the number of answers

        JRadioButton[] answerRadioButtons = new JRadioButton[answerCount]; // You can adjust the number of answers as needed
        ButtonGroup buttonGroup = new ButtonGroup();

        for (int i = 0; i < answerRadioButtons.length; i++) {
            answerRadioButtons[i] = new JRadioButton();
            answerRadioButtons[i].setText(answersText.get(i));
            buttonGroup.add(answerRadioButtons[i]);
            answerPanel.add(answerRadioButtons[i]);
        }
        gameScreen.add(answerPanel, BorderLayout.CENTER);

        return  answerPanel;
    }

    /**
     * Gets the type of the quiz (GUI).
     *
     * @return The {@link QuizType} representing the type of the quiz.
     */
    public QuizType getQuizType() {
        return quizType;
    }

    @Override
    public void setName(String text) {
        name = text;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addQuestion(IQuizQuestion question) {
        questionList.add(question);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder(name + System.lineSeparator());

        for (IQuizQuestion question : questionList) {
            text.append(question.toString());
            text.append(System.lineSeparator());
        }
        return text.toString();
    }

    /**
     * Gets the current score of the quiz.
     *
     * @return The current score of the quiz.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the quiz.
     *
     * @param score The score to set for the quiz.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gets the list of questions in the quiz.
     *
     * @return The list of questions in the quiz.
     */
    public List<IQuizQuestion> getQuestionList() {
        return questionList;
    }


    @Override
    public Object clone() {
        LinkedList<IQuizQuestion> cloneQuestionList = new LinkedList<>();

        for (IQuizQuestion question : this.questionList ) {
            QuizQuestion questionClone = (QuizQuestion)question.clone();
            cloneQuestionList.add(questionClone);
        }

        GUIQuiz quizClone = new GUIQuiz(getName());
        quizClone.setQuestionList(cloneQuestionList);

        return quizClone;
    }




}
