package Transform.Transformers;

import Extract.Extractor;
import Load.Loader;
import Transform.ItemAsMap;

import java.io.File;
import java.util.ArrayList;

public abstract class GeneralTransformer {
    private ArrayList<ArrayList<ItemAsMap>> map;

    public GeneralTransformer() {
        this.map = new ArrayList<>();
    }

    public void getItems(File file, Extractor extractor) {
        this.map = extractor.extract(file);
    }

    public void loadItems(File[] files, Loader loader) {
        loader.load(this.map, files);
    }
}
