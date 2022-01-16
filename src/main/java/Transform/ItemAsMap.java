package Transform;

import java.util.HashMap;
import java.util.Set;

public class ItemAsMap {
    private HashMap<String, String> parameters;

    public ItemAsMap() {
        this.parameters = new HashMap<>();
    }

    public HashMap<String, String> getParameters() {
        return this.parameters;
    }

    public String getParameter(String key) {
        return this.parameters.get(key);
    }

    public void addParameter(String key, String value) {
        this.parameters.put(key, value);
    }
}
