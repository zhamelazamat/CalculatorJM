public class Parsing {
    static int num_1;
    static int num_2;
    static char operation;

    static public void parse(String str) throws InappropriateNumberException, NotMathAction {
        char sym_1;
        char sym_2;
        char sym_3;
        char sym_4;
        char sym_5;
        if (str.length() < 3) {
            throw new NotMathAction("т.к. строка не является математической операцией");
        } else if (str.length() == 3) {
            sym_1 = str.charAt(0);
            sym_2 = str.charAt(1);
            sym_3 = str.charAt(2);
            if (sym_1 == '+' || sym_1 == '-' || sym_1 == '*' || sym_1 == '/' ||
                    sym_3 == '+' || sym_3 == '-' || sym_3 == '*' || sym_3 == '/') {
                throw new NotMathAction("т.к. строка не является математической операцией");
            }
            num_1 = Integer.parseInt(String.valueOf(sym_1));
            num_2 = Integer.parseInt(String.valueOf(sym_3));
            operation = sym_2;
        } else if (str.length() == 4) {
            sym_1 = str.charAt(0);
            sym_2 = str.charAt(1);
            sym_3 = str.charAt(2);
            sym_4 = str.charAt(3);
            if (sym_1 == '+' || sym_1 == '-' || sym_1 == '*' || sym_1 == '/' ||
                    sym_4 == '+' || sym_4 == '-' || sym_4 == '*' || sym_4 == '/') {
                throw new NotMathAction("т.к. строка не является математической операцией");
            }
            if ((sym_2 == '+' || sym_2 == '-' || sym_2 == '*' || sym_2 == '/')
                    && sym_3 == '1' && sym_4 == '0') {
                num_1 = Integer.parseInt(String.valueOf(sym_1));
                operation = sym_2;
                num_2 = 10;
            } else if (sym_1 == '1' && sym_2 == '0' &&
                    (sym_3 == '+' || sym_3 == '-' || sym_3 == '*' || sym_3 == '/')) {
                num_1 = 10;
                operation = sym_3;
                num_2 = Integer.parseInt(String.valueOf(sym_4));
            } else
                throw new InappropriateNumberException("Введен неподходящий цифры");

        } else if (str.length() == 5) {
            sym_1 = str.charAt(0);
            sym_2 = str.charAt(1);
            sym_3 = str.charAt(2);
            sym_4 = str.charAt(3);
            sym_5 = str.charAt(4);
            if (sym_1 == '1' && sym_2 == '0' && sym_4 == '1' && sym_5 == '0' &&
                    (sym_3 == '+' || sym_3 == '-' || sym_3 == '*' || sym_3 == '/')) {
                num_1 = 10;
                num_2 = 10;
                operation = sym_3;
            } else throw new InappropriateNumberException("Введен неподходящий цифры");
        }  if (5 < str.length()) {
            throw new NotMathAction("формат математической операции не удовлетворяет заданию");
        }
    }
}