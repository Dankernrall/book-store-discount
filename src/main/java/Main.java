import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> books = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        int count = 0;
        books.add(1);
        books.add(2);
        books.add(1);
        books.add(3);
        books.add(2);
        books.add(1);
        books.add(5);
        books.add(1);
        books.add(1);
        for (int i = 0; i < (books.size() - 1); i++) {
            for (int j = 0; j < (books.size() - 1); j++) {
                if (books.get(i) == books.get(j) && i != j) {
                    System.out.println(books.get(i) + " " + books.get(j));
                    second.add(books.remove(j));
                    System.out.println(true);
                }
            }
        }switch (books.size()) {
            case 2:
                count += 800 * 0.95;
                break;
            case 3:
                count += 1200 * 0.90;
                break;
            case 4:
                count += 1600 * 0.80;
                break;
            case 5:
                count += 2000 * 0.85;
                break;
            default:
                count += 400;
                break;
        }
        books.clear();
        if
        System.out.println(second);
        System.out.println(books);

    }
}
