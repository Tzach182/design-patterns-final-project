package il.ac.hit.quizzy;

import java.util.List;

public interface IUIMedia {

    public void initialize(int quizLength,String quizName);

    public void showQuestion(String title, String question, List<String> answers);

    public void showScore(int score, int length);

    public int getUserInput();

}
