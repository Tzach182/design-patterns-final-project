package il.ac.hit.quizzy.tests;
import il.ac.hit.quizzy.*;

import static org.junit.jupiter.api.Assertions.*;

class GUIQuizTest {
    IQuiz guiQuiz;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        guiQuiz = new GUIQuiz();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        guiQuiz = null;
    }

    @org.junit.jupiter.api.Test
    void setName() {
        String expected = "test";
        guiQuiz.setName(expected);
        assertEquals(expected,guiQuiz.getName());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        String expected = "test";
        guiQuiz.setName(expected);
        assertEquals(expected,guiQuiz.getName());
    }

    @org.junit.jupiter.api.Test
    void addQuestion() {
        int expectedSize = 1;
        IQuizQuestionBuilder testQuestionBuilder = new QuizQuestion.Builder();
        testQuestionBuilder.setTitle("We Love Australia");
        testQuestionBuilder.setQuestion("Australia starts with…?");
        testQuestionBuilder.addAnswer("Australia starts with the letter ‘A’.",true);
        IQuizQuestion testQuestion = testQuestionBuilder.create();
        guiQuiz.addQuestion(testQuestion);
        assertEquals(expectedSize,guiQuiz.getQuestionList().size());
    }
}