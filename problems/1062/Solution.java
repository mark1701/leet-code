// this works in O(n^3)
class Solution {
    public int longestRepeatingSubstring(String s) {
       Set<String> set = new HashSet<>();
		for(int len = s.length(); len >= 1; len--){
			set.clear();
			for(int i = 0; i < s.length(); i++){
				if(i+len <= s.length()){
					String sub = s.substring(i,i+len);
					if(set.contains(sub))
						return sub.length();
					else
						set.add(sub);	
				}
				else
					break;
			}
		}
        return 0;
    }
}