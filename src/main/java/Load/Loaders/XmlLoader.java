package Load.Loaders;

import Load.Loader;
import Transform.ItemAsMap;

import java.io.File;
import java.util.ArrayList;

public class XmlLoader extends GeneralLoader implements Loader {
    @Override
    public void load(ArrayList<ArrayList<ItemAsMap>> item, File[] dest) {
        if (super.checkFilesNum(item, dest)) {

        }
        else
            System.out.println("you need to open " + (item.size() - dest.length) + " more files");
    }
}
