package library.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import library.HttpRequestClient;
import library.ProgramExecutor;
import library.Wrapper;
import library.contract.IComparator;
import library.model.APIResponse;
import library.utils.JsonUtils;
import java.io.File;

public class ComparatorImpl implements IComparator<APIResponse, APIResponse> {

    @Override
    public boolean compare(APIResponse response1, APIResponse response2) {

        if (!(response1.getExceptionType().equals(response2.getExceptionType()))) return false;
    //  System.out.println("exception tpe is same");
        if (response1.getResponseCode() != response2.getResponseCode()) return false;
    //  System.out.println("response code is same");
        if(response1.getResponse().equals("")&&response2.getResponse().equals(""))
            return true;

        //compare the 2 responses of the URL, if the response are not JSON then we are comparing using String comparison
        //instead of throwing exception
        if(JsonUtils.isJSONObject(response1.getResponse())){
            if(JsonUtils.isJSONObject(response2.getResponse())) {
                JsonParser parser = new JsonParser();
                JsonElement json1 = parser.parse(response1.getResponse());
                JsonElement json2 = parser.parse(response2.getResponse());
                return JsonUtils.compareJSON(json1, json2);
            }
            else
                return false;
        }else{
            return response1.getResponse().equals(response2.getResponse());
        }

    }

    @Override
    public Wrapper<APIResponse, APIResponse> getData(String url1, String url2) {
        HttpRequestClient httpRequestClient = new HttpRequestClient();
        Wrapper wrapper = new Wrapper();
        wrapper.setS(httpRequestClient.call(url1));
        wrapper.setT(httpRequestClient.call(url2));
        return wrapper;
    }

    @Override
    public void execute(File file1, File file2) {
        ProgramExecutor executor = new ProgramExecutor();
        executor.execute(file1, file2);
    }
}
