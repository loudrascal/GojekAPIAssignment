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
        JsonParser parser = new JsonParser();
        String file1 = "/home/hi.agrawal/json1.txt";
        String file2 = "/home/hi.agrawal/json2.txt";
        File first = new File(file1);
        File second = new File(file2);
        // JSON String
        BufferedReader br = new BufferedReader(new FileReader(first));
        String st ="";
        String ts="";
        String rt ="";
        while((st=br.readLine())!=null){
            ts+=st;
        }
        br = new BufferedReader(new FileReader(second));


        while((st=br.readLine())!=null){
            rt+=st;
        }
   //     System.out.println(ts);
       /* String json1 = "{" + "\"age\":100,"
                + "\"name\":\"srinivas\","
                + "\"school\":\"\","
                + "\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]}";
        String json2 = "{" + "\"age\":10,"
                + "\"name\":\"srinivas\","
                + "\"school\":\"\","
                + "\"messages\":[\"msg 1\",\"msg 2\"]}";
*/
        JsonElement jsonElement1 = parser.parse(new StringReader(ts));
        JsonElement jsonElement2 = parser.parse(new StringReader(rt));
        System.out.println(compareJson(jsonElement1, jsonElement2));

    }

    public static boolean compareJson(JsonElement json1, JsonElement json2) {
        boolean isEqual = true;
        // Check whether both jsonElement are not null
        if(json1 !=null && json2 !=null) {

            // Check whether both jsonElement are objects
            if (json1.isJsonObject() && json2.isJsonObject()) {
                Set<Entry<String, JsonElement>> ens1 = ((JsonObject) json1).entrySet();
                Set<Entry<String, JsonElement>> ens2 = ((JsonObject) json2).entrySet();
                JsonObject json2obj = (JsonObject) json2;
                if (ens1 != null && ens2 != null && (ens2.size() == ens1.size())) {
                    // Iterate JSON Elements with Key values
                    for (Entry<String, JsonElement> en : ens1) {
                        isEqual = isEqual && compareJson(en.getValue() , json2obj.get(en.getKey()));
                    }
                } else {
                    return false;
                }
            }

            // Check whether both jsonElement are arrays
            else if (json1.isJsonArray() && json2.isJsonArray()) {
                JsonArray jarr1 = json1.getAsJsonArray();
                JsonArray jarr2 = json2.getAsJsonArray();
                if(jarr1.size() != jarr2.size()) {
                    return false;
                } else {
                    int i = 0;
                    // Iterate JSON Array to JSON Elements
                    for (JsonElement je : jarr1) {
                        isEqual = isEqual && compareJson(je , jarr2.get(i));
                        i++;
                    }
                }
            }

            // Check whether both jsonElement are null
            else if (json1.isJsonNull() && json2.isJsonNull()) {
                return true;
            }

            // Check whether both jsonElement are primitives
            else if (json1.isJsonPrimitive() && json2.isJsonPrimitive()) {
                if(json1.equals(json2)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else if(json1 == null && json2 == null) {
            return true;
        } else {
            return false;
        }
        return isEqual;
    }
}
