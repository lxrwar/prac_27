import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] questions = {
                "1. What is the correct demonstrative pronoun for 'this'?",
                "a) These",
                "b) Those",
                "c) That",
                "d) None of the above",
                "2. Which pronoun is used as the object of a verb or preposition?",
                "a) Subject pronoun",
                "b) Possessive pronoun",
                "c) Reflexive pronoun",
                "d) Object pronoun",
                // Add more questions here
        };

        String[] answers = {"c", "d"};

        System.out.println("Welcome to the English Pronoun Quiz!");
        System.out.println("You will be asked 5 questions. Enter 'q' at any time to quit.");
        System.out.println("Please enter the letter corresponding to your answer.");

        int totalQuestions = questions.length / 5;
        int score = 0;

        for (int i = 0; i < questions.length; i += 5) {
            System.out.println("\n" + questions[i]);
            for (int j = i + 1; j < i + 5; j++) {
                System.out.println(questions[j]);
            }

            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase("q")) {
                break;
            } else if (!userAnswer.matches("[abcd]")) {
                System.out.println("Invalid option. Please try again.");
                i -= 5; // Repeat the current question
                continue;
            }

            if (userAnswer.equalsIgnoreCase(answers[i / 5])) {
                score++;
            }
        }

        double percentage = (double) score / totalQuestions * 100;
        System.out.println("\nTest completed!");
        System.out.println("Your score: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + percentage + "%");

        System.out.println("Enter the administrator password to view the correct answers:");
        String password = scanner.nextLine();

        if (password.equals("1111")) {
            System.out.println("Correct answers:");
            for (int i = 0; i < totalQuestions; i++) {
                System.out.println("Question " + (i + 1) + ": " + answers[i]);
            }
        }

        scanner.close();
    }
}
