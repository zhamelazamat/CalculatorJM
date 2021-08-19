import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InappropriateNumberException, NotMathAction {
        Scanner scanner = new Scanner(System.in);
        Checking.check(scanner.nextLine());
    }
}
