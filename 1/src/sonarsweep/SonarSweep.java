//Day 1: Sonar Sweep

package sonarsweep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SonarSweep {

    public static void main(String[] args) throws IOException {

        int a, b, n;
        int count = 0;
        int count2 = 0;

        int[] val = new int[3];
        int[] index = new int[4];
        int[] valTemp = new int[3];

        Path path = Paths.get("src/sonarsweep/data.txt");
        List<String> text = Files.readAllLines(path);
        n = text.size();

        //Part 1 
        a = Integer.parseInt(text.get(0));
        for (int i = 1; i < n; i++) {
            b = Integer.parseInt(text.get(i));
            if (b > a) {
                count++;
            }
            a = b;
        }

        //Part 2
        val[0] = Integer.parseInt(text.get(0)) + Integer.parseInt(text.get(1)) + Integer.parseInt(text.get(2));
        val[1] = Integer.parseInt(text.get(1)) + Integer.parseInt(text.get(2));
        val[2] = Integer.parseInt(text.get(2));
        index[0] = 0;
        index[1] = 2;
        index[2] = 1;

        for (int i = 3; i < n; i++) {
            for (int f = 0; f < 3; f++) {
                if (index[f] != 0) {
                    valTemp[f] = val[f] + Integer.parseInt(text.get(i));
                } else {
                    valTemp[f] = Integer.parseInt(text.get(i));
                }

                index[f]++;
            }

            if (index[0] == 3) {
                if (i > 3 && valTemp[0] > val[2]) {
                    count2++;
                }
                index[0] = 0;
            }

            for (int f = 1; f < 3; f++) {
                if (index[f] == 3) {
                    if (valTemp[f] > val[f - 1]) {
                        count2++;
                    }
                    index[f] = 0;
                }
            }
            System.arraycopy(valTemp, 0, val, 0, 3);

        }
        System.out.println("Part 1: " + count);
        System.out.println("Part 2: " + count2);

    }

}
