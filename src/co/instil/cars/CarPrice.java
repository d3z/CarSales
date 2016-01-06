package co.instil.cars;

public class CarPrice {
    private String model;
    private String manufacturer;
    private String engine;
    private String fuel;
    private String year;
    private boolean warranty;
    private double price;

    private CarPrice() {
    }

    public static CarPrice buildFrom(String priceLine) {
        CarPrice carPrice = new CarPrice();
        String[] priceLineBits = priceLine.split(",");
        carPrice.setModel(priceLineBits[0]);
        carPrice.setManufacturer(priceLineBits[1]);
        carPrice.setEngine(priceLineBits[2]);
        carPrice.setFuel(priceLineBits[3]);
        carPrice.setYear(priceLineBits[4]);
        carPrice.setWarranty(priceLineBits[5].equals("Yes"));
        carPrice.setPrice(Double.parseDouble(priceLineBits[6]));
        return carPrice;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean hasWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getModel() + "," +
                getManufacturer() + "," +
                getEngine() + "," +
                getFuel() + "," +
                getYear() + "," +
                ((hasWarranty()) ? "Yes" : "No") + "," +
                Double.toString(getPrice());
    }
}
