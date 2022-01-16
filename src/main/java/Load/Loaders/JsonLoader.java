package Load.Loaders;

import Load.Loader;
import Transform.ItemAsMap;

import java.io.File;
import java.util.ArrayList;

public class JsonLoader implements Loader {
    @Override
    public void load(ArrayList<ArrayList<ItemAsMap>> item, File[] dest) {
        for (int i = 0; i < dest.length; i++) {
            File to = dest[i];
        }
    }
}
