package il.ac.hit.quizzy;

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
}
