import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Day4 {
    public static void main(String[] args) throws IOException {
        File file = new File("../inputs/input4.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        char letter;
        int number;
        int total = 0;
        HashSet<Integer> winningNumbers = new HashSet<>();

        int lines = 0;
        while ((line = br.readLine()) != null) {
            int multiplier = -1;
            winningNumbers.clear();
            boolean passedHalfway = false;

            for(int i = 8; i < line.length(); i++) {
                letter = line.charAt(i);
                if (letter == '|'){
                    passedHalfway = true;
                }else {
                    if (Character.isDigit(letter)){
                        number = Integer.parseInt(letter+"");
                        if (i+1 < line.length()) {
                            if (Character.isDigit(line.charAt(i+1))) {
                                number = Integer.parseInt(line.substring(i, i+2));
                                i++;
                            }
                        }
                        if (!passedHalfway){
                            winningNumbers.add(number);
                        }else {
                            if (winningNumbers.contains(number)) {
                                multiplier = multiplier+1;

                            }
                        }
                    }
                }
            }
            if (multiplier != -1){
                total = (int) (total + Math.pow(2, multiplier));
            }
            lines++;
        }
        System.out.println(total);
    }
}
