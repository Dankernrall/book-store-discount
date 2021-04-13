import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BookStore {
    int count = 0;  // Счет уникальных книг
    int finalPrice = 0; // Финальная цена с учетом скидок
    int forThree, forFive; // Переменные для набора книг по 4
    int lastPosI = 0;  // Последняя позиция i для цикла
    int size = 0; // Размер пришедшей корзины
    boolean first = true; // Для отработки кода один раз
    HashMap<Integer, Integer> copyingOfBooks = new HashMap<>();

    public int calculateBasketCost(List<Integer> books) {
        if (books.isEmpty()) // Проверка на пустую корзину
            return 0;
        //Заполняем HashMap по принципу: key - номер книги, value - их количество
        if (first) {
            for (Integer b : books) {
                size++;
                int newValue = copyingOfBooks.getOrDefault(b, 0) + 1;
                copyingOfBooks.put(b, newValue);
            }
            first = false;
        }
//Проходимся по циклу, пока количество уникальных книг меньше максимального количества value в HashMap
        while (count < Collections.max(copyingOfBooks.values())) {
            for (int i = 1; i < copyingOfBooks.size() + 2; i++) {
                try {
                    if (copyingOfBooks.get(i) > 1) { //Пока количество(value) книг по ключу i больше 1, берем их
                        lastPosI = i;
                        copyingOfBooks.replace(i, copyingOfBooks.get(i) - 1);
                        count++;
                    } else if (copyingOfBooks.get(i) == 1 && copyingOfBooks.get(i) != 0) { //Далее берем книги в единичном экземпляре
                        copyingOfBooks.replace(i, copyingOfBooks.get(i) - 1);
                        count++;
                    }
                    lastPosI = 0; //Обнуляем последнюю позицию i
                } catch (NullPointerException e) {
                }
            }
        }
        switch (count) {
            case 1:
                finalPrice += 400;
                break;
            case 2:
                finalPrice += 800 * 0.95;
                break;
            case 3:
                forThree++;
                break;
            case 4:
                finalPrice += 1600 * 0.80;
                break;
            case 5:
                forFive++;
                break;
        }
        count = 0;
        if (Collections.max(copyingOfBooks.values()) > 0)
            calculateBasketCost(books);
        while (forThree > 0 || forFive > 0) { //Пока имеются уникальные наборы книг по 3 и 5 штук
            if (forThree != 0 && forFive != 0) { // Разбиваем по 4 группы
                finalPrice += (1600 * 0.80) * 2;
                forThree--;
                forFive--;
            } else if (forThree == 0) { // Заносим в итоговую стоимость уникальную группу книг из 5
                finalPrice += 2000 * 0.75;
                forFive--;
            } else {
                finalPrice += 1200 * 0.90; // Заносим в итоговую стоимость уникальную группу книг из 3
                forThree--;
            }
        }
        return finalPrice;
    }
}
