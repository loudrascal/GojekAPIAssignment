import java.io.File;
import java.util.Scanner;

/*
Test Class this class is used to test the Tool
 */

public class TestExecution {

    public static void main(String[] args) {
        //Take the path of both files, here we are taking the files from the file system
        Scanner sc = new Scanner(System.in);
       /* System.out.println("Please enter the location of first file with file name\n e.g. C:\\Users\\himanshu\\Desktop\\file1.txt");
        String file1 = sc.next();
        System.out.println("Please enter the location of Second file with file name \n e.g. C:\\Users\\himanshu\\Desktop\\file1.txt");
        String file2 = sc.next();*/
       String file1 = "/home/hi.agrawal/file1.txt";
       String file2 = "/home/hi.agrawal/file2.txt";
        File first = new File(file1);
        File second = new File(file2);
        Execution execute = new Execution();
        execute.testAPIs(first,second);







    }
}
