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

    public ArrayList<ArrayList<ItemAsMap>> getMap() {
        return map;
    }
  /*  public int[] getIndex(String id) {
        int[] indexes = new int[2];
        for (int i = 0; i < this.map.size(); i++)
            for (int j = 0; j < this.map.get(i).size(); j++)
                if (this.map.get(i).get(j).getParameter("IDNum").equals(id)) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
        return indexes;
    } */
}
