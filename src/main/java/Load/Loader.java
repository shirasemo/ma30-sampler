package Load;

import Transform.ItemAsMap;

import java.io.File;

public interface Loader {
    void load(ItemAsMap item, File dest);
}
