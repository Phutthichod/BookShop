import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookShopTest {

    @Test
    @DisplayName("Test Basic")
    void basic(){
        BookShop bookShop = new BookShop();
        Customer customer = new Customer("lisa");
        Cart cart = new Cart(customer);

        Check check = bookShop.checkOut(cart);
        assertEquals(0, check.getPriceToPay());

        cart.addBook(bookShop.getBookToCart(1));

        check = bookShop.checkOut(cart);
        assertEquals(8, check.getPriceToPay());
        cart.addBook(bookShop.getBookToCart(1));
        cart.addBook(bookShop.getBookToCart(1));

        check = bookShop.checkOut(cart);
        assertEquals(8*3, check.getPriceToPay());
    }

    @Test
    @DisplayName("Simple Discount")
    void simple(){
        BookShop bookShop = new BookShop();
        Customer customer = new Customer("lisa");
        Cart cart = new Cart(customer);

        cart.addBook(bookShop.getBookToCart(1));
        cart.addBook(bookShop.getBookToCart(2));

        Check check = bookShop.checkOut(cart);
        assertEquals(8*2*0.95, check.getPriceToPay());

        Cart cart2 = new Cart(customer);
        cart2.addBook(bookShop.getBookToCart(1));
        cart2.addBook(bookShop.getBookToCart(3));
        cart2.addBook(bookShop.getBookToCart(4));

        Check check2 = bookShop.checkOut(cart2);
        assertEquals(8*3*0.9, check2.getPriceToPay());

        Cart cart3 = new Cart(customer);
        cart3.addBook(bookShop.getBookToCart(1));
        cart3.addBook(bookShop.getBookToCart(2));
        cart3.addBook(bookShop.getBookToCart(3));
        cart3.addBook(bookShop.getBookToCart(4));

        Check check3 = bookShop.checkOut(cart3);
        assertEquals(8*4*0.8, check3.getPriceToPay());

        Cart cart4 = new Cart(customer);
        cart4.addBook(bookShop.getBookToCart(1));
        cart4.addBook(bookShop.getBookToCart(2));
        cart4.addBook(bookShop.getBookToCart(3));
        cart4.addBook(bookShop.getBookToCart(4));
        cart4.addBook(bookShop.getBookToCart(0));

        Check check4 = bookShop.checkOut(cart4);
        assertEquals(8*5*0.75, check4.getPriceToPay());
    }

    @Test
    @DisplayName("Several Discount")
    void serveral(){
        BookShop bookShop = new BookShop();
        Customer customer = new Customer("lisa");
        Cart cart = new Cart(customer);

        cart.addBook(bookShop.getBookToCart(0));
        cart.addBook(bookShop.getBookToCart(0));
        cart.addBook(bookShop.getBookToCart(1));

        Check check = bookShop.checkOut(cart);
        assertEquals(8 + (8 * 2 * 0.95), check.getPriceToPay());

        Cart cart2 = new Cart(customer);
        cart2.addBook(bookShop.getBookToCart(0));
        cart2.addBook(bookShop.getBookToCart(0));
        cart2.addBook(bookShop.getBookToCart(1));
        cart2.addBook(bookShop.getBookToCart(1));

        Check check2 = bookShop.checkOut(cart2);
        assertEquals(2 * (8 * 2 * 0.95), check2.getPriceToPay());

        Cart cart3 = new Cart(customer);
        cart3.addBook(bookShop.getBookToCart(0));
        cart3.addBook(bookShop.getBookToCart(0));
        cart3.addBook(bookShop.getBookToCart(1));
        cart3.addBook(bookShop.getBookToCart(2));
        cart3.addBook(bookShop.getBookToCart(2));
        cart3.addBook(bookShop.getBookToCart(3));

        Check check3 = bookShop.checkOut(cart3);
        assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), check3.getPriceToPay());

        Cart cart4 = new Cart(customer);
        cart4.addBook(bookShop.getBookToCart(0));
        cart4.addBook(bookShop.getBookToCart(1));
        cart4.addBook(bookShop.getBookToCart(1));
        cart4.addBook(bookShop.getBookToCart(2));
        cart4.addBook(bookShop.getBookToCart(3));
        cart4.addBook(bookShop.getBookToCart(4));

        Check check4 = bookShop.checkOut(cart4);
        assertEquals(8 + (8 * 5 * 0.75), check4.getPriceToPay());
    }

    @Test
    @DisplayName("Edge Cases")
    void edge(){
        BookShop bookShop = new BookShop();
        Customer customer = new Customer("lisa");
        Cart cart = new Cart(customer);

        cart.addBook(bookShop.getBookToCart(0));
        cart.addBook(bookShop.getBookToCart(0));
        cart.addBook(bookShop.getBookToCart(1));
        cart.addBook(bookShop.getBookToCart(1));
        cart.addBook(bookShop.getBookToCart(2));
        cart.addBook(bookShop.getBookToCart(2));
        cart.addBook(bookShop.getBookToCart(3));
        cart.addBook(bookShop.getBookToCart(4));

        Check check = bookShop.checkOut(cart);
        assertEquals(2 * (8 * 4 * 0.8), check.getPriceToPay());

        Cart cart2 = new Cart(customer);
        cart2.addBook(bookShop.getBookToCart(0));
        cart2.addBook(bookShop.getBookToCart(0));
        cart2.addBook(bookShop.getBookToCart(0));
        cart2.addBook(bookShop.getBookToCart(0));
        cart2.addBook(bookShop.getBookToCart(0));
        cart2.addBook(bookShop.getBookToCart(1));
        cart2.addBook(bookShop.getBookToCart(1));
        cart2.addBook(bookShop.getBookToCart(1));
        cart2.addBook(bookShop.getBookToCart(1));
        cart2.addBook(bookShop.getBookToCart(1));
        cart2.addBook(bookShop.getBookToCart(2));
        cart2.addBook(bookShop.getBookToCart(2));
        cart2.addBook(bookShop.getBookToCart(2));
        cart2.addBook(bookShop.getBookToCart(2));
        cart2.addBook(bookShop.getBookToCart(3));
        cart2.addBook(bookShop.getBookToCart(3));
        cart2.addBook(bookShop.getBookToCart(3));
        cart2.addBook(bookShop.getBookToCart(3));
        cart2.addBook(bookShop.getBookToCart(3));
        cart2.addBook(bookShop.getBookToCart(4));
        cart2.addBook(bookShop.getBookToCart(4));
        cart2.addBook(bookShop.getBookToCart(4));
        cart2.addBook(bookShop.getBookToCart(4));

        Check check2 = bookShop.checkOut(cart2);
        assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), check2.getPriceToPay());

    }
}
