package il.ac.hit.quizzy;

import java.util.List;



public interface IQuiz {
    public abstract void start();
    public abstract void setName(String text);
    public abstract String getName();
    public abstract void addQuestion(IQuizQuestion question);
    List<IQuizQuestion> getQuestionList();
    public QuizType getQuizType();
    Object clone();

}
