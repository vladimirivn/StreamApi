import java.util.List;
import java.util.function.BiConsumer;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> listInteger = List.of(1, 2, 3, 4, -5, 36, 7, 8, 9, 10);

        System.out.println("---------- Задание 1----------------------");
        findMinMax(listInteger.stream(), Integer::compareTo, (x, y) -> System.out.println("Минимальное число: " + x + "\nМаксимальное число: " + y));
        System.out.println("---------- Задание 2----------------------");
        numberOfEvenNumbers(listInteger);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> list = stream.collect(Collectors.toList());
        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.stream().min(order).get(), list.stream().max(order).get());

        } else {
            minMaxConsumer.accept(null, null);
        }

    }

    public static void numberOfEvenNumbers(List<Integer> list) {
        int n = (int) list.stream().filter(e -> e % 2 == 0).peek(System.out::println).count();
        System.out.println(n);
    }
}