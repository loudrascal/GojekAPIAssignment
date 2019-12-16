package library;

import library.exception.InvalidFileInputException;
import library.runnable.ExecutorRunnable;
import library.utils.AppUtils;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
Main class to execute the files
 */
public class ProgramExecutor {

    public void execute(File file1, File file2) {

        //Here the thread pool size is defined as 20 due to network limitations. it can be changed
        //to more threads, if the network permits. in my testing i found 20 threads to be reliable
        // for a decent connection.
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
        BufferedReader first = null, second = null;
        try {
            first = new BufferedReader(new FileReader(file1));
            second = new BufferedReader(new FileReader(file2));
            while (true) {
                String url1 = first.readLine();
                String url2 = second.readLine();
                if (AppUtils.isEmptyString(url1) && AppUtils.isEmptyString(url2))
                    break;
                else if ((AppUtils.isEmptyString(url1) && !AppUtils.isEmptyString(url2))
                        || (AppUtils.isEmptyString(url2) && !AppUtils.isEmptyString(url1))) {
                    throw new InvalidFileInputException("Both files does not have same number of requests.");
                }
                ExecutorRunnable executorRunnable = new ExecutorRunnable(url1,url2);
                executor.execute(executorRunnable);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Files not found at target location Please provide correct inputs\n" + e.getMessage() + "\n Exiting the Program");
        } catch (IOException e) {
            System.out.println("Issue in Files, please check the files you provided");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            executor.shutdown();
        }
    }
}
