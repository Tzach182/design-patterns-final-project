package il.ac.hit.quizzy;

/**
 * The `QuizFactory` class is responsible for creating instances of quiz objects based on the specified
 * quiz type. It provides a method to create different types of quizzes, such as terminal-based or GUI-based quizzes.
 *
 */
public class QuizFactory   {

    public QuizFactory() {}

    /**
     * Creates a quiz based on the specified quiz type.
     *
     * @param quizType The type of quiz to create (e.g., GUI or TERMINAL).
     * @return An instance of the created quiz.
     * @throws QuizException If an error occurs while creating the quiz, or if an unsupported quiz type is specified.
     */
    public IQuiz createQuiz(QuizType quizType) throws QuizException {
        IQuiz quiz = null;
        switch (quizType){
            case GUI:
                quiz = new GUIQuiz();
                break;

            case TERMINAL:
                quiz = new TerminalQuiz();
                break;
            default:
                throw new QuizException("no available quiz type");

        }
        return quiz;
    }
}
