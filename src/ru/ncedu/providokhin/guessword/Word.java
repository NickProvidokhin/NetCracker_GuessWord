package ru.ncedu.providokhin.guessword;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Word {
    public Word() {
        guessWord = getWordFromBank();
        currentWord = new StringBuilder();
        currentWord.append(guessWord);
        for (int i = 0; i < currentWord.length(); i++) {
            currentWord.setCharAt(i,'_');
        }

    }

    public String guessWord;
    public StringBuilder currentWord;

    public String getWordFromBank() {
        Random rand = new Random();
        int rowNumber = 0;
        ArrayList<String> bank = new ArrayList<>();
        try {
            File file = new File("Bank.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                line = bufferedReader.readLine();
                rowNumber++;
                bank.add(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bank.get(rand.nextInt(rowNumber));
    }
}
