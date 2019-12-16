import library.contract.IComparator;
import library.impl.ComparatorImpl;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/*
Test Class this class is used to test the Tool
 */

public class TestExecution {

    public static void main(String[] args) throws IOException {
        //Take the path of both files, here we are taking the files from the file system
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the location of first file with file name\n e.g. C:\\Users\\himanshu\\Desktop\\file1.txt");
        String file1 = sc.next();
        System.out.println("Please enter the location of Second file with file name \n e.g. C:\\Users\\himanshu\\Desktop\\file1.txt");
        String file2 = sc.next();
        IComparator test = new ComparatorImpl();
        test.execute(new File(file1),new File(file2));




    }
}
