import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HitAPIs implements Runnable {

    String firstRequestURL,secondRequestURL;
    HitAPIs(String firstRequestURL, String secondRequestURL){
        this.firstRequestURL = firstRequestURL;
        this.secondRequestURL= secondRequestURL;
    }
    public void run() {
        Response response1 = ResponseHandling.getResponse(firstRequestURL);
        Response response2 = ResponseHandling.getResponse(secondRequestURL);
        String result = (CompareAPI.compareAPI(response1,response2))?" equals ":" not equals ";
        System.out.println(firstRequestURL +result + firstRequestURL);
    }
}
