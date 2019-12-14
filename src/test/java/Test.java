import org.json.JSONObject;

public class Test {
    public static void main(String[] args) {
        String url = "https://www.java67.com/2018/02/a-simple-example-to-send-http-request-from-Java-program.html";
       /* ResponseHandling response = new ResponseHandling(url);
        response.hitURL();
        System.out.println("response code:"+response.getResponseCode());
        System.out.println("Exception type:"+response.getExceptionType());
      //  System.out.println("response :"+response.getResponse());*/

        JSONObject firstObject = new JSONObject(url);
    }
}
