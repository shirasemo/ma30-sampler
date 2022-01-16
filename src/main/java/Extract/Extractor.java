package Extract;

import Transform.ItemAsMap;

import java.io.File;
import java.util.ArrayList;

public interface Extractor {
    ArrayList<ArrayList<ItemAsMap>> extract(File file);
}
