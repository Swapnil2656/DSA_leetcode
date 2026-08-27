class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;

        int[] pFreq = new int[26];
        int[] WindowFreq = new int[26];

        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            pFreq[c - 'a']++;
        }
        int k = p.length();
        for(int i = 0; i < k; i++){
            WindowFreq[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pFreq, WindowFreq)){
            ans.add(0);
        }
        for(int i = k;i < s.length();i++){
            WindowFreq[s.charAt(i) - 'a']++;
            WindowFreq[s.charAt(i-k) - 'a']--;

            if(Arrays.equals(pFreq, WindowFreq)){
                ans.add(i-k+1);
            }
        }
        return ans;

    }
}