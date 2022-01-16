package Extract;

import Transform.ItemAsMap;

import java.io.File;

public interface Extractor {
    ItemAsMap extract(File file);
}
