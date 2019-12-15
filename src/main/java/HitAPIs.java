

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HitAPIs implements Runnable {

    String firstRequestURL,secondRequestURL;
    HitAPIs(String firstRequestURL, String secondRequestURL){
        this.firstRequestURL = firstRequestURL;
        this.secondRequestURL= secondRequestURL;
    }
    public void run() {


            ResponseHandling response1 = new ResponseHandling(firstRequestURL);
            ResponseHandling response2 = new ResponseHandling(secondRequestURL);
            response1.hitURL();
            response2.hitURL();
            String result = (CompareAPI.compareAPI(response1, response2)) ? " equals " : " not equals ";
            System.out.println(firstRequestURL + result + firstRequestURL);



    }
}
