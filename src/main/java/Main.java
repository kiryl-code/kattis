import java.util.Scanner;

public final class Main {
    private Main() { throw new IllegalStateException("Utility class"); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String meta = scanner.nextLine().trim();
        String[] metaArray = meta.split(" ");
        int allowedUptime = Integer.parseInt(metaArray[1]);
        String tasks = scanner.nextLine().trim();
        String[] tasksList = tasks.split(" ");
        int timeTotal = 0;
        int tasksCount = 0;
        for (String s : tasksList) {
            int taskTime = Integer.parseInt(s);
            if (timeTotal + taskTime <= allowedUptime) {
                timeTotal += taskTime;
                tasksCount++;
            } else {
                break;
            }
        }
        System.out.println(tasksCount);
    }
}
