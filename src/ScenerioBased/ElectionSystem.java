package ScenerioBased;

import java.util.*;

public class ElectionSystem {
    public static void main(String[] args) {
        // Candidates and wards
        List<String> candidates = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> wards = Arrays.asList("Ward1", "Ward2", "Ward3");

        // Votes for candidates in each ward (Map<Ward, Map<Candidate, Votes>>)
        Map<String, Map<String, Integer>> votes = new HashMap<>();

        // Sample data
        votes.put("Ward1", Map.of("Alice", 50, "Bob", 30, "Charlie", 20, "David", 10));
        votes.put("Ward2", Map.of("Alice", 40, "Bob", 60, "Charlie", 50, "David", 100));
        votes.put("Ward3", Map.of("Alice", 70, "Bob", 80, "Charlie", 40, "David", 25));

        // Aggregate votes across all wards
        Map<String, Integer> totalVotes = new HashMap<>();
        for (String ward : votes.keySet()) {
            for (Map.Entry<String, Integer> entry : votes.get(ward).entrySet()) {
                totalVotes.put(entry.getKey(), totalVotes.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }

        // Find top 3 candidates
        List<Map.Entry<String, Integer>> sortedCandidates = new ArrayList<>(totalVotes.entrySet());
        sortedCandidates.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Top 3 Candidates:");
        for (int i = 0; i < Math.min(3, sortedCandidates.size()); i++) {
            System.out.println(sortedCandidates.get(i).getKey() + ": " + sortedCandidates.get(i).getValue() + " votes");
        }
    }
}
