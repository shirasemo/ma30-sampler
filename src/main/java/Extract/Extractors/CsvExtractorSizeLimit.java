package Extract.Extractors;

import Extract.Extractor;
import Transform.ItemAsMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CsvExtractorSizeLimit extends ReadCsvToMap implements Extractor {
    @Override
    public ArrayList<ArrayList<ItemAsMap>> extract(File file) {
        long bytes = 0;
        try {
            setBr(file);
            setKeys();
            for (int i = 0; i < this.keys.length; i++)
                bytes += this.keys[i].getBytes().length;
            String line = this.br.readLine();
            while (line != null) {
                for (String k : line.split(","))
                    bytes += k.getBytes().length;
                if (bytes >= 20000000) {
                    this.index++;
                    this.map.add(new ArrayList<>());
                    bytes = 0;
                }
                this.map.get(this.index).add(lineToMap(line.split(",")));
                line = this.br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.map;
    }
}
