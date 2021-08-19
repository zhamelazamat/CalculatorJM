public class ParsingFromRoman {
    private int num_1;
    private int num_2;
    private char operation;


    public void parse(String str) throws InappropriateNumberException {
        String num1 = "";
        String num2 = "";
        if (str.charAt(1) == '+' || str.charAt(1) == '-' || str.charAt(1) == '*' || str.charAt(1) == '/') {
            num1 = str.substring(0, 1);
            num2 = str.substring(2);
            operation = str.charAt(1);
        } else if (str.charAt(2) == '+' || str.charAt(2) == '-' || str.charAt(2) == '*' || str.charAt(2) == '/') {
            num1 = str.substring(0, 2);
            num2 = str.substring(3);
            operation = str.charAt(2);
        } else if (str.charAt(3) == '+' || str.charAt(3) == '-' || str.charAt(3) == '*' || str.charAt(3) == '/') {
            num1 = str.substring(0, 3);
            num2 = str.substring(4);
            operation = str.charAt(3);
        } else if (str.charAt(4) == '+' || str.charAt(4) == '-' || str.charAt(4) == '*' || str.charAt(4) == '/') {
            num1 = str.substring(0, 4);
            num2 = str.substring(5);
            operation = str.charAt(4);
        }
        num_1 = RomanNumeral.RomanToDec(num1);
        num_2 = RomanNumeral.RomanToDec(num2);

    }

    public int getNum_1() {
        return num_1;
    }

    public int getNum_2() {
        return num_2;
    }

    public char getOperation() {
        return operation;
    }
}
