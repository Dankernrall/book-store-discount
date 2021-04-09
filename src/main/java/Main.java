import java.awt.print.Book;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 1, 1, 2, 2, 3, 3, 4, 5);
        System.out.println(bookStore.calculateBasketCost(books));
    }
}
