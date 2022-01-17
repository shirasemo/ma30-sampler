package Load.Loaders;

import Load.Loader;
import Transform.ItemAsMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class JsonLoader implements Loader {
    @Override
    public void load(ArrayList<ArrayList<ItemAsMap>> item, File[] dest) {
        if (dest.length < item.size())
            System.out.println("you need to open " + (item.size() - dest.length) + " more files");
        else {
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < item.size(); i++) {
                try {
                    String input = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(item.get(i));
                    FileWriter fw = new FileWriter(dest[i]);
                    fw.write(input);
                    fw.flush();
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
