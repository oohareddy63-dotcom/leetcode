import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> freqm = new HashMap<>();
        for (String str : strs) {
            String freqstring = getfrequency(str);
            if (freqm.containsKey(freqstring)) {
                freqm.get(freqstring).add(str);
            } else {
                List<String> strlist = new ArrayList<>();
                strlist.add(str);
                freqm.put(freqstring, strlist);
            }
        }
        return new ArrayList<>(freqm.values());
    }
    public static String getfrequency(String str) {
        // Count letters
        int[] freq = new int[26];
        // Visit every character
        for (char ch : str.toCharArray()) {
        // Increase frequency
            freq[ch - 'a']++;
        }
        // Build unique key
        StringBuilder sb = new StringBuilder();
        // Visit all letters
        for (int i = 0; i < 26; i++) {
            // If character exists
            if (freq[i] != 0) {

                // Append character
                sb.append((char)(i + 'a'));

                // Append frequency
                sb.append(freq[i]);
            }
        }

        // Return frequency string
        return sb.toString();
    }
}