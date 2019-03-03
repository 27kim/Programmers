import java.util.*;

public class Collection_1 {
    public static void main(String[] args) {
        final int LIMIT = 10;
        String source = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String [] strArr = source.split("");

        //배열을 List로 변경
        List list = Arrays.asList(strArr);
        //또는 가변적인 List로 만들고 싶다면
        list = new ArrayList(Arrays.asList(strArr));
        //배열의 정렬
        Arrays.sort(strArr);


        List <String> list2 = list.subList(0,10);

        String [] returnArr = list2.toArray(new String [list2.size()]);


        Map map = new HashMap();

        Iterator it = map.keySet().iterator();

    }
}
