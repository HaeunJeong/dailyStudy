import java.util.Arrays;
import java.util.Comparator;
public class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        File[] newFiles = Arrays.stream(files).map(file->new File(file)).toArray(File[]::new);
        Arrays.sort(newFiles,
                Comparator.comparing(o1->((File)o1).HEAD.toLowerCase())
                        .thenComparing(o1->Integer.parseInt(((File)o1).NUMBER)));
        answer = Arrays.stream(newFiles).map(file->file.HEAD+file.NUMBER+file.TAIL).toArray(String[]::new);
        return answer;
    }
}

class File{
    String HEAD;
    String NUMBER;
    String TAIL;

    public File(String str){
        char[] chars = str.toCharArray();

        int position = 0;
        for(int i=0 ; i< chars.length; i++){
            if(chars[i] >='0' && chars[i]<='9'){
                HEAD = str.substring(0,i);
                position = i;
                break;
            }
        }
        for(int i = position ; i<chars.length; i++){
            if(chars[i] <'0' || chars[i]>'9'){
                NUMBER = str.substring(position, i);
                position = i;
                break;
            }
            if(i==position+5){
                NUMBER = str.substring(position, i-1);
                position = i-1;
            }
            if(i==chars.length-1){
                NUMBER = str.substring(position);
                position = i;
            }
        }
        if(position<str.length()){
            TAIL = str.substring(position);
        }else{
            TAIL = "";
        }

    }
}