package Main;

import Transform.Transformers.CsvToXml;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CsvToXml csvToXml = new CsvToXml();
        csvToXml.transform(new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\LabTests.csv"),
                new File[]{new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\LABTESTS\\labtests.xml")});
    }
}
