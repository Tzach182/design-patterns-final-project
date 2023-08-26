package il.ac.hit.quizzy;

public class QuizFactory   {
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
