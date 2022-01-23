package thetreacheryofwhales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TheTreacheryofWhales {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/thetreacheryofwhales/data.txt");
        List<String> text = Files.readAllLines(path);
        String[] st = text.get(0).split(",");

        int n = st.length;
        int[] num = new int[n];
        int fuel;
        int fuel2;
        int max = 0;
        int min = Integer.MAX_VALUE;
        int sol = Integer.MAX_VALUE;
        int sol2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st[i]);

            if (num[i] > max) {
                max = num[i];
            }
            if (num[i] < min) {
                min = num[i];
            }
        }
        int dif = max - min;
        int con[] = new int[dif + 1];
        con[0] = 0;
        for (int i = 1; i <= dif; i++) {
            con[i] = con[i - 1] + i;
        }

        for (int i = min; i <= max; i++) {
            fuel = 0;
            fuel2 = 0;
            for (int f = 0; f < n; f++) {
                int inc = Math.abs(i - num[f]);
                fuel = fuel + inc;
                fuel2 = fuel2 + con[inc];
            }
            if (fuel < sol) {
                sol = fuel;
            }
            if (fuel2 < sol2) {
                sol2 = fuel2;
            }
        }
        System.out.println("Part 1: " + sol);
        System.out.println("Part 2: " + sol2);
    }
}
