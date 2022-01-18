package Extract.Extractors;

import Extract.Extractor;
import Transform.ItemAsMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CsvExtractor extends ReadCsvToMap implements Extractor {
    @Override
    public ArrayList<ArrayList<ItemAsMap>> extract(File file) {
        try {
            setBr(file);
            setKeys();
            String line = this.br.readLine();
            while (line != null) {
                this.map.get(0).add(lineToMap(line.split(",")));
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