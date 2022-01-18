package Main;

import Transform.Transformers.PositivePeople;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        PositivePeople positivePeople = new PositivePeople();
        positivePeople.transform(new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\MadaReports.csv"),
                new File[]{new File("C:\\Users\\shira\\Code\\Sampler\\src\\main\\resources\\POSITIVE_CORONA_PEOPLE\\positives.json")});
    }
}
