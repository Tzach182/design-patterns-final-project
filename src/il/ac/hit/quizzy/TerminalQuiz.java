package il.ac.hit.quizzy;

import java.util.*;

public class TerminalQuiz implements IQuiz, Cloneable {
    private String name;
    private int score = 0;
    private final QuizType quizType = QuizType.TERMINAL;
    private final List<IQuizQuestion> questionList = new LinkedList<>();

    public TerminalQuiz() { }
    public TerminalQuiz(String name) {
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
        IUIMedia startup = new UITerminal();
        startup.initialize(questionList.size(),getName());
        for (IQuizQuestion currentQuestion : questionList ) {
            startup.showQuestion(currentQuestion.getTitle(),
                    currentQuestion.getQuestion(),
                    currentQuestion.getAnswerText());

            int answerIndex = startup.getUserInput() - 1;
            if (currentQuestion.isAnswerCorrect(answerIndex)) {
                score++;
            }
        }
        startup.showScore(score,questionList.size());
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

        TerminalQuiz quizClone = new TerminalQuiz(getName());
        quizClone.setQuestionList(cloneQuestionList);

        return quizClone;
    }
}
