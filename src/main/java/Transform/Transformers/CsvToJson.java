package Transform.Transformers;

import Extract.Extractors.CsvExtractorNumLimit;
import Load.Loaders.JsonLoader;
import Transform.Transformer;

import java.io.File;

public class CsvToJson extends GeneralTransformer implements Transformer {
    @Override
    public void transform(File source, File[] dest) {
        getItems(source, new CsvExtractorNumLimit());
        loadItems(dest, new JsonLoader());
    }
}
