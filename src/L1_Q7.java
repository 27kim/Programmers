import java.util.Arrays;

public class L1_Q7 {

    public static void main(String[] args) {
        L1_Q7 q = new L1_Q7();
        System.out.println(q.solution(10));
        System.out.println(q.solution(5));
    }

    public int solution(int n) {
        int answer = 0;

        for(int i = 2 ; i < n ; i++){
            boolean isPrime = true;
            for(int j = 2 ; j < i ; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                System.out.println("" + i +"는 소수 입니다");
                answer++;
            }
        }

        return answer;
    }
}
