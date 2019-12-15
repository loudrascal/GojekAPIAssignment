package library.runnable;

import library.Wrapper;
import library.contract.IComparator;
import library.exception.InvalidFileInputException;
import library.impl.ComparatorImpl;
import library.utils.AppUtils;


import java.io.*;

public class ExecutorRunnable implements Runnable {

    private IComparator comparator;
    private File file1, file2;

    public ExecutorRunnable(File file1, File file2) {
        this.file1 = file1;
        this.file2 = file2;
        comparator = new ComparatorImpl();
    }

    public void run() {
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
                Wrapper wrapper = comparator.getData(url1, url2);
                String result = (comparator.compare(wrapper.getS(), wrapper.getT())) ? " equals " : " not equals ";
                System.out.println(url1 + result + url1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Files not found at target location Please provide correct inputs\n" + e.getMessage() + "\n Exiting the Program");

        } catch (IOException e) {
            System.out.println("Issue in Files, please check the files you provided");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}