public class Check {
    private Customer customer;
    private double discount;
    private double priceOriginal;

    public Check(Customer customer) {
        this.customer = customer;
        this.priceOriginal = 0.0;
        this.discount = 0.0;
    }

    public void setPriceOriginal(double price){
        this.priceOriginal = price;
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }

    public double getPriceToPay(){
        return this.priceOriginal-this.discount;
    }

    public void show(){
        System.out.println("ลูกค้า: "+this.customer.getName());
        System.out.println("ราคาก่อนลด: "+this.priceOriginal);
        System.out.println("ราคาที่ลด: "+this.discount);
        System.out.println("ราคารวมที่ต้องจ่าย: "+this.getPriceToPay());
    }


}
