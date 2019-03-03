import java.io.*;
import java.util.Arrays;

public class File_IO_3 {

    public static void main(String[] args) {


        try {
            FileOutputStream fos = new FileOutputStream("123.txt");
            //BufferedOutputStream 의 버퍼 크기를 5로 한다.
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);

            for(int i = '1' ; i < '9'; i++){
                bos.write(i);
            }

            //bufferedoutputstream 은 버퍼가 가득 찾을 때만 출력소스에 출력을 하기 때문에
            //마지막 출력 부분이 출력소스에 쓰이지 못하고 bos 에 남아있는 채로 종료 됨
            //bos.close 를 하면 fos 의 close 를 호출하기 때문에 별도로 호출하지 않아도
            bos.close();

        } catch (IOException e) {

        }

        try {
            //FileInputStream 사용
            System.out.println("FileInputStream 사용");
            FileInputStream fis = new FileInputStream("123.txt");
            int data = 0;
            while((data = fis.read()) != -1){
                char c = (char)data;
                System.out.print(c);
            }

            //FileReader & BufferedReader 사용
            System.out.println("");
            System.out.println("FileReader & BufferedReader 사용");
            FileReader fr  = new FileReader("123.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) !=null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
