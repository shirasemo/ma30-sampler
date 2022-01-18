package Extract.Extractors;

import Extract.Extractor;
import Transform.ItemAsMap;

import java.io.*;
import java.util.ArrayList;

public class CsvExtractorNumLimit extends ReadCsvToMap implements Extractor {
    @Override
    public ArrayList<ArrayList<ItemAsMap>> extract(File file) {
        try {
            setBr(file);
            setKeys();
            String line = this.br.readLine();
            while (line != null) {
                this.map.get(this.index).add(lineToMap(line.split(",")));
                if (this.map.get(this.index).size() == 50000) {
                    this.index++;
                    this.map.add(new ArrayList<>());
                }
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
