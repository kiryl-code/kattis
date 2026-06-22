import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public final class Main {
    private Main() { throw new IllegalStateException("Utility class"); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int villagers = scanner.nextInt();
        int evenings = scanner.nextInt();
        Map<Integer, Set<Integer>> villagerToSongsMap = new HashMap<>(villagers);
        for (int i = 1; i <= villagers; i++) {
            villagerToSongsMap.put(i, new HashSet<>());
        }
        int songs = 0;
        scanner.nextLine();
        for (int i = 0; i < evenings; i++) {
            String eveningData = scanner.nextLine();
            String[] participantsString = eveningData.split(" ");
            ArrayList<Integer> participants = Arrays.stream(participantsString).map(Integer::parseInt).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
            participants.removeFirst();
            if (participants.contains(1)) {
                songs++;
                for (int participant : participants) {
                    villagerToSongsMap.get(participant).add(songs);
                }
            } else {
                Set<Integer> songsKnownByGroup = new HashSet<>();
                for (int participant : participants) {
                    songsKnownByGroup.addAll(villagerToSongsMap.get(participant));
                }
                for (int participant : participants) {
                    villagerToSongsMap.get(participant).addAll(songsKnownByGroup);
                }
            }
        }
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append(1).append("\n");
        for (int villager : villagerToSongsMap.keySet()) {
            if (villager == 1) { continue; }
            if (villagerToSongsMap.get(villager).size() == songs) {
                outputBuilder.append(villager).append("\n");
            }
        }
        System.out.println(outputBuilder.toString().trim());
    }
}
