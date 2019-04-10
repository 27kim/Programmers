package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ThreadClass tc = new ThreadClass();
        Thread t = new Thread(tc);
        t.start();

        //console에서 사용자 입력하기 위한 부분
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);

        //		// console에서 사용자 입력하기 위한 부분
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while (true) {
            str = br.readLine();

            System.out.println("입력 받은 값 : " + str);
            if (str.equals("QUIT")) {
                System.out.println("종료 합니당");
                tc.listener.close();
                t.join();
                break;
            }
        }
    }
}

/**
 * ServerSocket 이 돌아가는 Runnable interface
 */
class ThreadClass implements Runnable {
    public ServerSocket listener;

    @Override
    public void run() {
        final int BUF_SIZE = 4096;
        int recvLen;
        //저장 파일 이름
        String fileName = "File_IO.java";
        byte[] buffer = new byte[BUF_SIZE];

        try {
            //listener 생성
            listener = new ServerSocket(27015);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        try {
            while (true) {
                //client 로 부터 요청오면 accept 해서 socket 생성
                Socket s = listener.accept();

                //client 소켓에서 오는 stream 받는 부분
                InputStream input = s.getInputStream();
                int cnt = 0;

                //저장하기 위한 경로 확인 & 생성
                File dir = new File("./ServerFiles/");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                //FileOutputStream 생성 후 위치 지정
                FileOutputStream fos = new FileOutputStream("./ServerFiles/" + fileName, true);
                while ((recvLen = input.read(buffer, 0, BUF_SIZE)) != -1) {
                    //fos에 쓰기
                    fos.write(buffer, cnt, recvLen);
                }
                //fos 닫기
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //listener 해제
                listener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
