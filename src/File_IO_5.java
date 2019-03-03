import java.io.*;

public class File_IO_5 {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("sample.dat");
            dos = new DataOutputStream(fos);

            //1번
            dos.writeInt(1);
            dos.writeInt(2);
            dos.writeInt(3);
            dos.writeInt(4);
            dos.writeInt(5);
            dos.writeInt(6);
            dos.writeInt(7);
            dos.writeInt(8);

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sum = 0;

        FileInputStream fis = null;

        DataInputStream dis = null;

        try {
            fis = new FileInputStream("sample.dat");

            dis = new DataInputStream(fis);


            while (true) {
                sum += dis.readInt();
            }


        } catch (EOFException e) {
            System.out.println("총합은 " + sum + "입니다.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //catch 에서 EOFException 으로 빠지기 때문에 finally 에서 dis 를 close 해야함
            //dis.close 는 try~catch 처리 또 해줘야함
           try {
                if(dis!=null) dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
