package Transform.Transformers;

import Extract.Extractor;
import Load.Loader;
import Transform.ItemAsMap;

import java.io.File;

public abstract class GeneralTransformer {
    private ItemAsMap map;

    public GeneralTransformer() {
        this.map = new ItemAsMap();
    }

    public void getItems(File file, Extractor extractor) {
        this.map = extractor.extract(file);
    }

    public void loadItems(File file, Loader loader) {
        loader.load(this.map, file);
    }

    public ItemAsMap getMap() {
        return map;
    }

    public void setMap(ItemAsMap map) {
        this.map = map;
    }
}
