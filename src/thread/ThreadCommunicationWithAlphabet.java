package thread;

//import javax.swing.*;

public class ThreadCommunicationWithAlphabet {


    private static final Object lock = new Object();
    private static boolean isAlphabetTurn = true; // Start with the alphabet thread

    public static void main(String[] args) {
        // Thread 1: Prints all letters
        Thread alphabetThread = new Thread(() -> {
            synchronized (lock) {
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    while (!isAlphabetTurn) { // Wait if it's not this thread's turn
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(letter + " "); // Print the letter
                    isAlphabetTurn = false; // Switch to number thread
                    lock.notify(); // Notify the number thread
                }
            }
        });

        // Thread 2: Prints a=1, b=2, etc.
        Thread numberThread = new Thread(() -> {
            synchronized (lock) {
                for (int number = 1; number <= 26; number++) {
                    while (isAlphabetTurn) { // Wait if it's not this thread's turn
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("= " + number); // Print formatted output
                    isAlphabetTurn = true; // Switch back to alphabet thread
                    lock.notify(); // Notify the alphabet thread
                }
            }
        });

        alphabetThread.start();
        numberThread.start();
    }
}