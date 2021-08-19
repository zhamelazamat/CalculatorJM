public enum RomanNumeral {
    I("I", 1), II("II", 2), III("III", 3), IV("IV", 4), V("V", 5), VI("VI", 6),
    VII("VII", 7), VIII("VIII", 8), IX("IX", 9), X("X", 10);

    private int value;
    private String key;
    static int num;

    RomanNumeral(String key, int value) {
        this.value = value;
        this.key = key;
    }

    static public int RomanToDec(String str) throws InappropriateNumberException {
        RomanNumeral[] romanNumerals = RomanNumeral.values();
        if (!romanNumerals[0].getKey().equals(str) && !romanNumerals[1].getKey().equals(str)
                && !romanNumerals[2].getKey().equals(str) && !romanNumerals[3].getKey().equals(str)
                && !romanNumerals[4].getKey().equals(str) && !romanNumerals[5].getKey().equals(str)
                && !romanNumerals[6].getKey().equals(str) && !romanNumerals[7].getKey().equals(str)
                && !romanNumerals[8].getKey().equals(str) && !romanNumerals[9].getKey().equals(str)){
            throw new InappropriateNumberException("Введен неподходящий цифры");
        }
            for (int i = 0; i < romanNumerals.length; i++) {
                if (romanNumerals[i].getKey().equals(str)) {
                    num = romanNumerals[i].getValue();
                    break;
                }
            }
        return num;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }


}