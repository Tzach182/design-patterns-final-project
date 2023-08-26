package il.ac.hit.quizzy;

public class QuizException extends Exception {
    public QuizException(String errorMessage){
        super(errorMessage);
    }

    public QuizException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
