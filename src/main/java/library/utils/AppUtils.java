package library.utils;

public class AppUtils {

    //Used to avoid the null pointer exception
    public static boolean isEmptyString(String s) {

        if(s==null)
            return true;
        else if (s=="")
            return true;
        else
            return false;
    }
}
