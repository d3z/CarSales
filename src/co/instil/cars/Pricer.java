package co.instil.cars;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pricer {

    private static final String HEADER = "Model,Manufacturer,Engine,Fuel,Year,Warranty,Price";

    public static void main(String[] args) throws IOException {
        List<CarPrice> carPrices = loadPriceList("car_prices.txt");
        List<CarPrice> newCarPrices = applyPricingRules(carPrices);
        writeNewPriceList(newCarPrices, "new_car_prices.txt");
    }

    private static List<CarPrice> loadPriceList(String priceListFilename) throws IOException {
        List<CarPrice> carPrices = new ArrayList<>();
        BufferedReader carPriceList = new BufferedReader(new FileReader(priceListFilename));
        String nextPrice;
        carPriceList.readLine();
        while ((nextPrice = carPriceList.readLine()) != null) {
            carPrices.add(CarPrice.buildFrom(nextPrice));
        }
        carPriceList.close();
        return carPrices;
    }

    private static List<CarPrice> applyPricingRules(List<CarPrice> carPrices) {
        return carPrices;
    }

    private static void writeNewPriceList(List<CarPrice> newCarPrices, String newPriceListFilename) throws IOException {
        File newCarPriceListFile = new File(newPriceListFilename);
        if (!newCarPriceListFile.exists()) {
            newCarPriceListFile.createNewFile();
        }
        BufferedWriter carPriceList = new BufferedWriter(new FileWriter(newPriceListFilename));
        carPriceList.write(HEADER);
        carPriceList.write('\n');
        for (CarPrice price : newCarPrices) {
            carPriceList.write(price.toString());
            carPriceList.write('\n');
            carPriceList.flush();
        }
        carPriceList.close();
    }
}
