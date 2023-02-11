class Solution5 {
    public String longestPalindrome(String s) {

        int lt, rt;
        if(s.length() <= 1) return s;
        String palindrom = s.substring(0,1);

        for(lt=0; lt<s.length(); lt++){
            for(rt=s.length()-1; rt>lt; rt--){
                if(rt-lt+1 < palindrom.length()) continue;
                if(isPalindrom(s, lt, rt)) {

                    String newS = s.substring(lt, rt+1);
                    if(palindrom.length() < newS.length() ){
                        palindrom = newS;
                    }
                }
            }
        }

        return palindrom;
    }
    public boolean isPalindrom(String s, int lt, int rt){
        while(rt>lt){
            if(s.charAt(lt++) != s.charAt(rt--)) return false;
        }
        return true;
    }
}