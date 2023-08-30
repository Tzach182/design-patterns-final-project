package il.ac.hit.quizzy;

public class QuizAnswer {
    private String answer;
    private boolean correct;

    public QuizAnswer(String question, boolean correct) {
        setAnswer(question);
        setCorrect(correct);
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
