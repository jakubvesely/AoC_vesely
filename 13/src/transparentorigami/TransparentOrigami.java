package transparentorigami;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TransparentOrigami {

    static ArrayList<Integer> x = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();
    static int[] f;
    static char[] dir;
    static int dots;
    static int folds;

    public static boolean duplicate(int xc, int yc) {

        for (int i = 0; i < dots; i++) {

            if (xc == x.get(i) && yc == y.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/transparentorigami/data.txt");
        List<String> text = Files.readAllLines(path);
        int r = text.size();

        dots = 0;
        folds = 0;
        boolean load = true;

        int sol=0;
        int k = 0;
        while (load) {
            String st = text.get(k);
            if (st.contains(",")) {
                String[] sp = st.split(",");
                x.add(Integer.parseInt(sp[0]));
                y.add(Integer.parseInt(sp[1]));
                dots++;
            } else {
                load = false;
            }
            k++;
        }
        f = new int[r - k];
        dir = new char[r - k];
        folds = r - k;

        for (int i = 0; i < r - k; i++) {
            String st = text.get(k + i);
            String[] sp1 = st.split(" ");
            String[] sp2 = sp1[2].split("=");

            dir[i] = sp2[0].charAt(0);
            f[i] = Integer.parseInt(sp2[1]);
        }

        for (int i = 0; i < folds; i++) {

            if (dir[i] == 'x') {
                for (int a = 0; a < dots; a++) {
                    if (x.get(a) > f[i]) {
                        int n = 2 * f[i] - x.get(a);
                        if (duplicate(n, y.get(a))) {
                            x.remove(a);
                            y.remove(a);
                            a--;
                            dots--;
                        } else {
                            x.set(a, n);

                        }
                    }
                }
            }

            if (dir[i] == 'y') {
                for (int a = 0; a < dots; a++) {
                    if (y.get(a) > f[i]) {
                        int n = 2 * f[i] - y.get(a);
                        if (duplicate(x.get(a), n)) {
                            x.remove(a);
                            y.remove(a);
                            a--;
                            dots--;
                        } else {
                            y.set(a, n);
                        }
                    }
                }
            }

            if(i==0){
                sol=dots;
            }
        }
        
        System.out.println("Part 1: " +sol);
        
        System.out.println("");
        System.out.println("Part 2:");
        for(int a=0;a<6;a++){
            for(int b=0;b<40;b++){
                if(duplicate(b,a)){
                    System.out.print("X");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

    }

}
