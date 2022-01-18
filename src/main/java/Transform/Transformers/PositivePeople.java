package Transform.Transformers;

import Extract.Extractors.CsvExtractorNumLimit;
import Transform.ItemAsMap;
import Transform.Transformer;

import java.io.File;
import java.util.ArrayList;

public class PositivePeople extends GeneralTransformer implements Transformer {

    @Override
    public void transform(File source, File[] dest) {
        getItems(source, new CsvExtractorNumLimit());
        ArrayList<ArrayList<ItemAsMap>> lab = getAnotherMap(new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\LabTests.csv"), new CsvExtractorNumLimit());

        for (int i = 0; i < this.getMap().size(); i++) {
            for (int j = 0; j < this.getMap().get(i).size(); j++) {

            }
        }
    }
}
