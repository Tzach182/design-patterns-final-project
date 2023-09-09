package il.ac.hit.quizzy.tests;

import il.ac.hit.quizzy.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GUIQuizTest {
    IQuiz guiQuiz;

    @BeforeEach
    void setUp() {
        guiQuiz = new GUIQuiz();
    }

    @AfterEach
    void tearDown() {
        guiQuiz = null;
    }

    @Test
    void setName() {
        String expected = "test";
        guiQuiz.setName(expected);
        assertEquals(expected,guiQuiz.getName());
    }

    @Test
    void getName() {
        String expected = "test";
        guiQuiz.setName(expected);
        assertEquals(expected,guiQuiz.getName());
    }

    @Test
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