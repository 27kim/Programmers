import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class File_IO_2 {

    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println("input src : " + Arrays.toString(inSrc));

        try {
            while (input.available() > 0) {
//                input.read(temp);
//                output.write(temp);
                int len = input.read(temp);         //inputSrc 에서 읽은 값을 temp 에 넣는다. 리턴 값은 읽어온 개수
                output.write(temp, 0 , len);    //temp 의 0번째부터 len 까지 읽어온 값을 넣고 output 에 쓴다

                outSrc = output.toByteArray();      //output 의 값을 outSrc에 넣는다 (Arrays.copy 를 사용함)

                printArrays(len, temp, outSrc);
            }

        } catch (IOException e) {

        }
    }

    static void printArrays(int len ,byte[] temp, byte[] outSrc) {
        System.out.println("len src : " + len);
        System.out.println("temp src : " + Arrays.toString(temp));
        System.out.println("output src : " + Arrays.toString(outSrc));
        System.out.println("");
    }
}
