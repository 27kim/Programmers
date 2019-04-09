package Console;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Console_List {
    public static void main(String[] args) throws IOException {

        ArrayList<Grade> list = new ArrayList();

        System.out.println("파일 읽기 시작");
        //먼저 파일을 읽어서 list 에 저장한다
        try{
            BufferedReader br = new BufferedReader(new FileReader("./src/Console/sample.txt"));
            String str;

            while ((str = br.readLine()) != null){
                String [] words = str.split(" ");
                Grade g = new Grade(words[0], Integer.parseInt(words[1]),Integer.parseInt(words[2]),Integer.parseInt(words[3]));
                list.add(g);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("파일 읽기 완료. 데이터 수 :" + list.size());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String strInput = br.readLine();
            if(strInput.equals("print")){
                Collections.sort(list, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {

                        Grade a = (Grade) o1;
                        Grade b = (Grade) o2;

                        return a.strName.compareTo(b.strName);
                    }
                });
            }else if(strInput.equals("korean")){
                Collections.sort(list, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {

                        Grade a = (Grade) o1;
                        Grade b = (Grade) o2;

                        return Integer.compare(a.Korean, b.Korean);
                    }
                });
            }else if(strInput.equals("english")){
                Collections.sort(list, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {

                        Grade a = (Grade) o1;
                        Grade b = (Grade) o2;

                        return Integer.compare(a.English, b.English);
                    }
                });
            }else if(strInput.equals("math")){
                Collections.sort(list, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {

                        Grade a = (Grade) o1;
                        Grade b = (Grade) o2;

                        return Integer.compare(a.Math, b.Math);
                    }
                });
            }

            Iterator<Grade> it = list.iterator();

            while(it.hasNext()){
                Grade g = it.next();
                System.out.println(g.getStrName() + " " + g.getKorean() + " " + g.getEnglish() + " " + g.getMath());
            }

        }

    }
}

class Grade{
    String strName;
    int Korean;
    int English;
    int Math;

    Grade(String name, int k, int e, int m){
        strName = name;
        Korean = k;
        English = e;
        Math = m;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public int getKorean() {
        return Korean;
    }

    public void setKorean(int korean) {
        Korean = korean;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }
}