package il.ac.hit.quizzy;
import java.io.*;
import java.util.Scanner;

public class SimpleCSVQuizFilesDAO implements IQuizFilesDAO{
    private static SimpleCSVQuizFilesDAO instance;

    private SimpleCSVQuizFilesDAO() {    }
    public static IQuizFilesDAO getInstance() {
        if (instance == null) {
            instance = new SimpleCSVQuizFilesDAO();
        }
        return instance;
    }

    @Override
    public void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {

            StringBuilder questionData = new StringBuilder();
            questionData.append(quiz.getQuizType().toString()).append(", ");
            questionData.append(quiz.getName()).append(System.lineSeparator());

            for (IQuizQuestion question : quiz.getQuestionList()) {

                questionData.append(question.toString()).append(System.lineSeparator());
            }
            fileWriter.write(questionData.toString());
        } catch (IOException e) {
            throw new QuizException("Error writing to CSV file", e);
        }
    }

    @Override
    public IQuiz loadQuizFromFile(String fileName) throws QuizException {
        QuizFactory factory = new QuizFactory();
        IQuiz quiz;
        try{
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useDelimiter(System.lineSeparator());
            String quizInfo = scanner.next(); //Handling quiz info
            String[] infoBrokenDown = quizInfo.split(", ");
            if(infoBrokenDown[0].equals("TERMINAL")){
                quiz = factory.createQuiz(QuizType.TERMINAL);
            }
            else{
                quiz = factory.createQuiz(QuizType.GUI);
            }

            quiz.setName(infoBrokenDown[1]);

            while (scanner.hasNext())  //handling each question separately
            {
                String question = scanner.next();
                String[] questionBrokenDown = question.split(", ");
                IQuizQuestion questionBuilt = buildQuestionFromRow(questionBrokenDown);
                quiz.addQuestion(questionBuilt);

                //System.out.print(scanner.next());  //find and returns the next complete token from this scanner
            }
            scanner.close();
        } catch (FileNotFoundException e){
            throw new QuizException("file not found", e);
        }

        return quiz;
    }


    public IQuizQuestion buildQuestionFromRow(String[] question) throws QuizException {

        IQuizQuestionBuilder questionBuilder = new QuizQuestion.Builder();
        questionBuilder.setTitle(question[0]);
        questionBuilder.setQuestion(question[1]);
        try {
            for (int idx = 2; idx < question.length - 1; idx += 2) {
                questionBuilder.addAnswer(question[idx], Boolean.parseBoolean(question[idx + 1]));
            }
        }catch (Exception e) {
            throw new QuizException("answer not built according to specification");
        }
        return questionBuilder.create();
    }


}
