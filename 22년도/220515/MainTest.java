import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainTest {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] inputs = str.split("\", \"");

        System.out.println(solution(inputs));

    }

    public static String[] solution(String[] files) {
        String[] answer = {};

        File[] newFiles = Arrays.stream(files).map(file->new File(file)).toArray(File[]::new);


        Arrays.sort(newFiles, Comparator.comparing(o1->((File)o1).HEAD.toLowerCase())
                                            .thenComparing(o1->Integer.parseInt(((File)o1).NUMBER)));

        answer = Arrays.stream(newFiles).map(file->file.HEAD+file.NUMBER+file.TAIL).toArray(String[]::new);
        return answer;
    }
}

class FirstComparator implements Comparator<File>{

    @Override
    public int compare(File o1, File o2) {
        return o1.HEAD.toLowerCase().compareTo(o2.HEAD.toLowerCase());
    }

    @Override
    public Comparator<File> thenComparing(Comparator<? super File> other) {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Integer.parseInt(o1.NUMBER) - Integer.parseInt(o2.NUMBER);
            }
        };
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
        }
        if(position<str.length()){
            TAIL = str.substring(position);
        }else{
            TAIL = null;
        }

    }
}

