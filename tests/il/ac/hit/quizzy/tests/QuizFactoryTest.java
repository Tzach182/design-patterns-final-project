package il.ac.hit.quizzy.tests;

import il.ac.hit.quizzy.IQuiz;
import il.ac.hit.quizzy.QuizException;
import il.ac.hit.quizzy.QuizFactory;
import il.ac.hit.quizzy.QuizType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizFactoryTest {
    QuizFactory testFactory;
    @BeforeEach
    void setUp() {
        testFactory = new QuizFactory();
    }

    @AfterEach
    void tearDown() {
        testFactory = null;
    }

    @Test
    void createQuiz() throws QuizException {
        IQuiz terminalQuizTest = testFactory.createQuiz(QuizType.TERMINAL);
        assertEquals(terminalQuizTest.getQuizType(),QuizType.TERMINAL);
        IQuiz guiQuizTest = testFactory.createQuiz(QuizType.GUI);
        assertEquals(guiQuizTest.getQuizType(),QuizType.GUI);
    }
}