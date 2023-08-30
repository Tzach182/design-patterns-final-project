package il.ac.hit.quizzy;

import java.util.List;

public interface IUIMedia {

    public void initialize(int quizLength);

    public void showQuestion(String title, String question, List<String> answers);

    public void showScore(int score);

    public int getUserInput();

}
