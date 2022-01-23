
package lanternfish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Lanternfish {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/lanternfish/data.txt");
        List<String> text = Files.readAllLines(path);
        String[] st = text.get(0).split(",");

        long[] fish = new long[9];
        long change;
        
        for(int i=0;i<9;i++){
            fish[i]=0;
        }
        long count80=0;
        long count = st.length;
            for(int i=0;i<count;i++){
            fish[Integer.parseInt(st[i])]++;
        }
            
        for (int day = 0; day < 256 ; day++) {
            change=fish[0];
            for(int i=1;i<9;i++){
                fish[i-1]=fish[i];
            }
            fish[6]=fish[6]+change;
            fish[8]=change;
            count=count+change;
            
            if(day==79){
                count80=count;
            }
        }
        System.out.println("Part 1: "+count80);
        System.out.println("Part 2: "+count);
 
    }
    
}
