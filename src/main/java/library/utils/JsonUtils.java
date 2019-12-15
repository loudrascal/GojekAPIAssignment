package library.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Set;

public class JsonUtils {

    public static boolean compareJSON(JsonElement first, JsonElement second){

        boolean isEqual = true;
        // Check whether both jsonElement are not null
        if(first !=null && second !=null) {

            // Check whether both jsonElement are objects
            if (first.isJsonObject() && second.isJsonObject()) {
                Set<Map.Entry<String, JsonElement>> ens1 = ((JsonObject) first).entrySet();
                Set<Map.Entry<String, JsonElement>> ens2 = ((JsonObject) second).entrySet();
                JsonObject json2obj = (JsonObject) second;
                if (ens1 != null && ens2 != null && (ens2.size() == ens1.size())) {
                    // Iterate JSON Elements with Key values
                    for (Map.Entry<String, JsonElement> en : ens1) {
                        isEqual = isEqual && compareJSON(en.getValue() , json2obj.get(en.getKey()));
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

            // Check whether both jsonElement are primitives
            else if (first.isJsonPrimitive() && second.isJsonPrimitive()) {
                return first.equals(second);
            } else {
                return false;
            }
        } else return first == null && second == null;
        return isEqual;
    }
}
