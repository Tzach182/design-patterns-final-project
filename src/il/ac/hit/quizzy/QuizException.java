package il.ac.hit.quizzy;

/**
 * The {@code QuizException} class represents an exception that can be thrown when
 * there is an error related to quiz operations or handling. It is a custom exception
 * extending the standard {@code Exception} class.
 */
public class QuizException extends Exception {

    /**
     * Constructs a new {@code QuizException} with the specified error message.
     *
     * @param errorMessage The error message describing the exception.
     */
    public QuizException(String errorMessage){
        super(errorMessage);
    }

    /**
     * Constructs a new {@code QuizException} with the specified error message and
     * a nested exception (cause).
     *
     * @param errorMessage The error message describing the exception.
     * @param cause        The nested exception that caused this exception.
     */
    public QuizException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
