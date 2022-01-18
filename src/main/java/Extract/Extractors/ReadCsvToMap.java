package Extract.Extractors;

import Transform.ItemAsMap;

import java.io.*;
import java.util.ArrayList;

public abstract class ReadCsvToMap {
    protected String[] keys;
    protected ArrayList<ArrayList<ItemAsMap>> map = new ArrayList<>();
    protected int index = 0;
    protected BufferedReader br;
    protected String line;

    protected void setKeys() throws IOException {
        this.map.add(new ArrayList<>());
        this.keys = this.br.readLine().split(",");
    }

    protected void setBr(File file) throws IOException {
        this.br = new BufferedReader(new FileReader(file));
        this.line = br.readLine();
    }

    protected ItemAsMap lineToMap(String[] values) {
        ItemAsMap item = new ItemAsMap();
        for (int i = 0; i < values.length; i++)
            item.addParameter(this.keys[i], values[i]);
        return item;
    }
}
