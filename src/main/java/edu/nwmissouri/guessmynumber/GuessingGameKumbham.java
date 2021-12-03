package edu.nwmissouri.guessmynumber;

import javax.swing.*;

/**
 * “Guess a Number” game that allows user to guess a random number. Uses Swing
 * to make a nice graphical user interface.
 *
 * Original Source: https://hackr.io/blog/java-projects
 *
 * Read about jOptionPane:
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 * .showInputDialog() .showMessageDialog()
 *
 * @author Nithin Reddy Kumbham
 */
public class GuessingGameKumbham {

    public static void main(String[] args) {
        int secretNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + secretNumber);
        int count = 1;

        while (userAnswer != secretNumber) {
             String message = "Enter a guess between 1 and 100"; 
             String title = "Guessing Game"; 
             int messageType = JOptionPane.INFORMATION_MESSAGE;
            String response = JOptionPane.showInputDialog(null,message, title, messageType);
            userAnswer = Integer.parseInt(response);

            JOptionPane.showMessageDialog(null, "" + calculateMessage(userAnswer, secretNumber, count));
            count++;
        }
    }

    public static String calculateMessage(int userAnswer, int computerNumber, int count) {
        String k = (count ==1) ? "guess." : "guesses.";
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nYou've used: " + count + k;
        } else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nYou've used: " + count + k;
        } else {
            return "Your guess is incorrect\nYou've used: " + count;
        }
    }
}
