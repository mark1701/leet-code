class Solution {
   public int longestSubstring(String s, int k) {
        return findLongestRecursive(s, k);
    }


    private int findLongestRecursive(String s, int k) {
        if (s.length() < k) return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1); //map to store count
        }

        /* Sort the map in descending order of value, to check most occurring violating character first */
        Comparator<Map.Entry<Character, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
        List<Map.Entry<Character, Integer>> sorted = new ArrayList<>(map.entrySet());
        sorted.sort(comparator); 

        for (Map.Entry<Character, Integer> e : sorted) {
            if (e.getValue() < k) {
                int index = s.indexOf(e.getKey()); //index of violating character
                return Math.max(
                        findLongestRecursive(s.substring(0, index), k), //left part of substring
                        findLongestRecursive(s.substring(index+1), k)); //right part of substring

            }
        }
        return s.length();
    }
}