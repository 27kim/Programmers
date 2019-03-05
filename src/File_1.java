import java.io.*;

public class File_1 {

    public static void main(String[] args) throws IOException {
        File file = new File("123.txt");
        String fileName = file.getName();

        System.out.println(fileName);
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getPath());
        System.out.println(System.getProperty("user.dir"));

//        File file2 = new File("/Users/27k/IdeaProjects/Programmers/123.txt");
//        File dir = new File("/Users/27k/IdeaProjects/Programmers");
//        File f= new File(dir, "123.txt");
//        System.out.println(f.getAbsolutePath());

        File dir = new File("/Users/27k/IdeaProjects/Programmers/test2");

        if(dir.exists()){
            System.out.println("디렉토리 존재함");
        }else{
            dir.mkdir();
            File ff = new File(dir, "test.txt");
            ff.createNewFile();
        }

        File[] files = dir.listFiles();
        int dirCnt = 0;
        int fileCnt = 0;
        for(File f : files){
            if(f.isDirectory()) {
                System.out.println("디렉토리명 : " +f.getName());
                dirCnt++;
            }else{
                System.out.println("파일명 : " + f.getName());
                fileCnt++;
            }
        }
        System.out.println("디렉토리 수 : " + dirCnt + " 파일 수 : " + fileCnt);
    }
}
