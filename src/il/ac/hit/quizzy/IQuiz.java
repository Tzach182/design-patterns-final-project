package il.ac.hit.quizzy;

import java.util.List;

/**
 * The {@code IQuiz} interface defines the contract for creating and managing quizzes.
 * Implementations of this interface should provide methods to start, set a name,
 * add questions, retrieve question lists, get the quiz type, and perform cloning.
 */

public interface IQuiz {

    /**
     * Start answering the quiz.
     */
    public abstract void start();

    /**
     * Set the name of the quiz.
     *
     * @param text The name to set for the quiz.
     */
    public abstract void setName(String text);

    /**
     * Get the name of the quiz.
     *
     * @return The name of the quiz.
     */
    public abstract String getName();

    /**
     * Add a question to the quiz.
     *
     * @param question The question to add to the quiz.
     */
    public abstract void addQuestion(IQuizQuestion question);

    /**
     * Get the list of questions in the quiz.
     *
     * @return A list of quiz questions.
     */
    List<IQuizQuestion> getQuestionList();

    /**
     * Get the type of the quiz.
     *
     * @return The type of the quiz.
     */
    public QuizType getQuizType();

    /**
     * Create a clone of the quiz object.
     *
     * @return A new instance that is a clone of the current quiz object.
     */
    Object clone();

}
