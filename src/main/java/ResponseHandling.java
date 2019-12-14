import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseHandling {
    public static Response getResponse(String url){
        RequestSpecification request = CreateRequestObject.createRequest(url);
        Response response = request.get();
        return response;
    }
}
