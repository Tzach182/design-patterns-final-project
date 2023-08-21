package il.ac.hit.quizzy;

public class QuizAnswer {
    private String question;
    private boolean correct;

    public QuizAnswer(String question, boolean correct) {
        setQuestion(question);
        setCorrect(correct);
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
