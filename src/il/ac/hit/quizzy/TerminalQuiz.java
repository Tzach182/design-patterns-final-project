package il.ac.hit.quizzy;

import java.util.*;

public class TerminalQuiz implements IQuiz{
    private String name;
    private final List<IQuizQuestion> questionList = new LinkedList<>();
    @Override
    public void start() {

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
}
