import java.util.*;

public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        List<Integer> books = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5);
        System.out.println(bookStore.calculateBasketCost(books));
    }
}
