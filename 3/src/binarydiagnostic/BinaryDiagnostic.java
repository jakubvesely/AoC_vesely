//Day 3: Binary diagnostic

package binarydiagnostic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BinaryDiagnostic {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/binarydiagnostic/data.txt");
        List<String> text = Files.readAllLines(path);
        int n = text.size();
        int m = text.get(0).length();
        int gamma[] = new int[m];
        int epsilon[] = new int[m];
        int gam = 0;
        int eps = 0;

        //Part 1
        for (int i = 0; i < m; i++) {

            int zeros = 0;
            int ones = 0;

            for (int f = 0; f < n; f++) {
                String st = text.get(f);
                if (st.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            if (zeros > ones) {
                gamma[i] = 0;
                epsilon[i] = 1;
            } else {
                gamma[i] = 1;
                epsilon[i] = 0;
            }
        }

        int pw = 1;
        for (int i = (m - 1); i >= 0; i--) {
            gam = gam + gamma[i] * pw;
            pw = pw * 2;
        }

        pw = 1;
        for (int i = (m - 1); i >= 0; i--) {
            eps = eps + epsilon[i] * pw;
            pw = pw * 2;
        }
        int sol1 = eps * gam;

        //Part 2  
        List<String> ogrList = new ArrayList<>(text);
        List<String> csrList = new ArrayList<>(text);
        int z = n;
        int cn = 0;
        int ix = 0;
        int pr = 0;
        do {
            int zeros = 0;
            int ones = 0;
            for (int f = 0; f < z; f++) {
                String st = ogrList.get(f);
                if (st.charAt(ix) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            if (ones >= zeros) {
                pr = 1;
            } else {
                pr = 0;
            }

            for (int i = 0; i < z; i++) {
                int bin = Character.getNumericValue(ogrList.get(i).charAt(ix));
                if (bin == pr) {
                    ogrList.set(cn, ogrList.get(i));
                    cn++;
                }

            }
            ix++;
            z = cn;
            cn = 0;
        } while (ix < m && z > 1);
        pw = 1;
        int ogr = 0;
        for (int i = (m - 1); i >= 0; i--) {
            int ch = ogrList.get(0).charAt(i);
            ogr = ogr + Character.getNumericValue(ch) * pw;
            pw = pw * 2;
        }

        z = n;
        cn = 0;
        ix = 0;
        pr = 0;

        do {
            int zeros = 0;
            int ones = 0;
            for (int f = 0; f < z; f++) {
                String st = csrList.get(f);
                if (st.charAt(ix) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            if (ones >= zeros) {
                pr = 1;
            } else {
                pr = 0;
            }

            for (int i = 0; i < z; i++) {
                int bin = Character.getNumericValue(csrList.get(i).charAt(ix));
                if (bin != pr) {
                    csrList.set(cn, csrList.get(i));
                    cn++;
                }

            }
            ix++;
            z = cn;
            cn = 0;
        } while (ix < m && z > 1);

        pw = 1;
        int csr = 0;
        for (int i = (m - 1); i >= 0; i--) {
            int ch = csrList.get(0).charAt(i);
            csr = csr + Character.getNumericValue(ch) * pw;
            pw = pw * 2;
        }

        int sol2 = ogr * csr;
        System.out.println("Part 1: " + sol1);
        System.out.println("Part 2: " + sol2);
    }

}
