class Solution {
    public int[] solution(String s) {

        int[] answer = new int[s.length()];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            int result = -1;
            for (int j = 0; j < i; j++) {
                if (charArray[j] == charArray[i]) {
                    result = j;
                }
            }
            if (result > -1) {
                answer[i] = i - result;
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }
}