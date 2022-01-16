package Main;

import Extract.Extractors.CsvExtractor;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CsvExtractor csvExtractor = new CsvExtractor();
        csvExtractor.extract(new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\MadaReports.csv"));
    }
}
