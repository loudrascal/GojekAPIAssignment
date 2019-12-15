package library.utils;

public class AppUtils {

    public static boolean isEmptyString(String s) {

        if(s==null)
            return true;
        else if (s=="")
            return true;
        else
            return false;
    }
}
