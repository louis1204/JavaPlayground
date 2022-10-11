import java.util.*;

public class HashMapSolution {
    static HashMap<Map.Entry<Integer, Integer>, Boolean> memo = new HashMap<>();

    public static int countSubstrings(String s) {
        // Initialize the memo with the base case of each single letter being a pal
        // Then start increasing the size until we reach s.length, and check if substring
        // by comparing the end chars and the inner string if it's a substring
        int res = 0;
        // Initialize
        for (int i = 0; i < s.length(); i++) {
            memo.put(Map.entry(i, i), true);
            res++;
        }
        // Go through the sizes
        for (int size = 1; size < s.length(); size++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + size >= s.length()) {
                    break;
                }
                int end = i + size;
                // System.out.println(i + " " + end);
                boolean isPal = s.charAt(i) == s.charAt(end) && (i == end - 1 || memo.get(Map.entry(i + 1, end - 1)));
                memo.put(Map.entry(i, end), isPal);
                if (isPal) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws InterruptedException {
        String s = "dbabcccbcdbbbadabbdabaabcbbabaacdadcdbbbbdddbcbbbcbcabacacdaadaadcdccbacdaadadcbaacabbddabdadcabbccadacadaaacbbddaaababacaabbbacaccbcbbabddbbcccaaacbcdcabcbacdbddcdcadaaadcbccbbcabbcbdaadcbddaacacdadacbbdabcdcdadccaccdbdddddcabdbcdbaadacadadbabdcdbbadaacdbadcdabdbbcabbbdaacaaaaadcaabaaaadabaaddcaabdddcbcadcbdbbdbcbcdbadcadacbbcdccddaccccacbacaacbbdadadcacabdabadbbcdbcaaccdbdcabcadbacbccddbabbdacbcbbcbcabcacdaacccaadcdbdccabcaaacaddadcabacdccaaaddaaadbccdbbcccdddababcdbcddcbdddbbbdaadaccbcaabbcbdbadbabbacdbbbdaaccdcabddacadabcccacdabacbcdbcbdabddacacbdbcaacacaabbaaccddabaadbbaabaddbcacbacdbbbacdccabbcdbbbdbdbbcacabdddbdbaaabbcdcbabcbbbccdcdcdcaaddadccbabbacaddcaddcadcdccaccacabbaababdbbcbdcdccccccdadbdbdcdbdadcdcacdaabaacabaacdacdbaaccadbcddbdccabbcabcadcbdadbcdadbbbccacbcbbcaaaabdacbadacaadcadaacdacddcbbabdacacaabccdaccbbcbbcbcaacdabdcbcdbccdbcbcbddaacdacaaaddcaddcadccacbaddbbbccbbbcbbcbadcabbccbbaadaacacabddbdbddcadbdaaccadbcccabdcdbadbbacbcbbcdcabcddcddddabddbdabdcabdbdbbbcdbcdabbdcb";
        System.out.println(countSubstrings(s));
        Thread.sleep(60000);    
    }
}
