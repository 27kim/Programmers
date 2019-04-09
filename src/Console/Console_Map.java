package Console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Console_Map {
    public static void main(String[] args) throws IOException {
        Map<String, Effort> map = new HashMap();
        BufferedReader br = new BufferedReader(new FileReader(""));

        String line;

        while ((line = br.readLine()) != null){
            String [] words = line.split(" ");
            String key = words[1];

            if(!map.containsKey(key)){
                Effort ef = new Effort(words[2], Double.parseDouble(words[3]), Double.parseDouble(words[4]), Double.parseDouble(words[5]));
                map.put(key, ef);
            }else{
                map.get(key).AddA(Double.parseDouble(words[3]));
                map.get(key).AddB(Double.parseDouble(words[4]));
                map.get(key).AddC(Double.parseDouble(words[5]));
            }
        }
    }
}

class Effort {
    private String strName;
    double dA;
    double dB;
    double dC;

    Effort(String str, double a, double b, double c) {
        strName = str;
        dA = a;
        dB = b;
        dC = c;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public double getdA() {
        return dA;
    }

    public void setdA(double dA) {
        this.dA = dA;
    }

    public double getdB() {
        return dB;
    }

    public void setdB(double dB) {
        this.dB = dB;
    }

    public double getdC() {
        return dC;
    }

    public void setdC(double dC) {
        this.dC = dC;
    }

    void AddA(double d){
        dA += d;
    }
    void AddB(double d){
        dB += d;
    }
    void AddC(double d){
        dC += d;
    }
}