package Load.Loaders;

import Transform.ItemAsMap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class GeneralLoader {

    public boolean checkFilesNum(ArrayList<ArrayList<ItemAsMap>> item, File[] dest) {
        if (dest.length < item.size())
            return false;
        return true;
    }

    public void write(File file, String value) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(value);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
