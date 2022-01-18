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

    public abstract void transform(File source, File[] dest);

    public void getItems(File file, Extractor extractor) {this.map = extractor.extract(file);}

    public void loadItems(File[] files, Loader loader) {
        loader.load(this.map, files);
    }

    public ArrayList<ArrayList<ItemAsMap>> getMap() {
        return map;
    }

    public void setMap(ArrayList<ArrayList<ItemAsMap>> map) {
        this.map = map;
    }

    public ArrayList<ArrayList<ItemAsMap>> getAnotherMap(File file, Extractor extractor) { return extractor.extract(file);}
}
