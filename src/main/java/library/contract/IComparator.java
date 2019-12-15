package library.contract;

import library.Wrapper;
import java.io.File;


public interface IComparator<X, Y> {

    //Compare response
    boolean compare(X x, Y y);

    Wrapper<X, Y> getData(String url1, String url2);

    void execute(File file1, File file2);

}