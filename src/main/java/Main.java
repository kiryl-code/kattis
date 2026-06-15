import java.util.Scanner;

public final class Main {
    private Main() { throw new IllegalStateException("Utility class"); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstCode = scanner.nextLine();
        String secondCode = scanner.nextLine();

        // in a real world solution should check if input is of type int

        if (firstCode.equalsIgnoreCase(secondCode)) { System.out.println(1); return; }

        int maxCombos = 16;
        for (int i = 0; i < 4; i ++) {
            char firstChar = firstCode.charAt(i);
            char secondChar = secondCode.charAt(i);
            if (firstChar == secondChar) {
                maxCombos = maxCombos / 2;
            }
        }
        System.out.println(maxCombos);
    }
}
