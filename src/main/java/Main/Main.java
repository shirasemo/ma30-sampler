package Main;

import Extract.Extractors.CsvExtractorSizeLimit;
import Transform.Transformers.CsvToXml;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CsvExtractorSizeLimit c = new CsvExtractorSizeLimit();
        c.extract(new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\LabTests.csv"));
    }
}
