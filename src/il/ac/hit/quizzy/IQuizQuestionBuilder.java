package il.ac.hit.quizzy;

/**
 * The {@code IQuizQuestionBuilder} interface defines a builder pattern for creating
 * instances of {@code IQuizQuestion}. It provides methods for setting the title,
 * question text, adding answers, and creating a quiz question.
 */
public interface IQuizQuestionBuilder {

    /**
     * Set the title of the quiz question.
     *
     * @param text The title to set for the question.
     * @return This builder instance for method chaining.
     */
    public IQuizQuestionBuilder setTitle(String text);

    /**
     * Set the text of the quiz question.
     *
     * @param text The text of the question.
     * @return This builder instance for method chaining.
     */
    public IQuizQuestionBuilder setQuestion(String text);

    /**
     * Add an answer option to the quiz question.
     *
     * @param text         The text of the answer option.
     * @param correctAnswer {@code true} if this answer is correct, {@code false} otherwise.
     * @return This builder instance for method chaining.
     */
    public IQuizQuestionBuilder addAnswer(String text, boolean correctAnswer);

    /**
     * Create a new instance of {@code IQuizQuestion} based on the builder's configuration.
     *
     * @return A new {@code IQuizQuestion} instance.
     */
    public IQuizQuestion create();
}
