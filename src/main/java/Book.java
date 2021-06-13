public class Book {
    private int id;
    private String name;
    private int stock;

    public Book(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public int getStock(){
        return this.stock;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void decrease(){
        this.stock--;
    }
}
