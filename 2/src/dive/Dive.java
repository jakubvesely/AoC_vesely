//Day 2: Dive!
package dive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Dive {

    public static void main(String[] args) throws IOException {

        int ver = 0;
        int hor = 0;

        Path path = Paths.get("src/dive/data.txt");
        List<String> text = Files.readAllLines(path);
        int n = text.size();

        //Part 1
        for (int i = 0; i < n; i++) {

            String[] st = text.get(i).split(" ");
            int val = Integer.parseInt(st[1]);

            switch (st[0]) {
                case "forward":
                    hor = hor + val;
                    break;
                case "down":
                    ver = ver + val;
                    break;
                case "up":
                    ver = ver - val;
                    break;
            }
        }
        int sol1 = ver * hor;
        //Part 2
        int aim = 0;

        ver = 0;
        hor = 0;
        for (int i = 0; i < n; i++) {
            String[] st = text.get(i).split(" ");
            int val = Integer.parseInt(st[1]);
            switch (st[0]) {
                case "forward":
                    hor = hor + val;
                    ver = ver + val * aim;
                    break;
                case "down":
                    aim = aim + val;
                    break;
                case "up":
                    aim = aim - val;
                    break;
            }
        }
        int sol2 = ver * hor;
        System.out.println("Part 1: " + sol1);
        System.out.println("Part 2: " + sol2);
    }

}
