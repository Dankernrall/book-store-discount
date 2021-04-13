import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> books = Arrays.asList(1, 2, 3, 4); // Для личной проверки
        BookStore bookStore = new BookStore();
        System.out.println(bookStore.calculateBasketCost(books));
    }
}
