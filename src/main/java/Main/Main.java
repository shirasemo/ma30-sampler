package Main;

import Transform.Transformers.CsvToJson;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CsvToJson csvToJson = new CsvToJson();
        File[] json = {new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\mada_reports\\report1.json")};
        csvToJson.transform(new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\MadaReports.csv"),json);
    }
}
