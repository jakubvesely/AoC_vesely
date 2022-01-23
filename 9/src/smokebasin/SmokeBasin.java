
package smokebasin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SmokeBasin {

    static int[][] grid;
    static boolean[][] free;
    int a = 0;

    public static int mesBasin(int r, int s) {

        int sum = 1;
        free[r][s] = false;

        if (free[r + 1][s] && grid[r + 1][s] < 9) {
            sum = sum + mesBasin(r + 1, s);
        }
        if (free[r - 1][s] && grid[r - 1][s] < 9) {
            sum = sum + mesBasin(r - 1, s);
        }
        if (free[r][s + 1] && grid[r][s + 1] < 9) {
            sum = sum + mesBasin(r, s + 1);
        }
        if (free[r][s - 1] && grid[r][s - 1] < 9) {
            sum = sum + mesBasin(r, s - 1);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/smokebasin/data.txt");
        List<String> text = Files.readAllLines(path);
        int r = text.size();
        int s = text.get(0).length();
        grid = new int[r + 2][s + 2];
        free = new boolean[r + 2][s + 2];
        int[] basins = new int[5 * r];
        int b = 0;

        for (int i = 0; i <= r + 1; i++) {
            for (int k = 0; k <= s + 1; k++) {
                free[i][k] = true;
            }
        }
        for (int i = 0; i < s + 2; i++) {
            grid[0][i] = 10;
            grid[r + 1][i] = 10;
        }
        for (int i = 1; i <= r; i++) {
            grid[i][0] = 10;
            grid[i][s + 1] = 10;
            
            for (int k = 1; k <= s; k++) {
                grid[i][k] = Character.getNumericValue(text.get(i - 1).charAt(k - 1));
            }
        }
        int sum = 0;
        for (int i = 1; i <= r; i++) {
            for (int k = 1; k <= s; k++) {
                if (grid[i][k] < grid[i + 1][k] && grid[i][k] < grid[i - 1][k] && grid[i][k] < grid[i][k + 1] && grid[i][k] < grid[i][k - 1] && free[i][k]) {
                    sum = sum + grid[i][k] + 1;
                    basins[b] = mesBasin(i, k);
                    b++;
                }
            }
        }
        int top[]= new int[3];
        int a=0;
        for (int i = 0; i < 3; i++) {
            int max = 0;
            for (int k = 0; k < b; k++) {
                if (basins[k] > max) {
                    max = basins[k];
                    a=k;
                }
            }
            top[i]=max;
            basins[a]=0;     
        }
        int sol=1;
                for(int i=0;i<3;i++){
            sol=sol*top[i];
        }

        System.out.println("Part 1: " + sum);
        System.out.println("Part 2: " + sol);
    }
}