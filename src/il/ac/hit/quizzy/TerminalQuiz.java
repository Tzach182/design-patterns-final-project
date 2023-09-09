package il.ac.hit.quizzy;

import java.util.*;

/**
 * The `TerminalQuiz` class represents a terminal-based quiz game.
 * It implements the `IQuiz` interface and provides methods to start the quiz,
 * display questions, and manage the user's score.
 * This class allows users to answer multiple-choice questions in a terminal.
 *
 */

public class TerminalQuiz implements IQuiz, Cloneable {
    private String name;
    private int score = 0;
    private final QuizType quizType = QuizType.TERMINAL;
    private final List<IQuizQuestion> questionList = new LinkedList<>();
    Scanner input = new Scanner(System.in);

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
        initialize();
        for (IQuizQuestion currentQuestion : questionList ) {
            showQuestion(currentQuestion);

            int answerIndex = getUserInput() - 1;
            if (currentQuestion.isAnswerCorrect(answerIndex)) {
                setScore(getScore() + 1);
            }
        }
        showScore();
    }

    public void initialize() {

        System.out.println(getName());
        System.out.println("You will be asked " + questionList.size() + " questions");

    }

    public void showQuestion(IQuizQuestion currentQuestion) {
        System.out.println(currentQuestion.getTitle());
        System.out.println(currentQuestion.getQuestion());
        List<String> answers = currentQuestion.getAnswerText();
        for (int index = 0; index < answers.size(); index++) {
            System.out.println((index + 1) + ". "+ answers.get(index));
        }
        System.out.println(System.lineSeparator() + "Enter the number of correct answer: ");

    }

    public int getUserInput() {
        int answer = 0;
        while(!input.hasNextInt()) {
            System.out.println("please enter an integer");
            input.next();
        }
        answer = input.nextInt();


        return answer;
    }

    public void showScore() {
        System.out.println("Your score is: " + getScore() + " out of " + questionList.size());
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
