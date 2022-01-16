package Transform.Transformers;

import Extract.Extractors.CsvExtractor;
import Load.Loaders.JsonLoader;
import Transform.ItemAsMap;
import Transform.Transformer;

import java.io.File;

public class CsvToJson extends GeneralTransformer implements Transformer {

    public CsvToJson() {
        super();
    }

    @Override
    public void transform(File source, File dest) {
        super.getItems(source, new CsvExtractor());
        super.loadItems(dest, new JsonLoader());
    }
}
