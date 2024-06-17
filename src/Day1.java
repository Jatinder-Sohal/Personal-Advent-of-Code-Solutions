import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Day1 {
    static String digitOne = "";
    static String digitTwo = "";

    public static void main(String[] args) throws IOException {
        Map<String, String> mapStringNum = new HashMap<>();
        mapStringNum.put("on", "one");
        mapStringNum.put("tw", "two");
        mapStringNum.put("th", "three");
        mapStringNum.put("fo", "four");
        mapStringNum.put("fi", "five");
        mapStringNum.put("si", "six");
        mapStringNum.put("se", "seven");
        mapStringNum.put("ei", "eight");
        mapStringNum.put("ni", "nine");

        Map<String, String> stringNumToInt = new HashMap<>();
        stringNumToInt.put("one","1");
        stringNumToInt.put("two","2");
        stringNumToInt.put("three","3");
        stringNumToInt.put("four","4");
        stringNumToInt.put("five","5");
        stringNumToInt.put("six","6");
        stringNumToInt.put("seven","7");
        stringNumToInt.put("eight","8");
        stringNumToInt.put("nine","9");

        File file = new File("input1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        char letter;
        int total = 0;
        while ((line = br.readLine()) != null){
            for(int i = 0; i < line.length(); i++){
                letter = line.charAt(i);
                if (Character.isDigit(letter)){
                    updateVariables(letter+"");
                }else if (line.substring(i).length() > 2){
                    String possibleNumber = line.substring(i, i+2);
                    String stringNum = mapStringNum.get(possibleNumber);
                    if (stringNum != null && line.substring(i).length() >= stringNum.length()){
                        possibleNumber = line.substring(i, i + stringNum.length());
                        if (possibleNumber.equals(stringNum)){
                            updateVariables(stringNumToInt.get(stringNum));
                        }
                    }
                }
            }
            if (digitTwo.equals(""))
                digitTwo = digitOne;
            total += Integer.parseInt(digitOne + digitTwo);
            digitOne = "";
            digitTwo = "";
        }
        System.out.println(total);
        br.close();
    }
    public static void updateVariables(String letter){
        if (digitOne.equals(""))
            digitOne = letter;
        else
            digitTwo = letter;
    }
}
