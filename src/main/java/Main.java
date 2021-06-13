import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookShop shop = new BookShop();

        Customer customer = new Customer("lisa");
        Cart cart = new Cart(customer);
        cart.addBook(shop.getBookToCart(0));
        cart.addBook(shop.getBookToCart(2));
        cart.addBook(shop.getBookToCart(3));
        cart.addBook(shop.getBookToCart(3));
        cart.addBook(shop.getBookToCart(3));

        Check check = shop.checkOut(cart);
        check.show();
    }
}
