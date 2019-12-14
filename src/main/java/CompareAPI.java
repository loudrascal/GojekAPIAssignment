import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class CompareAPI {
    public static boolean compareAPI(ResponseHandling first, ResponseHandling second){
        if(first.exceptionType.equals(second.exceptionType))  return true;
        if(first.getResponseCode()!=second.getResponseCode()) return false;

        if(isValidJSON(first.getResponse())){
            if(isValidJSON(second.getResponse())){
                JSONObject firstResponse = new JSONObject(first.getResponse());
                JSONObject secondResponse = new JSONObject(second.getResponse());
                return compareJSON(firstResponse,secondResponse);
            }
            else
                return false;
        }else{
            if(first.getResponse().equals(second.getResponse()))
                return true;
            else
                return false;
        }


    }

    public static boolean compareJSON(JSONObject first, JSONObject second){
        return false;
    }

    public static boolean isValidJSON(String jsonString){
        try {
            JSONObject json = new JSONObject(jsonString);
        }catch (JSONException e){
            return false;
        }
        return true;
    }
}
