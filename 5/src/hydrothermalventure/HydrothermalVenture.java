//Day 5: Hydrothermal Venture
package hydrothermalventure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HydrothermalVenture {

    public static int count(int[][] a, int mX, int mY) {
        int sol = 0;
        for (int x = 0; x <= mX; x++) {
            for (int y = 0; y <= mY; y++) {
                if (a[x][y] >= 2) {
                    sol++;
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/hydrothermalventure/data.txt");
        List<String> text = Files.readAllLines(path);
        int n = text.size();

        int sX[] = new int[n];
        int sY[] = new int[n];
        int eX[] = new int[n];
        int eY[] = new int[n];

        int mX = 0;
        int mY = 0;

        for (int i = 0; i < n; i++) {
            String[] stFull = text.get(i).split(" -> ");
            String[] st1 = stFull[0].split(",");
            String[] st2 = stFull[1].split(",");
            sX[i] = Integer.parseInt(st1[0]);
            sY[i] = Integer.parseInt(st1[1]);
            eX[i] = Integer.parseInt(st2[0]);
            eY[i] = Integer.parseInt(st2[1]);

            if (sX[i] > mX) {
                mX = sX[i];
            }
            if (eX[i] > mX) {
                mX = eX[i];
            }
            if (sY[i] > mY) {
                mY = sY[i];
            }
            if (eY[i] > mY) {
                mY = eY[i];
            }
        }
        int grid[][] = new int[mX + 1][mY + 1];
        for (int x = 0; x < mX + 1; x++) {
            for (int y = 0; y < mY + 1; y++) {
                grid[x][y] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (sX[i] == eX[i] || sY[i] == eY[i]) {
                if (sX[i] > eX[i]) {
                    for (int x = eX[i]; x <= sX[i]; x++) {
                        grid[x][sY[i]]++;
                    }
                }
                if (sX[i] < eX[i]) {
                    for (int x = sX[i]; x <= eX[i]; x++) {
                        grid[x][sY[i]]++;
                    }
                }
                if (sY[i] > eY[i]) {
                    for (int y = eY[i]; y <= sY[i]; y++) {
                        grid[sX[i]][y]++;
                    }
                }
                if (sY[i] < eY[i]) {
                    for (int y = sY[i]; y <= eY[i]; y++) {
                        grid[sX[i]][y]++;
                    }
                }
            }
        }
        int sol1 = count(grid, mX, mY);

        //2. Part
        for (int i = 0; i < n; i++) {
            if (Math.abs(sX[i] - eX[i]) == Math.abs(sY[i] - eY[i])) {
                int dif;
                if (sX[i] > eX[i]) {
                    if (sY[i] > eY[i]) {//1
                        dif = Math.abs(sX[i] - eX[i]);
                        for (int a = 0; a <= dif; a++) {
                            grid[sX[i] - a][sY[i] - a]++;
                        }
                    }
                    if (sY[i] < eY[i]) {//2
                        dif = Math.abs(sX[i] - eX[i]);
                        for (int a = 0; a <= dif; a++) {
                            grid[sX[i] - a][sY[i] + a]++;
                        }
                    }
                }
                if (sX[i] < eX[i]) {
                    if (sY[i] > eY[i]) {//3
                        dif = Math.abs(eX[i] - sX[i]);
                        for (int a = 0; a <= dif; a++) {
                            grid[sX[i] + a][sY[i] - a]++;
                        }
                    }
                    if (sY[i] < eY[i]) {//4
                        dif = Math.abs(eX[i] - sX[i]);
                        for (int a = 0; a <= dif; a++) {
                            grid[sX[i] + a][sY[i] + a]++;
                        }
                    }
                }
            }
        }
        int sol2 = count(grid, mX, mY);

        System.out.println("Part 1: " + sol1);
        System.out.println("Part 2: " + sol2);
    }

}