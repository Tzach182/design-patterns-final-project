package il.ac.hit.quizzy;

import java.util.LinkedList;
import java.util.List;

public interface IQuizQuestion {
    public abstract void setTitle(String text);
    public abstract void setQuestion(String text);

    public abstract void setAnswerList(List<QuizAnswer> answers);

    String getTitle();

    String getQuestion();

    String getAnswerText();

    Boolean isAnswerCorrect();
}
