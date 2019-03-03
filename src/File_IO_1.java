import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class File_IO_1 {

    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length);   //읽어온 데이터를 배열 temp 에 담는다
        output.write(temp, 5, 5);       //temp[5] 부터 5개의 데이터를 write 한다

        outSrc = output.toByteArray();

        System.out.println("input src : " + Arrays.toString(inSrc));
        System.out.println("temp : " + Arrays.toString(temp));
        System.out.println("output src : " + Arrays.toString(outSrc));


    }
}
