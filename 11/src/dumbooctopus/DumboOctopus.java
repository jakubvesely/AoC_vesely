package dumbooctopus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DumboOctopus {

    static int[][] grid;
    static boolean[][] light;

    public static void flash(int r, int s) {
        
        light[r][s] = true;
        grid[r + 1][s - 1]++;
        grid[r + 1][s]++;
        grid[r + 1][s + 1]++;
        grid[r][s - 1]++;
        grid[r][s + 1]++;
        grid[r - 1][s - 1]++;
        grid[r - 1][s]++;
        grid[r - 1][s + 1]++;

        if (grid[r + 1][s - 1] > 9 && !light[r + 1][s - 1]) {
            flash(r + 1, s - 1);
        }
        if (grid[r + 1][s] > 9 && !light[r + 1][s]) {
            flash(r + 1, s);
        }
        if (grid[r + 1][s + 1] > 9 && !light[r + 1][s + 1]) {
            flash(r + 1, s + 1);
        }
        if (grid[r][s - 1] > 9 && !light[r][s - 1]) {
            flash(r, s - 1);
        }
        if (grid[r][s + 1] > 9 && !light[r][s + 1]) {
            flash(r, s + 1);
        }
        if (grid[r - 1][s - 1] > 9 && !light[r - 1][s - 1]) {
            flash(r - 1, s - 1);
        }
        if (grid[r - 1][s] > 9 && !light[r - 1][s]) {
            flash(r - 1, s);
        }
        if (grid[r - 1][s + 1] > 9 && !light[r - 1][s + 1]) {
            flash(r - 1, s + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/dumbooctopus/data.txt");
        List<String> text = Files.readAllLines(path);
        int r = text.size();
        int s = text.get(0).length();

        grid = new int[r + 2][s + 2];
        light = new boolean[r + 2][s + 2];
        int sum = 0;
        int count = 0;
        int first= 0;
        boolean task1 = false;
        boolean task2 = false;

        for (int b = 0; b <= s + 1; b++) {
            light[0][b] = true;
            light[r + 1][b] = true;
        }
        for (int a = 1; a <= r; a++) {
            light[a][0] = true;
            light[a][s + 1] = true;

            for (int b = 1; b <= s; b++) {
                grid[a][b] = Character.getNumericValue(text.get(a - 1).charAt(b - 1));
                light[a][b] = false;
            }
        }
        int i = 0;
        while (!task1 || !task2) {
            count = 0;
            for (int a = 1; a <= r; a++) {
                for (int b = 1; b <= s; b++) {
                    grid[a][b]++;
                    if (!light[a][b] && grid[a][b] > 9) {
                        flash(a, b);
                    }
                }
            }
            for (int a = 1; a <= r; a++) {
                for (int b = 1; b <= s; b++) {
                    if (light[a][b]) {
                        light[a][b] = false;
                        grid[a][b] = 0;
                        count++;
                    }
                }
            }
            if (i < 100) {
                sum = sum + count;
            }else{
                task1=true;
            }
            i++;
            if(count==(r*s) && !task2){
                task2=true;
                first=i;
            }
        }
        
        System.out.println("Part 1: "+sum);
        System.out.println("Part 2: "+first);
    }
}