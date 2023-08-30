package il.ac.hit.quizzy;

import java.util.LinkedList;
import java.util.List;

public class QuizQuestion implements IQuizQuestion {
    private String title;
    private String question;
    private List<QuizAnswer> answerList = new LinkedList<>();

    public QuizQuestion(String title, String question) {
        setTitle(title);
        setQuestion(question);
    }

    public QuizQuestion() { }


    @Override
    public void setTitle(String text) {
        this.title = text;
    }

    @Override
    public void setQuestion(String text) {
        this.question = text;
    }

    @Override
    public void setAnswerList(List<QuizAnswer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswerText() {
        return null;
    }

    @Override
    public Boolean isAnswerCorrect() {
        return null;
    }

    @Override
    public Object clone() {
        IQuizQuestionBuilder cloneBuilder = new QuizQuestion.Builder();
        cloneBuilder.setTitle(this.getTitle());
        cloneBuilder.setQuestion(this.getQuestion());

        for (QuizAnswer answer: answerList) {
            String cloneAnswer = answer.getAnswer();
            boolean cloneIsCorrect = answer.isCorrect();
            cloneBuilder.addAnswer(cloneAnswer,cloneIsCorrect);
        }

        return cloneBuilder.create();


    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder(title + ", ");
        text.append(question).append(", ");
        for (QuizAnswer answer : answerList) {
            text.append(answer.getAnswer()).append(", ").append(answer.isCorrect());
            text.append(", ");
        }
        return text.toString();
    }

    public static class Builder implements IQuizQuestionBuilder {
        String questionTitle;
        String builderQuestion;
        List<QuizAnswer> answers = new LinkedList<>();

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
