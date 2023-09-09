import il.ac.hit.quizzy.*;

public class Program {

    public static void main(String[] args) throws QuizException {
        //creating question
        QuizFactory factory = new QuizFactory();
        IQuiz quiz = factory.createQuiz(QuizType.GUI);
        quiz.setName("quiz Demo");
        //creating 1st question
        IQuizQuestionBuilder builder1 = new QuizQuestion.Builder();
        builder1.setTitle("We Love Canada");
        builder1.setQuestion("Canada starts with…?");
        builder1.addAnswer("Canada starts with the letter ‘A’.",false);
        builder1.addAnswer("Canada starts with the letter ‘B’.",false);
        builder1.addAnswer("Canada starts with the letter ‘C’.",true);
        builder1.addAnswer("Canada starts with the letter ‘D’.",false);
        //builder1.addAnswer("Canada starts with the letter ‘E’.",false);
        IQuizQuestion question1 = builder1.create();

        System.out.println(question1);
        //creating 2nd question
        IQuizQuestionBuilder builder2 = new QuizQuestion.Builder();
        builder2.setTitle("We Love Australia");
        builder2.setQuestion("Australia starts with…?");
        builder2.addAnswer("Australia starts with the letter ‘A’.",true);
        builder2.addAnswer("Australia starts with the letter ‘B’.",false);
        builder2.addAnswer("Australia starts with the letter ‘C’.",false);
        builder2.addAnswer("Australia starts with the letter ‘D’.",false);
        builder2.addAnswer("Australia starts with the letter ‘E’.",false);
        builder2.addAnswer("Australia starts with the letter ‘F’.",false);
        IQuizQuestion question2 = builder2.create();
       //
        // IQuizQuestion question3 = (IQuizQuestion) question2.clone();

        //adding questions to quiz
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
       // IQuiz quiz2 = (IQuiz) quiz.clone();
//
// saving quiz to file and read it back
        IQuizFilesDAO dao = SimpleCSVQuizFilesDAO.getInstance();
        dao.saveQuizToFile(quiz,"quiz1.data");
        IQuiz loadedQuiz = dao.loadQuizFromFile("quiz1.data");
        System.out.println(loadedQuiz);
        loadedQuiz.start();

    }

}
