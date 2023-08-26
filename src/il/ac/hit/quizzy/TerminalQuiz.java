package il.ac.hit.quizzy;

import java.util.*;

public class TerminalQuiz implements IQuiz{
    private String name;
    private int score;



    private final QuizType quizType = QuizType.TERMINAL;
    private final List<IQuizQuestion> questionList = new LinkedList<>();
    @Override
    public void start() {

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
        String text = name + System.lineSeparator();

        for (IQuizQuestion question : questionList) {
            text += question.toString();
            text += System.lineSeparator();
        }
        return text;
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
}
