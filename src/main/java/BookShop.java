import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookShop {
    final private List<Book> books;
    final private int pricePerBook = 8;

    public BookShop() {
        Book book1 = new Book(1,"harry potter series 1",10);
        Book book2 = new Book(2,"harry potter series 2",10);
        Book book3 = new Book(3,"harry potter series 3",10);
        Book book4 = new Book(4,"harry potter series 4",10);
        Book book5 = new Book(5,"harry potter series 5",10);

        this.books = new ArrayList<>();
        this.books.add(book1);
        this.books.add(book2);
        this.books.add(book3);
        this.books.add(book4);
        this.books.add(book5);
    }

    public Book getBookToCart(int index) {
        Book book = this.books.get(index);
        if(book.getStock() > 0){
            this.books.get(index).decrease();
            return this.books.get(index);
        }
        System.out.println("ไม่สามารถเพิ่มหนังสือได้เนื่องจากสินค้าหมด");
        return null;
    }

    public Check checkOut(Cart cart) {
        Check check = new Check(cart.getCustomer());
        if(cart.getBook().size() == 0) {
            return check;
        };
        if(cart.getBook().size() == 1) {
            check.setPriceOriginal(this.pricePerBook);
            return check;
        };

        HashMap<Integer,Integer> books = new HashMap<>(){{
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
        }};
        for (Book book : cart.getBook()) {
            final int ID = book.getID();
            books.put(ID,books.get(ID)+1);
        }

        int count = 0;
        int numberDifferentBook;
        double discount = 0.0;
        int numberBeforeDiff = 0;
        do {
            numberDifferentBook = 0;
            for (Map.Entry<Integer, Integer> book : books.entrySet()) {
                if(book.getValue() > 0){
                    numberDifferentBook++;
                    books.put(book.getKey(),book.getValue()-1);
                }
            }
            if(numberDifferentBook == 1) break;
            count += numberDifferentBook;
            if(numberDifferentBook == 3 && numberBeforeDiff == 5 && count == cart.getBook().size()){
                discount -= this.discount(numberBeforeDiff);
                discount += this.discount(numberBeforeDiff-1);
                discount += this.discount(numberDifferentBook+1);
            }else{
                discount += this.discount(numberDifferentBook);
            }
            numberBeforeDiff = numberDifferentBook;
        }while (count < cart.getBook().size());

        check.setDiscount(discount);
        check.setPriceOriginal(cart.getBook().size() * this.pricePerBook);
        return check;
    }

    private Double discount(int count){
        double price = pricePerBook*count;
        switch (count){
            case 2: price *= 0.05; break;
            case 3: price *= 0.1; break;
            case 4: price *= 0.2; break;
            case 5: price *= 0.25; break;
            default: price = 0;
        }
        return price;
    }
}
