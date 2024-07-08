import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Day3 {
    static Map<Integer, HashSet<Integer>> symbolPlacement = new HashMap<>();

    public static void main(String[] args) throws IOException {
        File file = new File("../inputs/input3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int count = 0;
        char letter;
        while ((line = br.readLine()) != null) {
            symbolPlacement.put(count, new HashSet<Integer>());
            for (int i = 0; i < line.length(); i++) {
                letter = line.charAt(i);
                if (!Character.isDigit(letter) && !Character.isLetter(letter) && !Character.isWhitespace(letter) && letter != '.'){
                    symbolPlacement.get(count).add(i);
                }
            }
            count++;
        }

        br = new BufferedReader(new FileReader(file));
        int lineCount = 0;
        int total = 0;
        boolean symbolExists = false;
        StringBuilder number = new StringBuilder();
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                letter = line.charAt(i);
                if (Character.isDigit(letter)) {
                    number = new StringBuilder("" + letter);
                    if (lineCount == 0){
                        if (symbolPlacement.get(lineCount+1).contains(i)){
                            symbolExists = true;
                        }
                        if (i != 0){
                            if (symbolPlacement.get(lineCount+1).contains(i-1) || symbolPlacement.get(lineCount).contains(i-1)){
                                symbolExists = true;
                            }
                        }
                        if (symbolPlacement.get(lineCount+1).contains(i)){
                            symbolExists = true;
                        }
                        for (i = i+1; i<line.length() && Character.isDigit(line.charAt(i)); i++){
                            number.append(line.charAt(i));
                            if (symbolPlacement.get(lineCount+1).contains(i)){
                                symbolExists = true;
                            }
                        }
                        if (i != line.length()-1){
                            if (symbolPlacement.get(lineCount+1).contains(i) || symbolPlacement.get(lineCount).contains(i)){
                                symbolExists = true;
                            }
                        }
                    }else if (lineCount == count-1){
                        if (symbolPlacement.get(lineCount-1).contains(i)){
                            symbolExists = true;
                        }
                        if (i != 0){
                            if (symbolPlacement.get(lineCount-1).contains(i-1) || symbolPlacement.get(lineCount).contains(i-1)){
                                symbolExists = true;
                            }
                        }
                        if (symbolPlacement.get(lineCount-1).contains(i)){
                            symbolExists = true;
                        }
                        for (i = i+1; i<line.length() && Character.isDigit(line.charAt(i)); i++){
                            number.append(line.charAt(i));
                            if (symbolPlacement.get(lineCount-1).contains(i)){
                                symbolExists = true;
                            }
                        }
                        if (i != line.length()-1){
                            if (symbolPlacement.get(lineCount-1).contains(i) || symbolPlacement.get(lineCount).contains(i)){
                                symbolExists = true;
                            }
                        }
                    }else {
                        if (symbolPlacement.get(lineCount).contains(i-1) || checkVertically(lineCount, i-1) || checkVertically(lineCount, i)){
                            symbolExists = true;
                        }
                        if (i != 0){
                            if (checkVertically(lineCount, i-1) || symbolPlacement.get(lineCount).contains(i-1)){
                                symbolExists = true;
                            }
                        }
                        if (symbolPlacement.get(lineCount+1).contains(i) || symbolPlacement.get(lineCount-1).contains(i)){
                            symbolExists = true;
                        }
                        for (i = i+1; i<line.length() && Character.isDigit(line.charAt(i)); i++){
                            number.append(line.charAt(i));
                            if (checkVertically(lineCount, i)){
                                symbolExists = true;
                            }
                        }
                        if (i != line.length()-1){
                            if (checkVertically(lineCount, i) || symbolPlacement.get(lineCount).contains(i)){
                                symbolExists = true;
                            }
                        }
                    }
                }
                if (symbolExists){
                    if (!number.isEmpty()){
                        total += Integer.parseInt(number.toString());
                        number = new StringBuilder();
                        symbolExists = false;
                    }

                }
            }
            lineCount++;
        }
        System.out.println(total);

    }
    public static boolean checkVertically(int lineCount, int position){
        return symbolPlacement.get(lineCount-1).contains(position) || symbolPlacement.get(lineCount+1).contains(position);
    }
}