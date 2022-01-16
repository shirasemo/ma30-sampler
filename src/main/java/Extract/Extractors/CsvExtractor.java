package Extract.Extractors;

import Extract.Extractor;
import Transform.ItemAsMap;

import java.io.*;
import java.util.ArrayList;

public class CsvExtractor implements Extractor {
    @Override
    public ArrayList<ArrayList<ItemAsMap>> extract(File file) {
        ArrayList<ArrayList<ItemAsMap>> map = new ArrayList<>();
        int index = 0;
        map.add(new ArrayList<>());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            String[] keys = line.split(",");
            while ((line = br.readLine()) != null) {
                String values[] = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    ItemAsMap item = new ItemAsMap();
                    item.addParameter(keys[i], values[i]);
                    map.get(index).add(item);
                }
                if (map.get(index).size() == 50000) {
                    index++;
                    map.add(new ArrayList<>());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
