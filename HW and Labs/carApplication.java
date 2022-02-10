

class carApplication {
    public static void main(String[] args){
        carClass car1 = new carClass("Maxima", "2007", 5000.0);
        carClass car2 = new carClass("Model 3", "2022", 30000.0);

        System.out.println("Before Discount: ");
        System.out.println(car1.getModel() + " costs " + car1.getPrice());
        System.out.println(car2.getModel() + " costs " + car2.getPrice());

        car1.setPrice(car1.getPrice() * .95);
        car2.setPrice(car2.getPrice() * .93);

        System.out.println("After Discount: ");
        System.out.println(car1.getModel() + " costs " + car1.getPrice());
        System.out.println(car2.getModel() + " costs " + car2.getPrice());
    }
}