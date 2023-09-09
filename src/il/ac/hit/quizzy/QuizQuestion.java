package il.ac.hit.quizzy;

import java.util.LinkedList;
import java.util.List;

/**
 * The `QuizQuestion` class represents a quiz question with a title, question text,
 * and a list of possible answers. It implements the `IQuizQuestion` interface and
 * provides methods to set and retrieve the question's properties.
 *
 */
public class QuizQuestion implements IQuizQuestion {
    private String title;
    private String question;
    private List<QuizAnswer> answerList = new LinkedList<>();

    /**
     * Default constructor for a `QuizQuestion` object.
     */
    public QuizQuestion() { }


    @Override
    public void setTitle(String text) {
        this.title = text;
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setQuestion(String text) {
        this.question = text;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setAnswerList(List<QuizAnswer> answerList) {
        this.answerList = answerList;
    }

    public List<QuizAnswer> getAnswerList() {
        return answerList;
    }

    @Override
    public List<String> getAnswerText() {
        List<String> answersStringList = new LinkedList<>();
        for (QuizAnswer answer : getAnswerList()) {
            answersStringList.add(answer.getAnswer());
        }
        return answersStringList;
    }

    @Override
    public Boolean isAnswerCorrect(int index) {
        return getAnswerList().get(index).isCorrect();
    }

    @Override
    public Object clone() {
        IQuizQuestionBuilder cloneBuilder = new QuizQuestion.Builder();
        cloneBuilder.setTitle(this.getTitle());
        cloneBuilder.setQuestion(this.getQuestion());
        //create each answer separately
        for (QuizAnswer answer: getAnswerList()) {
            String cloneAnswer = answer.getAnswer();
            boolean cloneIsCorrect = answer.isCorrect();
            cloneBuilder.addAnswer(cloneAnswer,cloneIsCorrect);
        }

        return cloneBuilder.create();

    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder(getTitle() + ", ");
        text.append(getQuestion()).append(", ");
        for (QuizAnswer answer : getAnswerList()) {
            text.append(answer.getAnswer()).append(", ").append(answer.isCorrect());
            text.append(", ");
        }
        return text.toString();
    }


    /**
     * The `Builder` class provides a convenient way to construct `QuizQuestion` objects.
     * It implements the `IQuizQuestionBuilder` interface and allows you to set the
     * title, question text, and answers for a quiz question.
     */
    public static class Builder implements IQuizQuestionBuilder {
        String questionTitle;
        String builderQuestion;
        List<QuizAnswer> answers = new LinkedList<>();

        public Builder() { }

        @Override
        public IQuizQuestionBuilder setTitle(String text) {
            questionTitle = text;
            return this;
        }

        @Override
        public IQuizQuestionBuilder setQuestion(String text) {
            builderQuestion = text;
            return this;
        }

        @Override
        public IQuizQuestionBuilder addAnswer(String text, boolean isCorrect) {
            answers.add(new QuizAnswer(text,isCorrect));
            return this;
        }

        @Override
        public IQuizQuestion create() {
            IQuizQuestion question = new QuizQuestion();
            question.setTitle(questionTitle);
            question.setQuestion(builderQuestion);
            question.setAnswerList(answers);

            return question;
        }
    }
}
