import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Execution {

    public void testAPIs(File file1, File file2){
        BufferedReader first = null,second=null;
        try {
             first = new BufferedReader(new FileReader(file1));
             second = new BufferedReader(new FileReader(file2));

            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
             while(true){
                 String firstapi = first.readLine();
                 String secondapi = second.readLine();
                 if(firstapi==null && secondapi==null)
                    break;
                 else if((firstapi==null && secondapi!=null) ||(firstapi!=null && secondapi==null) ){
                    throw new Exception("Both files does not have same number of files\n Exiting .....");
                 }
                 RequestSpecification request1 = CreateRequestObject.createRequest(firstapi);
                 RequestSpecification request2 = CreateRequestObject.createRequest(secondapi);

                 System.out.println(firstapi +" ----"+secondapi);


             }

        }catch (FileNotFoundException e){
            System.out.println("Files not found at target location Please provide correct inputs\n"+e.getMessage()+"\n Exiting the Program");
            System.exit(0);
        }catch (IOException e){
            System.out.println("Issue in Files, please check the files you provided");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
