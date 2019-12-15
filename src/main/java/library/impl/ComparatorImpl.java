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
        if (response1.getExceptionType().equals(response2.getExceptionType())) return true;
        if (response1.getResponseCode() != response2.getResponseCode()) return false;

        JsonParser parser = new JsonParser();
        JsonElement json1 = parser.parse(response1.getResponse());
        JsonElement json2 = parser.parse(response2.getResponse());

        if (json1.isJsonObject() && json2.isJsonObject()) {
            return JsonUtils.compareJSON(json1, json2);
        } else {
            return false;
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
