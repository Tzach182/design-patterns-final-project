package il.ac.hit.quizzy;

public class QuizQuestion implements IQuizQuestion {


    public static class Builder implements IQuizQuestionBuilder {

        @Override
        public IQuizQuestionBuilder setTitle(String text) {
            return null;
        }

        @Override
        public IQuizQuestionBuilder setQuestion(String text) {
            return null;
        }

        @Override
        public IQuizQuestionBuilder addAnswer(String text, boolean correct) {
            return null;
        }

        @Override
        public IQuizQuestion create() {
            return null;
        }
    }
}
