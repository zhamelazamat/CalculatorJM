public class MathAction {
    static int result;

    static public void mathArab(String str) throws NotMathAction, InappropriateNumberException {
        Parsing.
                parse(str);
        switch (Parsing.operation) {
            case '+':
                result = Parsing.num_1 + Parsing.num_2;
                break;
            case '-':
                result = Parsing.num_1 -Parsing.num_2;
                break;
            case '*':
                result = Parsing.num_1 * Parsing.num_2;
                break;
            case '/':
                result = Parsing.num_1 / Parsing.num_2;
                break;

        }
        System.out.println(result);
    }

    public static void mathRoman(String str) throws InappropriateNumberException {
        ParsingFromRoman roman = new ParsingFromRoman();
        roman.parse(str);
        switch (roman.getOperation()) {
            case '+':
                result = roman.getNum_1() + roman.getNum_2();
                break;
            case '-':
                int num =  roman.getNum_1() - roman.getNum_2();
                if (num > 0) {
                    result = num;
                } else throw new InappropriateNumberException("т.к. в римской системе нет чисел который меньше единицы");
                break;
            case '*':
                result = roman.getNum_1() * roman.getNum_2();
                break;
            case '/':
                result = roman.getNum_1() / roman.getNum_2();
                break;

        }
        System.out.println(convert(result));
    }

    public static String romanDigit(int n, String one, String five, String ten) {

        if (n >= 1) {
            if (n == 1) {
                return one;
            } else if (n == 2) {
                return one + one;
            } else if (n == 3) {
                return one + one + one;
            } else if (n == 4) {
                return one + five;
            } else if (n == 5) {
                return five;
            } else if (n == 6) {
                return five + one;
            } else if (n == 7) {
                return five + one + one;
            } else if (n == 8) {
                return five + one + one + one;
            } else if (n == 9) {
                return one + ten;
            }

        }
        return "";
    }

    public static String convert(int number) {
        if (number < 0 || number > 3999) {
            return "This number cannot be converted";
        }

        String romanOnes = romanDigit(number % 10, "I", "V", "X");
        number /= 10;
        String romanTens = romanDigit(number % 10, "X", "L", "C");
        number /= 10;
        String romanHundreds = romanDigit(number % 10, "C", "D", "M");
        number /= 10;
        String romanThousands = romanDigit(number % 10, "M", "", "");

        return romanThousands + romanHundreds + romanTens + romanOnes;

    }
}

