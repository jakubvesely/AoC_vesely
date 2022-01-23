
package syntaxscoring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SyntaxScoring {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/syntaxscoring/data.txt");
        List<String> text = Files.readAllLines(path);
        int r = text.size();
        int sum = 0;

        long[] lines = new long[r];
        int l = 0;

        for (int i = 0; i < r; i++) {
            int a = 0;
            int s = text.get(i).length();
            char[] chunks = new char[r];
            boolean run = true;
            for (int k = 0; k < s; k++) {
                char ch = text.get(i).charAt(k);

                switch (ch) {
                    case ')':
                        if (chunks[a - 1] == '(') {
                            a--;
                        } else {
                            sum = sum + 3;
                            run = false;
                        }
                        break;
                    case ']':
                        if (chunks[a - 1] == '[') {
                            a--;
                        } else {
                            sum = sum + 57;
                            run = false;
                        }
                        break;
                    case '}':
                        if (chunks[a - 1] == '{') {
                            a--;
                        } else {
                            sum = sum + 1197;
                            run = false;
                        }
                        break;
                    case '>':
                        if (chunks[a - 1] == '<') {
                            a--;
                        } else {
                            sum = sum + 25137;
                            run = false;
                        }
                        break;
                    default:
                        chunks[a] = ch;
                        a++;
                }
                if (!run) {
                    break;
                }
            }
            if (run && a > 0) {
                a--;
                long sol = 0;
                for (int k = a; k >= 0; k--) {
                    sol = sol * 5;

                    switch (chunks[k]) {
                        case '(':
                            sol = sol + 1;
                            break;
                        case '[':
                            sol = sol + 2;
                            break;
                        case '{':
                            sol = sol + 3;
                            break;
                        case '<':
                            sol = sol + 4;
                            break;
                    }
                }
                lines[l] = sol;
                l++;
            }
        }
        int ix = 0;
        for (int i = 0; i < l; i++) {
            long min = Long.MAX_VALUE;
            for (int k = i; k < l; k++) {
                if (lines[k] < min) {
                    min = lines[k];
                    ix = k;
                }
            }
            long p = lines[ix];
            lines[ix] = lines[i];
            lines[i] = p;
        }
        
        long mid=lines[(int)Math.ceil(l/2)];
        System.out.println("Part 1: "+sum);
        System.out.println("Part 2: "+mid);
    }

}
