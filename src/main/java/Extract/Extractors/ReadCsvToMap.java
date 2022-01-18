package Extract.Extractors;

import Transform.ItemAsMap;

import java.io.*;
import java.util.ArrayList;

public abstract class ReadCsvToMap {
    String[] keys;
    ArrayList<ArrayList<ItemAsMap>> map = new ArrayList<>();
    int index = 0;
    BufferedReader br;

    public void setKeys() throws IOException {
        this.map.add(new ArrayList<>());
        this.keys = this.br.readLine().split(",");
    }

    public void setBr(File file) throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(file));
    }

    public ItemAsMap lineToMap(String[] values) {
        ItemAsMap item = new ItemAsMap();
        for (int i = 0; i < values.length; i++)
            item.addParameter(this.keys[i], values[i]);
        return item;
    }
}
