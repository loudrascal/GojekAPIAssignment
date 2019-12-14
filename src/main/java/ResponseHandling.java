import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResponseHandling {
    int responseCode =0;
    String url="",exceptionType="";
    String response="";

    public int getResponseCode() {
        return responseCode;
    }

    public String getUrl() {
        return url;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public String getResponse() {
        return response;
    }


    public ResponseHandling(String firstRequestURL) {
        this.url = firstRequestURL;
    }

    public void hitURL(){
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("GET");
            responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response +=inputLine;
            }
        } catch (Exception e) {
            exceptionType = e.getClass().getCanonicalName();
        }
    }


}
