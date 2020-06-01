import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookStoreTest {

    private static final double EQUALITY_TOLERANCE = 0.001;

    private BookStore bookStore = new BookStore();


    @Test
    public void onlyASingleBook() {
        List<Integer> books = Collections.singletonList(1);
        assertEquals(400.00, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void twoOfSameBook() {
        List<Integer> books = Arrays.asList(2, 2);
        assertEquals(800.00, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void emptyBasket() {
        List<Integer> books = Collections.emptyList();
        assertEquals(0.00, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void twoDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2);
        assertEquals(760.0, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void threeDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3);
        assertEquals(1080.0, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void fourDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3, 4);
        assertEquals(1280.0, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void fiveDifferentBooks() {
        List<Integer> books = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(1500.00, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void twoGroupsOfFourIsCheaperThanGroupOfFivePlusGroupOfThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5);
        assertEquals(2560.00, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void twoGroupsOfFourIsCheaperThanGroupsOfFiveAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5);
        assertEquals(2560.00, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void groupOfFourPlusGroupOfTwoIsCheaperThanTwoGroupsOfThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 4);
        assertEquals(2040.0, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void twoEachOfFirst4BooksAnd1CopyEachOfRest() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5);
        assertEquals(2780.0, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void twoCopiesOfEachBook() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        assertEquals(3000.00, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void threeCopiesOfFirstBookAnd2EachOfRemaining() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1);
        assertEquals(3400.00, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void threeEachOFirst2BooksAnd2EachOfRemainingBooks() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1, 2);
        assertEquals(3760.0, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }

    @Test
    public void fourGroupsOfFourAreCheaperThanTwoGroupsEachOfFiveAndThree() {
        List<Integer> books = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 1, 1, 2, 2, 3, 3, 4, 5);
        assertEquals(5120.00, bookStore.calculateBasketCost(books), EQUALITY_TOLERANCE);
    }
}