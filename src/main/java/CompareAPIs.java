import io.restassured.specification.RequestSpecification;

public class CompareAPIs implements Runnable {

    RequestSpecification firstRequest,secondRequest;
    CompareAPIs(RequestSpecification firstRequest,RequestSpecification secondRequest){
        this.firstRequest = firstRequest;
        this.secondRequest= secondRequest;
    }
    public void run() {

    }
}
