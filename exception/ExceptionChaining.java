package exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class MyException extends Exception{
    MyException(){
        System.out.println("File Not Found");
    }
}
public class ExceptionChaining {
    public static void main(String[] args) throws MyException {
        try{
            BufferedReader reader=new BufferedReader(new FileReader("demo.txt"));
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        }catch (IOException e){
            throw new  MyException();
        }
    }
}
