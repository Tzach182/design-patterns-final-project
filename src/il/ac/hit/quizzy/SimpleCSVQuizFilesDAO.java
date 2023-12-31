package il.ac.hit.quizzy;
import java.io.*;
import java.util.Scanner;

/**
 * The `SimpleCSVQuizFilesDAO` class implements the `IQuizFilesDAO` interface and provides methods
 * for saving and loading quizzes to/from CSV files. It is responsible for converting quiz objects
 * into CSV format and vice versa.
 * This class uses the Singleton pattern to ensure there is only one instance of the DAO.
 *
 */
public class SimpleCSVQuizFilesDAO implements IQuizFilesDAO {
    private static SimpleCSVQuizFilesDAO instance;

    /**
     * Private constructor to enforce the Singleton pattern.
     */
    private SimpleCSVQuizFilesDAO() {
    }

    /**
     * Gets the singleton instance of the `SimpleCSVQuizFilesDAO`.
     *
     * @return The singleton instance of the DAO.
     */
    public static IQuizFilesDAO getInstance() {
        if (instance == null) {
            instance = new SimpleCSVQuizFilesDAO();
        }
        return instance;
    }

    /**
     * Saves a quiz to a CSV file.
     *
     * @param quiz     The quiz to be saved.
     * @param fileName The name of the CSV file to which the quiz will be saved.
     * @throws QuizException If an error occurs while saving the quiz to the file.
     */
    @Override
    public void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            //create a string from quiz type and quiz title
            StringBuilder questionData = new StringBuilder();
            questionData.append(quiz.getQuizType().toString()).append(", ");
            questionData.append(quiz.getName()).append(System.lineSeparator());
            //create a string for each question
            for (IQuizQuestion question : quiz.getQuestionList()) {

                questionData.append(question.toString()).append(System.lineSeparator());
            }
            fileWriter.write(questionData.toString());
        } catch (IOException e) {
            throw new QuizException("Error writing to CSV file", e);
        }
    }

    /**
     * Loads a quiz from a CSV file.
     *
     * @param fileName The name of the CSV file from which the quiz will be loaded.
     * @return The loaded quiz.
     * @throws QuizException If an error occurs while loading the quiz from the file.
     */
    @Override
    public IQuiz loadQuizFromFile(String fileName) throws QuizException {
        QuizFactory factory = new QuizFactory();
        IQuiz quiz;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useDelimiter(System.lineSeparator());
            String quizInfo = scanner.next(); //Handling quiz info
            String[] infoBrokenDown = quizInfo.split(", ");
            quiz = factory.createQuiz(getTypeFromFile(infoBrokenDown[0]));
            quiz.setName(infoBrokenDown[1]);

            while (scanner.hasNext())  //handling each question separately
            {
                String question = scanner.next();
                String[] questionBrokenDown = question.split(", ");
                IQuizQuestion questionBuilt = buildQuestionFromRow(questionBrokenDown);
                quiz.addQuestion(questionBuilt);

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new QuizException("file not found", e);
        }

        return quiz;
    }

    private QuizType getTypeFromFile(String type) {
        QuizType returnType = QuizType.TERMINAL;

        if (type.equals("GUI")) {
            returnType = QuizType.GUI;


        }
        return returnType;

    }


    private IQuizQuestion buildQuestionFromRow (String[]question) throws QuizException {

        IQuizQuestionBuilder questionBuilder = new QuizQuestion.Builder();
        questionBuilder.setTitle(question[0]);
        questionBuilder.setQuestion(question[1]);
        try {
            for (int idx = 2; idx < question.length - 1; idx += 2) {
                questionBuilder.addAnswer(question[idx], Boolean.parseBoolean(question[idx + 1]));
            }
        } catch (Exception e) {
            throw new QuizException("answer not built according to specification");
        }
        return questionBuilder.create();
    }


}