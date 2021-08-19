public class Checking {
    static boolean mathArab;
    static boolean mathRoman;
    public static void check(String str) throws InappropriateNumberException, NotMathAction {
        String num1 = "";
        String num2 = "";
        try {
            if (str.charAt(1) == '+' || str.charAt(1) == '-' || str.charAt(1) == '*' || str.charAt(1) == '/') {
                num1 = str.substring(0, 1);
                num2 = str.substring(2);

            } else if (str.charAt(2) == '+' || str.charAt(2) == '-' || str.charAt(2) == '*' || str.charAt(2) == '/') {
                num1 = str.substring(0, 2);
                num2 = str.substring(3);

            } else if (str.charAt(3) == '+' || str.charAt(3) == '-' || str.charAt(3) == '*' || str.charAt(3) == '/') {
                num1 = str.substring(0, 3);
                num2 = str.substring(4);

            } else if (str.charAt(4) == '+' || str.charAt(4) == '-' || str.charAt(4) == '*' || str.charAt(4) == '/') {
                num1 = str.substring(0, 4);
                num2 = str.substring(5);

            } else
                throw new NotMathAction("т.к. строка не является математической операцией или введен неподходящий цифры");
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("Строка не является математической операцией");
        }
        RomanNumeral[] romanNumerals = RomanNumeral.values();
        for (int i = 0; i < romanNumerals.length; i++) {
            for (int j = 0; j <= 10; j++) {
                if (num1.matches(romanNumerals[i].getKey()) && num2.matches(Integer.toString(j))) {
                    throw new InappropriateNumberException("т.к. используются одновременно разные системы счисления");
                } else if (num1.matches(Integer.toString(j)) && num2.matches(romanNumerals[i].getKey())) {
                    throw new InappropriateNumberException("т.к. используются одновременно разные системы счисления");
                }
            }
        }
        for (int i = 0; i < romanNumerals.length; i++) {
            for (int j = 0; j <= 10; j++) {
                if (!num1.matches(romanNumerals[i].getKey()) && num2.matches(Integer.toString(j))) {
                  mathArab=true;
                } else if (num1.matches(Integer.toString(j)) && !num2.matches(romanNumerals[i].getKey())) {
                  mathArab=true;
                }
            }
        }
        for (int i = 0; i < romanNumerals.length; i++) {
            for (int j = 0; j <= 10; j++) {
                if (num1.matches(romanNumerals[i].getKey()) && !num2.matches(Integer.toString(j))) {
                    mathRoman=true;
                } else if (!num1.matches(Integer.toString(j)) && num2.matches(romanNumerals[i].getKey())) {
                    mathRoman=true;
                }
            }
        }
        if(mathArab)MathAction.mathArab(str);
        if(mathRoman)MathAction.mathRoman(str);
    }
}
