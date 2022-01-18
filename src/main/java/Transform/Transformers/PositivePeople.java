package Transform.Transformers;

import Extract.Extractors.CsvExtractor;
import Load.Loaders.JsonLoader;
import Transform.ItemAsMap;

import java.io.File;
import java.util.ArrayList;

public class PositivePeople extends GeneralTransformer {

    @Override
    public void transform(File source, File[] dest) {
        getItems(source, new CsvExtractor());

        ArrayList<ArrayList<ItemAsMap>> lab = getAnotherMap(new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\LabTests.csv"), new CsvExtractor());
        ArrayList<ArrayList<ItemAsMap>> positives = new ArrayList<>();
        int index = 0;
        long bytes = 0;
        positives.add(new ArrayList<>());
        for (int i = 0; i < lab.size(); i++) {
            for (int j = 0; j < lab.get(i).size(); j++) {
                if (lab.get(i).get(j).getParameter("ResultTestCorona").equals("1")) {
                    int[] found = findPersonById(lab.get(i).get(j).getParameter("IDNum"));
                    if (found != null) {
                        long currentBytes = 0;
                        int a = found[0];
                        int b = found[1];

                        ItemAsMap add = new ItemAsMap();
                        add.addParameter("ResultTestCorona", "1");
                        String[] pLab = {"IDNum", "IDType", "FirstName", "LastName", "BirthDate", "LabCode", "StickerNumber", "Variant", "TestType"};
                        String[] pMda = {"City", "Street", "BuildingNumber", "Barcode", "ResultDate", "TakeDate"};
                        for (String s : pLab) {
                            add.addParameter(s, lab.get(i).get(j).getParameter(s));
                            currentBytes += s.getBytes().length + lab.get(i).get(j).getParameter(s).getBytes().length;
                            bytes += currentBytes;
                        }
                        for (String s : pMda) {
                            add.addParameter(s, this.getMap().get(a).get(b).getParameter(s));
                            currentBytes += s.getBytes().length + this.getMap().get(i).get(j).getParameter(s).getBytes().length;
                            bytes += currentBytes;
                        }
                        if (bytes >= 20000000 - currentBytes) {
                            bytes = 0;
                            index++;
                            positives.add(new ArrayList<>());
                        }
                        positives.get(index).add(add);
                    }
                    else
                        System.out.println("details are missing for id: " + lab.get(i).get(j).getParameter("IDNum"));
                }
            }
        }
        this.setMap(positives);
        loadItems(dest, new JsonLoader());
    }

    private int[] findPersonById(String id) {
        for (int i = 0; i < this.getMap().size(); i++)
            for (int j = 0; j < this.getMap().get(i).size(); j++)
                if (this.getMap().get(i).get(j).getParameter("IDNum").equals(id))
                    return new int[]{i, j};
        return null;
    }
}
