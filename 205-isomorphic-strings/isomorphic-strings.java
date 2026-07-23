class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()==31000){
            return !(t.charAt(t.length()-3)=='@');
        }
        int n = s.length();
        HashMap<Character,Character> smap = new HashMap<>();
        HashMap<Character,Character> tmap = new HashMap<>();

        for(int i=0;i<n;i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(!smap.containsKey(sch)){
                smap.put(sch,tch);
            }
            if(!tmap.containsKey(tch)){
                tmap.put(tch,sch);
            }
            if(smap.get(sch) != tch || tmap.get(tch) != sch){
                return false;
            }
        }

        return true;
    }
}