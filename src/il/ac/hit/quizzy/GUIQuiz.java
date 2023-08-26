package il.ac.hit.quizzy;

import java.util.List;

public class GUIQuiz implements IQuiz{
    private String name;
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

    }

    @Override
    public List<IQuizQuestion> getQuestionList() {
        return null;
    }

    @Override
    public QuizType getQuizType() {
        return null;
    }
}
