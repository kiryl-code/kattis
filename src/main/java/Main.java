import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public final class Main {
    private static final String EXIT_CONDITION = "0 0";
    private Main() { throw new IllegalStateException("Utility class"); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        StringBuilder result = new StringBuilder();
        while (shouldContinue) {
            boolean isDone = false;
            String conditionInput = scanner.nextLine().trim();
            if (conditionInput.equals("0 0")) {
                shouldContinue = false;
                continue;
            }

            int people = Integer.parseInt(String.valueOf(conditionInput.split(" ")[0]));
            int connections = Integer.parseInt(String.valueOf(conditionInput.split(" ")[1]));

            Map<Integer, LinkedList<Integer>> connectionsMap = new HashMap<>();

            for (int i = 0; i < connections; i++) {
                String connection =  scanner.nextLine().trim();
                Integer person1 = Integer.valueOf(connection.split(" ")[0]);
                Integer person2 = Integer.valueOf(connection.split(" ")[1]);
                LinkedList<Integer> currentConnections;
                if (connectionsMap.containsKey(person1)) {
                    currentConnections = connectionsMap.get(person1);
                } else {
                    currentConnections = new LinkedList<>();
                }
                currentConnections.add(person2);
                connectionsMap.put(person1, currentConnections);
                LinkedList<Integer> currentConnections2;
                if (connectionsMap.containsKey(person2)) {
                    currentConnections2 = connectionsMap.get(person2);
                } else {
                    currentConnections2 = new LinkedList<>();
                }
                currentConnections2.add(person1);
                connectionsMap.put(person2, currentConnections2);
            }

            for (int key : connectionsMap.keySet()) {
                LinkedList<Integer> keyConnections = new LinkedList<>(connectionsMap.get(key));
                for (int connection : keyConnections) {
                    if (key > connection) { continue; }
                    connectionsMap.get(key).remove(Integer.valueOf(connection));
                    connectionsMap.get(connection).remove(Integer.valueOf(key));
                    if (!test(connectionsMap, people)) {
                        result.append("Yes\n");
                        isDone = true;
                    }
                    connectionsMap.get(key).add(connection);
                    connectionsMap.get(connection).add(key);
                    if (isDone) { break; }
                }
                if (isDone) { break; }
            }
            if (!isDone) {
                result.append("No\n");
            }
        }
        System.out.println(result.toString().trim());
    }

    private static boolean test(Map<Integer, LinkedList<Integer>> map, int people) {
        Set<Integer> reached = new HashSet<Integer>(people);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        reached.add(0);
        int counter = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            LinkedList<Integer> currentConnections = map.get(current);
            if (currentConnections != null) {
                for (int connection : currentConnections) {
                    if (!reached.contains(connection)) {
                        reached.add(connection);
                        counter++;
                        queue.add(connection);
                    }
                }
            }
        }
        return counter == people;
    }
}
