public class carClass {
    private String model;
    private String year;
    private double price;

    public carClass(){
    }

    public carClass(String m, String y, double p){
        model = m;
        year = y;
        price = p;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getYear() {
        return year;
    }

    public void setPrice(double price) {
        if(price < 0){
            return;
        }
        else{
            this.price = price;
        }
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
