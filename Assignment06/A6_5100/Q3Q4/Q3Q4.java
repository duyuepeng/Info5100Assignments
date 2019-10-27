package A6_5100.Q3Q4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3Q4 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c))
                return false;
            int n = map.get(c);
            n--;
            if (n <= 0)
                map.remove(c);
            else
                map.put(c, n);
        }
        return map.size() == 0;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer value : map.values()) {
            set.add(value);
        }
        return set.size() == map.size();
    }

    public static void main(String[] args) {
        Q3Q4 task = new Q3Q4();

        System.out.println("Test for Q3: ");
        System.out.println("Input: s = \"anagram\", t = \"nagaram\"\n" +
                "Output Expected: true");
        System.out.println("Output: " + task.isAnagram("anagram", "nagaram"));
        System.out.println("Input: s = \"rat\", t = \"car\"\n" +
                "Output Expected: false");
        System.out.println("Output: " + task.isAnagram("rat", "car"));

        System.out.println("Test for Q4: ");
        System.out.println("Input: arr = [1,2,2,1,1,3]\n" +
                "Output Expected: true");
        System.out.println("Output: " + task.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println("Input: arr = [1,2]\n" +
                "Output Expected: false");
        System.out.println("Output: " + task.uniqueOccurrences(new int[]{1, 2}));
        System.out.println("Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]\n" +
                "Output Expected: true");
        System.out.println("Output: " + task.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }
}
