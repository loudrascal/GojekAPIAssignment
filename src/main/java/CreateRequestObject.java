import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class CreateRequestObject {

    public static RequestSpecification createRequest(String url){
        if(!(url.startsWith("http") ||url.startsWith("HTTP") ))
            return null;
        RestAssured.baseURI = url;
        RequestSpecification request = RestAssured.given();
        return request;
    }
}
