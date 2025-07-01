package dishDemo;

public class Dish {
    private int no;
    private String name;
    private double price;

    public Dish(int no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public int change_no(int c){
        this.no=c;
        return 0;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}