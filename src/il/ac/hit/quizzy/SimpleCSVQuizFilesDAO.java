package il.ac.hit.quizzy;

public class SimpleCSVQuizFilesDAO implements IQuizFilesDAO{

    public static IQuizFilesDAO getInstance() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException {
        throw new QuizException();
    }

    @Override
    public IQuiz loadQuizFromFile(String fileName) throws QuizException {
        return null;
    }
}
