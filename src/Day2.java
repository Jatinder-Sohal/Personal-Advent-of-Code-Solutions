import java.io.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        File file = new File("../inputs/input2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        char letter;
        int number;
        int total = 0;

        int gameMax = 0;
        int blueMax = 0, greenMax = 0, redMax = 0;
        while ((line = br.readLine()) != null) {
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
                            if (number > redMax){
                                redMax = number;
                            }
                            break;
                        case 'g':
                            if (number > greenMax){
                                greenMax = number;
                            }
                            break;
                        case 'b':
                            if (number > blueMax){
                                blueMax = number;
                            }
                            break;
                    }
                }
            }
            gameMax = blueMax * greenMax * redMax;
            blueMax = 0; greenMax = 0; redMax = 0;
            total += gameMax;
        }
        System.out.println(total);
    }
}
