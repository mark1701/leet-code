class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap<>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            String abb = getAbbreviation(s);
            if(!map.containsKey(abb))
                map.put(abb,new HashSet<>());
            
            map.get(abb).add(s);
        }
    }
    
    public boolean isUnique(String word) {
        String abbreviation = getAbbreviation(word);
        if (!map.containsKey(abbreviation))
            return true;
        Set<String> matches = map.get(abbreviation);
        if(matches.contains(word) && matches.size() == 1)
            return true;
        else
            return false;
    }
    
    private String getAbbreviation(String s){
        if(s.length() <= 2) return s;
        int len = s.length() - 2;
        return s.charAt(0) + "" + len + s.charAt(s.length() - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */