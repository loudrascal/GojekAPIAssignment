import library.HttpRequestClient;
import library.model.APIResponse;
import org.json.JSONObject;

import java.io.*;
import java.util.Map.Entry;
import java.util.Set;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Test {
    public static void main(String[] args) throws Exception {
        HttpRequestClient test = new HttpRequestClient();
        APIResponse api = test.call("https://reqres.in/api/users/3");
        System.out.println(api);

    }


}
