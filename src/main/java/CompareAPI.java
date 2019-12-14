import io.restassured.response.Response;

public class CompareAPI {
    public static boolean compareAPI(Response first,Response second){
        if(first.statusCode()==second.statusCode())
            return true;
        return false;
    }
}
