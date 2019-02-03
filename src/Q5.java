public class Q5 {

    public static void main(String[] args) {

        Q5 q = new Q5();

//        System.out.println(q.solution(new String[]{"car", "bed", "sun"}, 1));
        System.out.println(q.solution("a B z", 2));

    }

    public String solution(String s, int n) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char src = s.charAt(i);

            if ('a' <= src && src <= 'z') {
                src = (char) (src + n);
                if (src > 'z'){
                    src = (char) (src - 26);
                }
            }

            if ('A' <= src && src <= 'Z') {
                src = (char) (src + n);
                if (src > 'Z') src = (char) (src - 26);
            }
            sb.append(src);
        }

        return sb.toString();
    }

}
