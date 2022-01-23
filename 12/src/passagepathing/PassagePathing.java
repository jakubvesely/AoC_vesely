package passagepathing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PassagePathing {

    static Cave[] caves;
    static int count = 0;
    static int start;
    static int end;

    public static int find(String name) {
        for (int i = 0; i < count; i++) {
            if (name.equals(caves[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    public static int path(int ix, boolean[] free) {
        boolean[] f = new boolean[free.length];
        System.arraycopy(free, 0, f, 0, free.length);
        int score = 0;
        int c = caves[ix].getCount();
        int[] j = caves[ix].getJoints();

        if (!caves[ix].getType()) {
            f[ix] = false;
        }
        if (ix == end) {
            return 1;
        } else {
            for (int i = 0; i < c; i++) {
                if (f[j[i]]) {
                    score = score + path(j[i], f);
                }
            }
        }
        return score;
    }
    
    public static int path2(int ix, boolean[] free, boolean twice) {
        boolean[] f = new boolean[free.length];
        System.arraycopy(free, 0, f, 0, free.length);
        int score = 0;
        int c = caves[ix].getCount();
        int[] j = caves[ix].getJoints();

        if (!caves[ix].getType()) {
            f[ix] = false;
        }
        if (ix == end) {
            return 1;
        } else {
            for (int i = 0; i < c; i++) {
                if (f[j[i]]) {
                    score = score + path2(j[i], f, twice);
                } else if (!twice && j[i] != start) {
                    score = score + path2(j[i], f, true);      
                }
            }
        }
        return score;
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/passagepathing/data.txt");
        List<String> text = Files.readAllLines(path);
        int r = text.size();
        caves = new Cave[r];
        for (int i = 0; i < r; i++) {
            String[] st = text.get(i).split("-");
            if (find(st[0]) == -1) {
                caves[count] = new Cave(st[0], r);
                count++;
            }
            if (find(st[1]) == -1) {
                caves[count] = new Cave(st[1], r);
                count++;
            }
            caves[find(st[0])].connect(find(st[1]));
            caves[find(st[1])].connect(find(st[0]));
        }
        start = find("start");
        end = find("end");

        boolean[] free = new boolean[count];
        for (int i = 0; i < count; i++) {
            free[i] = true;
        }
        int score1 = path(start, free);
        int score2 = path2(start, free,false);

        System.out.println("Part 1: "+score1);
        System.out.println("Part 2: "+score2);

    }

}
