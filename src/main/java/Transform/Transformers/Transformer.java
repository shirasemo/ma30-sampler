package Transform.Transformers;

import Extract.Extractor;
import Load.Loader;
import Transform.ItemAsMap;

import java.io.File;
import java.util.ArrayList;

public abstract class Transformer {
    private ArrayList<ArrayList<ItemAsMap>> map;

    public Transformer() {this.map = new ArrayList<>();}

    public abstract void transform(File source, File[] dest);

    protected void getItems(File file, Extractor extractor) {this.map = extractor.extract(file);}

    protected void loadItems(File[] files, Loader loader) {loader.load(this.map, files);}

    protected ArrayList<ArrayList<ItemAsMap>> getMap() {return map;}

    protected void setMap(ArrayList<ArrayList<ItemAsMap>> map) {this.map = map;}

    protected ArrayList<ArrayList<ItemAsMap>> getAnotherMap(File file, Extractor extractor) { return extractor.extract(file);}
}
