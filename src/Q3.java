import java.util.*;

public class Q3 {

    public static void main(String[] args) {

        Q3 q = new Q3();

//        System.out.println(q.solution(new String[]{"car", "bed", "sun"}, 1));
        System.out.println(q.solution(new String[]{"abce", "abcd", "cdx"}, 2));

    }

    /**
     * n 번째 글자에 따라 배열을 정렬
     *
     * @param strings
     * @param n
     * @return
     */
    public String[] solution(String[] strings, int n) {

        String[] result = new String[strings.length];

//        TreeMap<String, String> map = new TreeMap();
//
//        for (int i = 0; i < strings.length; i++) {
//            map.put(strings[i].substring(n), strings[i]);
////            map.put(String.valueOf(strings[i].charAt(n)), strings[i]);
//        }

//        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
//
//        int idx = 0;
//
//        while (it.hasNext()) {
//            Map.Entry<String, String> key = it.next();
//            result[idx] = key.getValue();
//            idx++;
//        }

        List list = new ArrayList();

        for(int i = 0 ; i < strings.length; i++){
            list.add(strings[i].substring(n, n+1) + strings[i]);
        }

        Collections.sort(list);

        for(int i = 0 ; i < list.size(); i++){
            result[i] = list.get(i).toString().substring(1);
        }

        return result;
    }

}
