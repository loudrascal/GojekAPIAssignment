package library.runnable;

import library.Wrapper;
import library.contract.IComparator;
import library.exception.InvalidFileInputException;
import library.impl.ComparatorImpl;
import library.utils.AppUtils;


import java.io.*;

public class ExecutorRunnable implements Runnable {

    private IComparator comparator;
    private String url1,url2;

    public ExecutorRunnable(String url1, String url2) {
        this.url1 = url1;
        this.url2 = url2;
        comparator = new ComparatorImpl();
    }

    public void run() {
        Wrapper wrapper = comparator.getData(url1, url2);
        String result = (comparator.compare(wrapper.getS(), wrapper.getT())) ? " equals " : " not equals ";
        System.out.println(url1 + result + url1);
    }
}