package il.ac.hit.quizzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class GUIQuiz implements IQuiz{
    private String name;
    private int score = 0;
    private final QuizType quizType = QuizType.GUI;
    private final List<IQuizQuestion> questionList = new LinkedList<>();
    private JFrame gameScreen;

    public GUIQuiz() { }
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
        int counter = questionList.size();
        gameScreen = new JFrame(getName());
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.setSize(700,500);
        gameScreen.setLocationRelativeTo(null);
        gameScreen.setLayout(new BorderLayout());
        gameScreen.setVisible(true);
        showQuestion(0);
        // display message




        //IUIMedia startup = new UIGUI();
        //startup.initialize(questionList.size(),getName());
//        for (IQuizQuestion currentQuestion : questionList ) {
//            startup.showQuestion(currentQuestion.getTitle(),
//                    currentQuestion.getQuestion(),
//                    currentQuestion.getAnswerText());
//
//            int answerIndex = startup.getUserInput() - 1;
//            if (currentQuestion.isAnswerCorrect(answerIndex)) {
//                setScore(getScore()+1);
//            }
//        }
//        startup.showScore(getScore(),questionList.size());
//        gameScreen = new JFrame(quizName);
//        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gameScreen.setSize(400,200);
//        gameScreen.setLocationRelativeTo(null);
//        gameScreen.setLayout(new BorderLayout());
//        JLabel startingInfo = new JLabel("You will be asked " + quizLength + " questions");
//        gameScreen.add(startingInfo);
//        JButton startButton = new JButton("Press here to start");
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showQuestion();
//            }
//        });
//        gameScreen.add(startButton);
//        gameScreen.setVisible(true);
    }

    private void showQuestion(int counter) {

        // Create and add the question label
        String questionText = questionList.get(counter).getQuestion();
        JLabel questionLabel = new JLabel(questionText);
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        gameScreen.add(questionLabel, BorderLayout.NORTH);

        // Create and add radio buttons for answers
        int answerCount = questionList.get(counter).getAnswerCount();
        List<String> answersText = questionList.get(counter).getAnswerText();
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

        // Create and add a submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < answerRadioButtons.length; i++) {
                    if (answerRadioButtons[i].isSelected()) {
                        if (questionList.get(counter).isAnswerCorrect(i)) {
                            score++;
                        }
                    }
                }

                gameScreen.remove(questionLabel);
                gameScreen.remove(answerPanel);
                gameScreen.remove(submitButton);
                gameScreen.revalidate();
                gameScreen.repaint();
                showQuestion(counter + 1);
            }
        });

        submitButton.setHorizontalAlignment(JButton.CENTER);
        gameScreen.add(submitButton, BorderLayout.SOUTH);

//        gameScreen.removeAll();
//        gameScreen.revalidate();
//        gameScreen.repaint();
//        JLabel questionLabel = new JLabel();
//        questionLabel.setHorizontalAlignment(JLabel.CENTER);
//        gameScreen.add(questionLabel, BorderLayout.NORTH);
//
//        // Create and add radio buttons for answers
//        JPanel answerPanel = new JPanel();
//        answerPanel.setLayout(new GridLayout(4, 1)); // Adjust the number of rows based on the number of answers
//
//        answerRadioButtons = new JRadioButton[4]; // You can adjust the number of answers as needed
//        buttonGroup = new ButtonGroup();
//
//        for (int i = 0; i < answerRadioButtons.length; i++) {
//            answerRadioButtons[i] = new JRadioButton();
//            buttonGroup.add(answerRadioButtons[i]);
//            answerPanel.add(answerRadioButtons[i]);
//        }
//
//        add(answerPanel, BorderLayout.CENTER);
//
//        // Create and add a submit button
//        submitButton = new JButton("Submit");
    }

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
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

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
