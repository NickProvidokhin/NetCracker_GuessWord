package ru.ncedu.providokhin.guessword;

import java.util.Scanner;

public class Game {
    public void startGame() {
        Word word = new Word();
        boolean flag = true; //флаг когда игра закончиалсь
        int trial = 0;
        String line;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.print("Key in one character or your guess word:");
            line = scanner.nextLine();
            trial++;
            //проверка строка введена или нет
            if (line.length() > 1) {
                if (word.guessWord.toString().equals(line)) {
                    System.out.println("Congratulation!\n" + "You got in " + trial + " trials");
                    flag = false;
                } else {
                    System.out.println("You lose. Lucky next time");
                    flag = false;
                }
            } else {
                System.out.println("Trial:" + trial);
                char[] duplicateGuess = word.guessWord.toCharArray();
                char duplicateLine = line.charAt(0);
                for (int i = 0; i < duplicateGuess.length; i++) {
                    if (duplicateGuess[i] == duplicateLine) {
                        word.currentWord.setCharAt(i,duplicateGuess[i]);
                    }
                }
                System.out.println(word.currentWord);
                if (word.currentWord.toString().equals(word.guessWord)){
                    System.out.println("Congratulation!\n" + "You got in " + trial + " trials");
                    flag = false;
                }
            }
        }
    }

}
