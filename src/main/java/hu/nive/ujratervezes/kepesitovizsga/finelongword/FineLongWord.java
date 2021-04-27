package hu.nive.ujratervezes.kepesitovizsga.finelongword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FineLongWord {
    public char[] readFineLongWordFromFileAndGetItInAnArray(String fileName) {
        List<Character> characters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(FineLongWord.class.getResourceAsStream("/" + fileName)))){
            String line;
            while ((line = reader.readLine()) != null) {
                if (characters.isEmpty()) {
                    for (char item:line.toCharArray()) {
                        characters.add(item);
                    }
                }else {
                    characters.add(line.charAt(line.length() - 1));
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        char[] result = new char[characters.size()];
        int i = 0;
        for (char item:characters) {
            result[i++] = item;
        }
        return result;
    }
}
