import java.io.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        File file = new File("../inputs/input2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        char letter;
        int number;
        int total = 0;
        int gameCount = 0;
        boolean addGame;
        while ((line = br.readLine()) != null) {
            addGame = true;
            gameCount++;
            line = line.substring(line.indexOf(":")+2);
            for(int i = 0; i < line.length(); i++){
                number = 0;
                letter = line.charAt(i);
                if (Character.isDigit(letter)) {
                    if (Character.isDigit(line.charAt(i+1))) {
                        number = Integer.parseInt(line.substring(i, i+2));
                        i++;
                    } else {
                        number = letter - '0';
                    }
                }
                if (line.substring(i).length() > 2){
                    switch (line.charAt(i+2)){
                        case 'r':
                            if (number > 12){
                                addGame = false;
                            }
                            break;
                        case 'g':
                            if (number > 13){
                                addGame = false;
                            }
                            break;
                        case 'b':
                            if (number > 14){
                                addGame = false;
                            }
                            break;
                    }
                }
            }
            if (addGame){
                total += gameCount;
            }
        }
        System.out.println(total);
    }
}
