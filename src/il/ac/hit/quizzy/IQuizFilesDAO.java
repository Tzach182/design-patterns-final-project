package il.ac.hit.quizzy;

/**
 * The {@code IQuizFilesDAO} interface defines methods for saving and loading quizzes
 * to/from files. Implementations of this interface should provide functionality to
 * persist quizzes to files and retrieve quizzes from files.
 */
public interface IQuizFilesDAO {

    /**
     * Saves the provided quiz to a file with the given file name.
     *
     * @param quiz     The quiz to be saved.
     * @param fileName The name of the file to save the quiz to.
     * @throws QuizException If there is an error while saving the quiz to the file.
     */
    void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException;

    /**
     * Loads a quiz from the specified file.
     *
     * @param fileName The name of the file from which to load the quiz.
     * @return The loaded quiz object.
     * @throws QuizException If there is an error while loading the quiz from the file,
     *                      or if the file does not contain a valid quiz.
     */
    IQuiz loadQuizFromFile(String fileName) throws QuizException;
}
