package Load;

import Transform.ItemAsMap;

import java.io.File;
import java.util.ArrayList;

public interface Loader {
    void load(ArrayList<ArrayList<ItemAsMap>> item, File[] dest);
}
