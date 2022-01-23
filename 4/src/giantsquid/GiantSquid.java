//Day 4: Giant Squid

package giantsquid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GiantSquid {

    public static void main(String[] args) throws IOException {

        int firstWinner = 0;
        int firstNumber = 0;
        int firstSum = 0;
        int firstSol = 0;

        int winner = 0;
        int number = 0;
        int sum = 0;
        int lastSol = 0;

        boolean first = true;

        Path path = Paths.get("src/giantsquid/data.txt");
        List<String> text = Files.readAllLines(path);
        int n = text.size();
        int boardCount = (n - 1) / 6;


        String[] seqString = text.get(0).split(",");
        int m = seqString.length;
        int[] seq = new int[m];
        for (int i = 0; i < m; i++) {
            seq[i] = Integer.parseInt(seqString[i]);
        }
        int[][][] boards = new int[5][5][boardCount];
        boolean active[][][] = new boolean[5][5][boardCount];
        boolean completed[] = new boolean[boardCount];
        int[][] scoreR = new int[5][boardCount];
        int[][] scoreC = new int[5][boardCount];

        int l = 2;
        for (int i = 0; i < boardCount; i++) {
            completed[i] = true;

            for (int y = 0; y < 5; y++) {
                scoreR[y][i] = 0;
                scoreC[y][i] = 0;
                String[] line = text.get(l + y).trim().replaceAll(" +", " ").split(" ");
                for (int x = 0; x < 5; x++) {
                    active[x][y][i] = true;
                    boards[x][y][i] = Integer.parseInt(line[x]);
                }
            }
            l = l + 6;
        }
        int s = 0;
        int i = 0;
        int x = 0;
        int y = 0;
        boolean run = true;
        boolean search = true;
        while (run && s < m) {
            while (run && i < boardCount) {

                while (completed[i] && search && y < 5) {
                    while (search && x < 5) {
                        if (active[x][y][i]) {
                            if (boards[x][y][i] == seq[s]) {
                                scoreR[y][i]++;
                                scoreC[x][i]++;
                                active[x][y][i] = false;
                                search = false;
                                if (scoreR[y][i] >= 5 || scoreC[x][i] >= 5) {
                                    winner = i;
                                    number = seq[s];
                                    completed[i] = false;
                                    if (first) {
                                        firstWinner = winner;
                                        firstNumber = number;
                                        first = false;
                                    }
                                }
                            }
                        }
                        x++;
                    }
                    x = 0;
                    y++;
                }
                search = true;
                y = 0;
                i++;
            }
            i = 0;
            s++;
        }
        for (y = 0; y < 5; y++) {
            for (x = 0; x < 5; x++) {
                if (active[x][y][firstWinner]) {
                    firstSum = firstSum + boards[x][y][firstWinner];
                }
            }
        }
        firstSol = firstSum * firstNumber;
        

        for (y = 0; y < 5; y++) {
            for (x = 0; x < 5; x++) {
                if (active[x][y][winner]) {
                    sum = sum + boards[x][y][winner];
                }
            }
        }
        lastSol = sum * number;
        
        System.out.println("Part 1: "+firstSol);
        System.out.println("Part 2: "+lastSol);

    }
}
