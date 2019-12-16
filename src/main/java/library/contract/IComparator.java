package library.contract;

import library.Wrapper;
import java.io.File;


public interface IComparator<X, Y> {

    //Compare response
    boolean compare(X x, Y y);

    //Class containing the data for result of 2 url
    Wrapper<X, Y> getData(String url1, String url2);

    //Execute the  program using 2 files
    void execute(File file1, File file2);

}