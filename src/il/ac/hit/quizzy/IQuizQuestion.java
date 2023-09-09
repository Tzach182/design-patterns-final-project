package il.ac.hit.quizzy;

import java.util.LinkedList;
import java.util.List;

/**
 * The {@code IQuizQuestion} interface defines methods for managing quiz questions.
 * Implementations of this interface should provide functionality to set question details,
 * retrieve question details, work with answer lists, check answer correctness, perform cloning,
 * and get the answer count.
 */
public interface IQuizQuestion {

    /**
     * Set the title of the quiz question.
     *
     * @param text The title to set for the question.
     */
    public abstract void setTitle(String text);

    /**
     * Set the text of the quiz question.
     *
     * @param text The text of the question.
     */
    public abstract void setQuestion(String text);

    /**
     * Set the list of answers for the quiz question.
     *
     * @param answers The list of answers to set.
     */
    public abstract void setAnswerList(List<QuizAnswer> answers);

    /**
     * Get the title of the quiz question.
     *
     * @return The title of the question.
     */
    String getTitle();

    /**
     * Get the text of the quiz question.
     *
     * @return The text of the question.
     */
    String getQuestion();

    /**
     * Get the text of all answers for the quiz question.
     *
     * @return A list of answer texts.
     */
    List<String> getAnswerText();

    /**
     * Check if the answer at the specified index is correct.
     *
     * @param index The index of the answer to check.
     * @return {@code true} if the answer is correct, {@code false} otherwise.
     */
    Boolean isAnswerCorrect(int index);

    /**
     * Create a clone of the quiz question object.
     *
     * @return A new instance that is a clone of the current quiz question object.
     */
    Object clone();

}
