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

    @Override
    public void setName(String text) {
        name = text;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void addQuestion(IQuizQuestion question) {
        questionList.add(question);
    }
    public List<IQuizQuestion> getQuestionList() {
        return questionList;
    }
    public QuizType getQuizType() {
        return quizType;
    }

    private void setQuestionList(LinkedList<IQuizQuestion> questionList) {
        //set questions in quiz
        if(!getQuestionList().isEmpty()) {
            for (IQuizQuestion question : getQuestionList()) {
                addQuestion(question);
            }
        }
    }

    @Override
    public void start() {
        initialize();
        for (IQuizQuestion currentQuestion : getQuestionList() ) {
            showQuestion(currentQuestion);

            int answerIndex = getUserInput() - 1;
            if (currentQuestion.isAnswerCorrect(answerIndex)) {
                setScore(getScore() + 1);
            }
        }
        showScore();
    }

    public void initialize() {
        //show disclaimer
        System.out.println(getName());
        System.out.println("You will be asked " + getQuestionList().size() + " questions");

    }

    public void showQuestion(IQuizQuestion currentQuestion) {
        //print message into terminal
        System.out.println(currentQuestion.getTitle());
        System.out.println(currentQuestion.getQuestion());
        List<String> answers = currentQuestion.getAnswerText();
        for (int index = 0; index < answers.size(); index++) {
            System.out.println((index + 1) + ". "+ answers.get(index));
        }
        System.out.println(System.lineSeparator() + "Enter the number of correct answer: ");

    }

    public int getUserInput() {
        //get user input
        int answer = 0;
        while(!input.hasNextInt()) {
            System.out.println("please enter an integer");
            input.next();
        }
        answer = input.nextInt();


        return answer;
    }

    public void showScore() {
        System.out.println("Your score is: " + getScore() + " out of " + getQuestionList().size());
    }

    @Override
    public String toString() {
        //change quiz into text
        StringBuilder text = new StringBuilder(getName() + System.lineSeparator());

        for (IQuizQuestion question : getQuestionList()) {
            text.append(question.toString());
            text.append(System.lineSeparator());
        }
        return text.toString();
    }

    @Override
    public Object clone() {
        //clone quiz
        LinkedList<IQuizQuestion> cloneQuestionList = new LinkedList<>();

        for (IQuizQuestion question : getQuestionList() ) {
            QuizQuestion questionClone = (QuizQuestion)question.clone();
            cloneQuestionList.add(questionClone);
        }

        TerminalQuiz quizClone = new TerminalQuiz(getName());
        quizClone.setQuestionList(cloneQuestionList);

        return quizClone;
    }
}
