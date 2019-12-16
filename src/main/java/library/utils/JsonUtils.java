package library.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.util.Map;
import java.util.Set;

public class JsonUtils {

    //For checking whether the object is JSON Object or not
    public static boolean isJSONObject(String jsonstring){
        try{
            JsonParser parser = new JsonParser();
            JsonElement json = parser.parse(jsonstring);
            return json.isJsonObject();
        }catch (Exception e){
            return false;
        }
    }



    //for comparing the 2 JSONs
    public static boolean compareJSON(JsonElement first, JsonElement second){

        boolean isEqual = true;
        // Check whether both jsonElement are not null
        if(first !=null && second !=null) {

            // Check whether both jsonElement are JSONobjects
            if (first.isJsonObject() && second.isJsonObject()) {
                Set<Map.Entry<String, JsonElement>> entrySet1 = ((JsonObject) first).entrySet();
                Set<Map.Entry<String, JsonElement>> entrySet2 = ((JsonObject) second).entrySet();
                JsonObject json2obj = (JsonObject) second;
                if (entrySet1 != null && entrySet2 != null && (entrySet2.size() == entrySet1.size())) {
                    // Iterate JSON Elements with Key values
                    for (Map.Entry<String, JsonElement> element : entrySet1) {
                        isEqual = isEqual && compareJSON(element.getValue() , json2obj.get(element.getKey()));
                    }
                } else {
                    return false;
                }
            }

            // Check whether both jsonElement are arrays
            else if (first.isJsonArray() && second.isJsonArray()) {
                JsonArray jarr1 = first.getAsJsonArray();
                JsonArray jarr2 = second.getAsJsonArray();
                if(jarr1.size() != jarr2.size()) {
                    return false;
                } else {
                    int i = 0;
                    // Iterate JSON Array to JSON Elements
                    for (JsonElement je : jarr1) {
                        isEqual = isEqual && compareJSON(je , jarr2.get(i));
                        i++;
                    }
                }
            }

            // Check whether both jsonElement are null
            else if (first.isJsonNull() && second.isJsonNull()) {
                return true;
            }

            // Check whether both jsonElements are made up of only primitive data types
            else if (first.isJsonPrimitive() && second.isJsonPrimitive()) {
                return first.equals(second);
            } else {
                return false;
            }
        } else return first == null && second == null;
        return isEqual;
    }
}
