package sevensegmentsearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SevenSegmentSearch {

    static int commonChars(String s1, String s2) {
        int sol = 0;

        if (s1.contains("a") && s2.contains("a")) {
            sol++;
        }
        if (s1.contains("b") && s2.contains("b")) {
            sol++;
        }
        if (s1.contains("c") && s2.contains("c")) {
            sol++;
        }
        if (s1.contains("d") && s2.contains("d")) {
            sol++;
        }
        if (s1.contains("e") && s2.contains("e")) {
            sol++;
        }
        if (s1.contains("f") && s2.contains("f")) {
            sol++;
        }
        if (s1.contains("g") && s2.contains("g")) {
            sol++;
        }
        return sol;
    }

    static int entryToDigit(String[] model, String entry) {
        for (int i = 0; i < 10; i++) {
            if (commonChars(model[i], entry) == entry.length() && model[i].length() == entry.length()) {
                return i;
            }
        }
        return -1;
    }

    static int digitsToInt(int a[]) {
        int cif = 1;
        int sum = 0;
        for (int i = 3; i >= 0; i--) {
            sum = sum + (a[i] * cif);
            cif = cif * 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        int count = 0;
        int found = 0;
        int sum = 0;

        Path path = Paths.get("src/sevensegmentsearch/data.txt");
        List<String> text = Files.readAllLines(path);
        int n = text.size();
        String[][] input = new String[n][10];
        String[][] output = new String[n][4];
        int[] cifs = new int[4];
        String[] digits = new String[10];
        boolean[] empty = new boolean[10];
        boolean[] free = new boolean[10];

        for (int i = 0; i < n; i++) {
            String[] st1 = text.get(i).split(" ");
            System.arraycopy(st1, 0, input[i], 0, 10);
            for (int f = 0; f < 4; f++) {
                output[i][f] = st1[f + 11];
                int l = output[i][f].length();
                if (l == 2 || l == 3 || l == 4 || l == 7) {
                    count++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int f = 0; f < 10; f++) {
                empty[f] = true;
                free[f] = true;
                digits[f] = "";
            }
            found = 0;
            while (found < 10) {
                for (int f = 0; f < 10; f++) {
                    if (free[f]) {
                        int l = input[i][f].length();
                        switch (l) {
                            case 2 -> {
                                digits[1] = input[i][f];
                                empty[1] = false;
                                free[f] = false;
                                found++;
                            }
                            case 3 -> {
                                digits[7] = input[i][f];
                                empty[7] = false;
                                free[f] = false;
                                found++;
                            }
                            case 4 -> {
                                digits[4] = input[i][f];
                                empty[4] = false;
                                free[f] = false;
                                found++;
                            }
                            case 5 -> {

                                if (commonChars(input[i][f], digits[4]) == 2) {
                                    digits[2] = input[i][f];
                                    empty[2] = false;
                                    free[f] = false;
                                    found++;
                                } else if (commonChars(input[i][f], digits[1]) == 2) {
                                    digits[3] = input[i][f];
                                    empty[3] = false;
                                    free[f] = false;
                                    found++;
                                } else if (commonChars(input[i][f], digits[4]) == 3 && empty[1] == false) {
                                    digits[5] = input[i][f];
                                    empty[5] = false;
                                    free[f] = false;
                                    found++;
                                }
                            }
                            case 6 -> {
                                if (empty[4] == false) {
                                    if (commonChars(input[i][f], digits[4]) == 4) {
                                        digits[9] = input[i][f];
                                        empty[9] = false;
                                        free[f] = false;
                                        found++;

                                    } else if (commonChars(input[i][f], digits[1]) == 2) {
                                        digits[0] = input[i][f];
                                        empty[0] = false;
                                        free[f] = false;
                                        found++;

                                    } else if (empty[1] == false) {
                                        digits[6] = input[i][f];
                                        empty[6] = false;
                                        free[f] = false;
                                        found++;
                                    }
                                }
                            }
                            case 7 -> {
                                digits[8] = input[i][f];
                                empty[8] = false;
                                free[f] = false;
                                found++;
                            }
                        }
                    }
                }
            }
            for (int f = 0; f < 4; f++) {

                cifs[f] = entryToDigit(digits, output[i][f]);
            }
            sum=sum+digitsToInt(cifs);
        }
        
        System.out.println("Part 1: "+count);
        System.out.println("Part 2: "+sum);
    }
}