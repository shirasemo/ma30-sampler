package Load.Loaders;

import Load.Loader;
import Transform.ItemAsMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonLoader implements Loader {
    @Override
    public void load(ArrayList<ArrayList<ItemAsMap>> item, File[] dest) {
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0; i < item.size(); i++)
            for (int j = 0; j < item.get(i).size(); j++) {
                try {
                    String input = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(item.get(i).get(j));
                    objectMapper.writeValue(dest[i], input);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
