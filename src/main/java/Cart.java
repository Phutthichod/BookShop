import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Customer customer;
    private List<Book> books;

    Cart(Customer customer){
        this.customer = customer;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if(book != null)
            this.books.add(book);
    }

    public List<Book> getBook(){
        return books;
    }

    public Customer getCustomer(){
        return customer;
    }

}
