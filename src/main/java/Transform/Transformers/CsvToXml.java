package Transform.Transformers;

import Extract.Extractors.CsvExtractor;
import Load.Loaders.XmlLoader;
import Transform.Transformer;
import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;

import java.io.File;

public class CsvToXml extends GeneralTransformer implements Transformer {
    @Override
    public void transform(File source, File[] dest) {
        super.getItems(source, new CsvExtractor());
        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();
        for (int i = 0; i < this.getMap().size(); i++) {
            for (int j = 0; j < this.getMap().get(i).size(); j++) {
                int num = Integer.parseInt(this.getMap().get(i).get(j).getParameter("IDNum"));
                int type = Integer.parseInt(this.getMap().get(i).get(j).getParameter("IDType"));
                try {
                    PersonInsured personInsured = healthCareInfoProvider.fetchInfo(num, type);
                    this.getMap().get(i).get(j).addParameter("JOIN_DATE", personInsured.getJoinDate().toString());
                    this.getMap().get(i).get(j).addParameter("HEALTH_CARE_ID", String.valueOf(personInsured.getHealthCareId()));
                    this.getMap().get(i).get(j).addParameter("HEALTH_CARE_NAME", personInsured.getHealthCareName());
                } catch (InvalidIdException e) {
                    System.out.println("person not found, id: " + num);
                }
            }
        }

        super.loadItems(dest, new XmlLoader());
    }
}
