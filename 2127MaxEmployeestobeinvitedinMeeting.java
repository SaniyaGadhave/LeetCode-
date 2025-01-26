import java.util.*;

class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        for (int f : favorite) {
            inDegree[f]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] depth = new int[n];
        Arrays.fill(depth, 1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int next = favorite[current];
            depth[next] = Math.max(depth[next], depth[current] + 1);
            inDegree[next]--;
            if (inDegree[next] == 0) {
                queue.add(next);
            }
        }

        int maxCycle = 0;
        int sumPairs = 0;

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) continue;
            int cycleLength = 0;
            int current = i;
            while (inDegree[current] != 0) {
                inDegree[current] = 0;
                cycleLength++;
                current = favorite[current];
            }
            if (cycleLength == 2) {
                sumPairs += depth[i] + depth[favorite[i]];
            } else {
                maxCycle = Math.max(maxCycle, cycleLength);
            }
        }

        return Math.max(maxCycle, sumPairs);
    }
}
