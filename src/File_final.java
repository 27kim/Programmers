import java.io.*;
import java.util.Arrays;

/**
 * 자바 입출력
 * 1. 바이트 기반 스트림
 *  File Input/OutPut Stream
 *  ByteArray Input/OutPut Stream
 *  Piped Input/OutPut Stream
 *  Audio Input/OutPut Stream
 * 1-1 바이트 보조 스트림
 *  Filter Input/OutPut Stream : 필터를 이용한 입출력 처리
 *  Buffered Input/OutPut Stream : 버퍼를 이용한 입출력 성능 향상
 *  Data Input/OutPut Stream : 기본형 단위로 데이터를 처리하는 기능
 * 2. 문자 기반 스트림 : 문자 입출력 할 때 사용함
 *  File Reader/Writer
 *  CharArray Reader/Writer
 *  Piped Reader/Writer
 *  String Reader/Writer
 * 2-1 문자기반 보조 스트림
 *  Buffered
 *  Filter
 * */
public class File_final {

    public static void main(String[] args) throws IOException {
        /**
         * ByteArray
         * */
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;

        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;

        bis = new ByteArrayInputStream(inSrc);
        bos = new ByteArrayOutputStream();

        //1. 일반적인 사용
        int data = 0;
        while((data = bis.read())!=-1){
            bos.write(data);
        }
        outSrc = bos.toByteArray();
        System.out.println("1.. =" + Arrays.toString(outSrc));
        outSrc = null;

        //2. temp 배열 및 available 사용
        byte[] temp = new byte[4];
        while (bis.available() > 0) {
            int cnt = bis.read(temp);
            bos.write(temp, 0, cnt);
        }
        outSrc = bos.toByteArray();

        System.out.println("2.. =" + Arrays.toString(outSrc));

        /**
         * FileInputStream / FileOutputStream
         * */
        System.out.println();
        System.out.println("FileInputStream / FileOutputStream");
        System.out.println();

        File file = new File("./src/Q1.java");
        File outFile = new File("./src/Q1.bak");

        FileInputStream fis = null;
        FileOutputStream fos = null;

        fis = new FileInputStream(file);
        fos = new FileOutputStream(outFile);
        int data2 = 0 ;
        while((data2 = fis.read()) != -1){
            System.out.print((char) data2);
            fos.write(data2);
        }

        /**
         * BufferedOutputStream
         * */

        FileOutputStream fileOutputStream = new FileOutputStream("1234.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 5);

        for(int i = '0' ; i <= '9' ; i++){
            bufferedOutputStream.write(i);
        }


        //fos로 close 하면 bufferedOutputStream 에 남아있는 것들은 출력이 안됨
//        fos.close();
        bufferedOutputStream.close();
    }
}
