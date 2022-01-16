package Extract.Extractors;

import Extract.Extractor;
import Transform.ItemAsMap;

import java.io.*;

public class CsvExtractor implements Extractor {
    @Override
    public ItemAsMap extract(File file) {
        ItemAsMap map = new ItemAsMap();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            String[] keys = line.split(",");
            while((line=br.readLine())!=null){
                String values[] = line.split(",");
                for(int i = 0 ;i < values.length; i++)
                    map.addParameter(keys[i], values[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
