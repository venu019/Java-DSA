// Merge Overlapping Sub-intervals

// Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

// Example 1:
// Input:
//  intervals=[[1,3],[2,6],[8,10],[15,18]]
// Output:
//  [[1,6],[8,10],[15,18]]
// Explanation:
//  Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
//  intervals.

// Example 2:
// Input:
//  [[1,4],[4,5]]
// Output:
//  [[1,5]]
// Explanation:
//  Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].import java.util.*;

public class Main {

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] interval : arr) {
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));
            } else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), interval[1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = mergeOverlappingIntervals(arr);

        System.out.println("The merged intervals are: ");
        ans.forEach(interval -> System.out.println("[" + interval.get(0) + ", " + interval.get(1) + "]"));
    }
}
