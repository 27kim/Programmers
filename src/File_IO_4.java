import java.io.*;

public class File_IO_4 {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("sample.dat");
            dos = new DataOutputStream(fos);

            //1번
            dos.writeInt(100);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);
            //2번
            dos.writeInt(200);
            dos.writeFloat(40.0f);
            dos.writeBoolean(false);

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("sample.dat");

            DataInputStream dis = new DataInputStream(fis);

            //읽을 때도 순서에 맞춰서
            //1번
            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readBoolean());
            //2678ㄴ      34
            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readBoolean());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
