package il.ac.hit.quizzy.tests;

import il.ac.hit.quizzy.*;

import static org.junit.jupiter.api.Assertions.*;

class TerminalQuizTest {
    IQuiz terminalQuiz;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        terminalQuiz = new TerminalQuiz();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        terminalQuiz = null;
    }

    @org.junit.jupiter.api.Test
    void setName() {
        String expected = "test";
        terminalQuiz.setName(expected);
        assertEquals(expected,terminalQuiz.getName());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        String expected = "test";
        terminalQuiz.setName(expected);
        assertEquals(expected,terminalQuiz.getName());
    }

    @org.junit.jupiter.api.Test
    void addQuestion() {
        int expectedSize = 1;
        IQuizQuestionBuilder testQuestionBuilder = new QuizQuestion.Builder();
        testQuestionBuilder.setTitle("We Love Australia");
        testQuestionBuilder.setQuestion("Australia starts with…?");
        testQuestionBuilder.addAnswer("Australia starts with the letter ‘A’.",true);
        IQuizQuestion testQuestion = testQuestionBuilder.create();
        terminalQuiz.addQuestion(testQuestion);
        assertEquals(expectedSize,terminalQuiz.getQuestionList().size());

    }
}