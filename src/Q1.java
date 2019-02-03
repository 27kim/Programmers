import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {

    public static void main(String[] args) {

        String[] participant = {"1", "2", "3", "4"};
        String[] completion = {"1", "2", "3"};

        Q1 q = new Q1();
        System.out.println(q.solution(participant, completion));

    }

    public String solution(String[] participant, String[] completion) {

//        List parts = new ArrayList(Arrays.asList(participant));
//        List coms = new ArrayList(Arrays.asList(completion));
//
//        String answer = "";
//        for (int i = 0; i < coms.size(); i++) {
//            if (parts.contains(coms.get(i))) {
//                parts.remove(coms.get(i));
//            }
//        }
//
//        return parts.get(0).toString();

        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0 ; i < completion.length ; i++){
          if(!participant[i].equals(completion[i])){
              return participant[i];
          }
        }

        return  participant[participant.length-1];
    }

}
