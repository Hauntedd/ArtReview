package main.java.learning;
/*
找出两个文件中重复的url
* */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class sameUrl {
    public static void main(String[] args) throws IOException {
        FileReader f1 = new FileReader("文件一.txt");
        BufferedReader bf1 = new BufferedReader(f1);
        FileReader f2 = new FileReader("文件二.txt");
        BufferedReader bf2 = new BufferedReader(f2);
        Set urls1 = new HashSet();
        Set urls2 = new HashSet();
        String line = null;
        while ((line = bf1.readLine())!=null){
            urls1.add(line);
        }
        while ((line = bf2.readLine())!=null){
            if(urls1.contains(line))
                System.out.println(line);
        }
        bf1.close();
        bf2.close();
    }
}
