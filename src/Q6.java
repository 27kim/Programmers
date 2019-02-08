public class Q6 {

    public static void main(String[] args) {

        Q6 q = new Q6();
//        System.out.println(q.solution(new String[]{"car", "bed", "sun"}, 1));
        System.out.println(q.solution("try1 hello world"));
    }

    public String solution(String s) {
        StringBuffer sb = new StringBuffer();

        String[] input = s.toLowerCase().split("");

        int cnt = 0;
        for (int i = 0; i < input.length; i++) {
            String toAdd = String.valueOf(input[i]);

            if (cnt % 2 == 0) {
                sb.append(toAdd.toUpperCase());
            } else {
                sb.append(toAdd.toLowerCase());
            }
            cnt++;

            if (toAdd.equals(" ")) {
                cnt = 0;
            }
        }
        return sb.toString();
    }
}