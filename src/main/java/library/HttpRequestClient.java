package library;

import library.model.APIResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestClient {

    public APIResponse call(String url) {
        APIResponse apiResponse = new APIResponse();
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("GET");
            apiResponse.setResponseCode(con.getResponseCode());
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder("");
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            apiResponse.setResponse(response.toString());
        } catch (Exception e) {
            apiResponse.setExceptionType(e.getClass().getCanonicalName());
        }

        return apiResponse;
    }
}
