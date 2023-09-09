package il.ac.hit.quizzy;


/**
 * The {@code QuizAnswer} class represents an answer option for a quiz question.
 * It contains information about the answer text and whether it is correct.
 */
public class QuizAnswer {
    private String answer;
    private boolean correct;

    /**
     * Constructs a new {@code QuizAnswer} object with the given answer text
     * and correctness status.
     *
     * @param answer  The answer text.
     * @param correct {@code true} if this answer is correct, {@code false} otherwise.
     */
    public QuizAnswer(String answer, boolean correct) {
        setAnswer(answer);
        setCorrect(correct);
    }

    /**
     * Check if this answer is correct.
     *
     * @return {@code true} if the answer is correct, {@code false} otherwise.
     */
    public boolean isCorrect() {
        return correct;
    }

    /**
     * Set the correctness status of this answer.
     *
     * @param correct {@code true} if this answer is correct, {@code false} otherwise.
     */
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    /**
     * Get the answer text.
     *
     * @return The answer text.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Set the answer text.
     *
     * @param answer The answer text to set.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
