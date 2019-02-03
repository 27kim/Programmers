import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q5 {

    public static void main(String[] args) {

        Q5 q = new Q5();

//        System.out.println(q.solution(new String[]{"car", "bed", "sun"}, 1));
        System.out.println(q.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));

    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int[] input = commands[i];

            List<Integer> input2 = new ArrayList(100);

            for (int j = input[0] - 1; j < input[1]; j++) {
                input2.add(array[j]);
            }

            Collections.sort(input2);

            answer[i] = input2.get(input[2] -1 );
        }

        return answer;
    }

}
