import java.util.Scanner;

public final class Main {
    private Main() { throw new IllegalStateException("Utility class"); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        int sum = 0;
        boolean shouldContinue = true;
        while (shouldContinue) {
            for (char c : input.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            if (sum < 10) {
                shouldContinue = false;
            } else {
                input = String.valueOf(sum);
                sum = 0;
            }
        }
        System.out.println(sum);
    }
}
