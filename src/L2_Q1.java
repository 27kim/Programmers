public class L2_Q1 {

    public static void main(String[] args) {

        L2_Q1 q = new L2_Q1();
//        System.out.println(q.solution(new String[]{"car", "bed", "sun"}, 1));
        System.out.println(q.solution("3people unFollowed me"));
    }

    public String solution(String s) {
        StringBuffer sb = new StringBuffer();

        String [] input = s.split(" ");

        if(s.substring(s.length() - 1).equals(" ")) {
            input[input.length-1] += " ";
    }

        for(int i = 0 ; i < input.length ; i++){
            String text = input[i];

            for(int j = 0 ; j < text.length() ; j++){
                String toAdd = String.valueOf(text.charAt(j));
                if(j == 0) {
                    sb.append(toAdd.toUpperCase());
                }else{
                    sb.append(toAdd.toLowerCase());
                }

                if(s.equals(" ")) sb.append(" ");
            }

            if(i < input.length -1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
