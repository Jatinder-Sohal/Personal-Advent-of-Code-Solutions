import java.io.*;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws IOException {
        File file = new File("input1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        char letter;
        String digitOne = "";
        String digitTwo = "";
        int total = 0;
        while ((st = br.readLine()) != null){
            for(int i = 0; i < st.length(); i++){
                letter = st.charAt(i);
                if (Character.isDigit(letter)){
                    if (digitOne == "")
                        digitOne = letter+"";
                    else
                        digitTwo = letter+"";
                }
            }
            if (digitTwo.equals(""))
                digitTwo = digitOne;
            total += Integer.parseInt(digitOne + digitTwo);
            digitOne = "";
            digitTwo = "";
        }
        System.out.println(total);
    }
}
