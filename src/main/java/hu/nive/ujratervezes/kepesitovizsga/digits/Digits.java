package hu.nive.ujratervezes.kepesitovizsga.digits;

public class Digits {
    public int getNumbers() {
        int counter = 0;
        for (int i = 10; i < 100; i++) {
            int firstDigit = i / 10;
            int secondDigit = i % 10;
            if (Math.abs(firstDigit - secondDigit) == 5) {
                counter++;
            }
        }
        return counter;
    }
}
