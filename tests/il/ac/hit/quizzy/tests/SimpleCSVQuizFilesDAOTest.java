package il.ac.hit.quizzy.tests;

import il.ac.hit.quizzy.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCSVQuizFilesDAOTest {
    IQuizFilesDAO testDao;

    @BeforeEach
    void setUp() {
        testDao = SimpleCSVQuizFilesDAO.getInstance();
    }

    @AfterEach
    void tearDown() {
        testDao = null;
    }

    @Test
    void getInstance() {
        assertEquals(SimpleCSVQuizFilesDAO.getInstance(),testDao);
    }

    @Test
    void saveQuizToFile() throws QuizException {
        QuizFactory testFactory = new QuizFactory();
        IQuiz testQuiz = testFactory.createQuiz(QuizType.TERMINAL);
        testQuiz.setName("quiz Demo");
        IQuizQuestionBuilder testBuilder = new QuizQuestion.Builder();
        testBuilder.setTitle("We Love Canada");
        testBuilder.setQuestion("Canada starts with…?");
        testBuilder.addAnswer("Canada starts with the letter ‘A’.",false);
        IQuizQuestion testQuestion = testBuilder.create();
        testQuiz.addQuestion(testQuestion);
        testDao.saveQuizToFile(testQuiz,"testQuiz1.data");
        IQuiz testQuiz2 = testDao.loadQuizFromFile("testQuiz1.data");
        assertEquals(testQuiz.getName(),testQuiz2.getName());
        assertEquals(testQuiz.getQuestionList().size(),testQuiz2.getQuestionList().size());
        assertEquals(testQuiz.getQuestionList().get(0).getQuestion(),testQuiz2.getQuestionList().get(0).getQuestion());
        assertEquals(testQuiz.getQuestionList().get(0).getAnswerText().get(0),testQuiz2.getQuestionList().get(0).getAnswerText().get(0));

    }

    @Test
    void loadQuizFromFile() throws QuizException {
        IQuiz testQuiz = testDao.loadQuizFromFile("testQuiz1.data");
        assertEquals(testQuiz.getName(),"quiz Demo");
        assertEquals(testQuiz.getQuestionList().get(0).getQuestion(),"Canada starts with…?");
        assertEquals(testQuiz.getQuestionList().get(0).getAnswerText().get(0),"Canada starts with the letter ‘A’.");
    }
}