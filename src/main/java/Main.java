import java.util.Scanner;

public final class Main {
    private Main() { throw new IllegalStateException("Utility class"); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String machineCode = scanner.nextLine().trim();
        int additionalNOPs = 0;
        for (int i = 0; i < machineCode.length(); i++) {
            char c = machineCode.charAt(i);
            if (Character.isUpperCase(c) && (i + additionalNOPs) % 4 != 0) {
                    additionalNOPs += 4 - (i + additionalNOPs) % 4;
            }
        }
        System.out.println(additionalNOPs);
    }
}
