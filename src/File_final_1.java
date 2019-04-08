import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Arrays;
/**
 * Byte 기반 : FileInputStream / FileOutputStream
 * Text 기반 : FileReader / FileWriter
 * */

public class File_final_1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/Q1.java");

        //복사할 때 대상 디렉토리가 없으면 Exception 발생
        File file = new File("./COPY");
        if (!file.exists()) {
            file.mkdirs();
        }

        //경로 밑에 파일 목록 가져오기
        File dir = new File("./src");
        File [] files = dir.listFiles();

        for(File f : files){
            //특정 용량보다 크다면
            if(f.length() > 100){
                //FOS 만들어서 write 준비
                FileOutputStream os = new FileOutputStream("./COPY/" + f.getName());
                //FIS 만들어서 read 준비
                FileInputStream is = new FileInputStream(f);

                //byte 준비
                byte [] bytes = new byte[1000];
                //읽은 길이 준비
                int l = 0;
                //읽어서 bytes 에 답기
                while((l = is.read(bytes))!=-1){
                    os.write(bytes, 0, l);
                }
                os.close();
                is.close();
            }
        }

        FileOutputStream fos = new FileOutputStream("./COPY/Q1.java");

        byte[] b = new byte[512];
        int length = 0;
        while ((length = fis.read(b)) != -1) {
            fos.write(b, 0, length);
        }
        fos.close();
        fis.close();
    }
}
