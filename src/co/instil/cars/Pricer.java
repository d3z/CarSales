package co.instil.cars;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pricer {
    public static void main(String[] args) throws IOException {
        List<CarPrice> carPrices = new ArrayList<>();
        BufferedReader carPriceList = new BufferedReader(new InputStreamReader(new FileInputStream("car_prices.txt")));
        String nextPrice;
        carPriceList.readLine();
        while ((nextPrice = carPriceList.readLine()) != null) {
            carPrices.add(CarPrice.buildFrom(nextPrice));
        }
    }
}
