
class Solution {
    public String solution(String new_id) {

        String step3  = new_id
                .toLowerCase()
                .replaceAll("[^-_.a-z0-9]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "")
                .replaceAll("[.]{2,}", ".");
        if(step3.equals("")){
            step3 = "a";
        }
        if(step3.length()>=16){
            step3 = step3.substring(0,15);
            step3 = step3.replaceAll("^[.]|[.]$", "");
        }

        if(step3.length()<=2){
            String add = step3.substring(step3.length()-1);
            while(step3.length()<3) {
                step3 = step3.concat(add);
            }
        }

        System.out.println(step3);
        return step3;
    }
}