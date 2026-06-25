import java.util.Scanner;

public final class Main {
    private static final String vowels = "aeiou";
    private Main() { throw new IllegalStateException("Utility class"); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        int splitPos = input.length() - 1;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (vowels.contains(input.substring(i, i + 1).toLowerCase())) {
               splitPos = i + 1;
               break;
            }
        }
        String inputSub = input.substring(0, splitPos);
        System.out.println(inputSub + "ntry");
    }
}
