package Load.Loaders;

import Load.Loader;
import Transform.ItemAsMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class JsonLoader extends GeneralLoader implements Loader {
    @Override
    public void load(ArrayList<ArrayList<ItemAsMap>> item, File[] dest) {
        if (checkFilesNum(item, dest)) {
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < item.size(); i++) {
                try {
                    String input = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(item.get(i));
                    write(dest[i], input);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
        else
            System.out.println("you need to open " + (item.size() - dest.length) + " more files");
    }
}