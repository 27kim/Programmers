package Socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws IOException {
        SendToServer("File_1.java");
    }

    public static void SendToServer(String strFileName) throws IOException {
        //서버 연결하기 위한 socket 생성
        Socket socket = new Socket("127.0.0.1",27015);

        //서버에 파일 보내기 위한 OutputStream 을 서버에 연결된 소켓으로부터 부터 생성
        OutputStream outputStream = socket.getOutputStream();
        //outputStream 위한 buffer
        byte [] buffer = new byte[4096];
        //읽은 데이터의 길이
        int readLen;
        //보낼 대상 파일을 읽어오는 FileInputStream
        FileInputStream fis = new FileInputStream("./src/"+strFileName);
        while((readLen = fis.read(buffer)) != -1){
            outputStream.write(buffer, 0, readLen);
        }
        fis.close();

        socket.close();

        System.out.println(strFileName + " is sent.");
    }

}
