package il.ac.hit.quizzy;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class UITerminal implements IUIMedia {
    Scanner input = new Scanner(System.in);

    @Override
    public void initialize(int quizLength) {

        System.out.println("Welcome to the quiz");
        System.out.println("You will be asked " + quizLength + " questions");
          // Create a Scanner object
        System.out.println("Enter any key to continue");
        input.nextLine();  // Read user input

        // Output user input

    }

    @Override
    public void showQuestion(String title,String question, List<String> answers) {
        System.out.println(title);
        System.out.println(question);

        for (int index = 0; index < answers.size(); index++) {
            System.out.println((index + 1) + ". "+ answers.get(index));
        }
        System.out.println(System.lineSeparator() + "Enter the number of correct answer: ");

    }



    @Override
    public void showScore(int score) {
        System.out.println("Your score is: " + score);
    }

    @Override
    public int getUserInput() {
        return input.nextInt();
    }


}
