public class Book {
    private int ID;
    private String name;
    private int stock;

    public Book(int ID, String name, int stock) {
        this.ID = ID;
        this.name = name;
        this.stock = stock;
    }

    public int getStock(){
        return this.stock;
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public void decrease(){
        this.stock--;
    }
}
