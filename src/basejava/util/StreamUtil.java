package basejava.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtil {
    public static void main(String[] args) {
        System.out.println(minValue(new int[]{1, 7, 2, 3, 3, 4, 2, 3, 1}));
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            integers.add(i);
        }
        for (Integer integer : oddOrEven(integers)) {
            System.out.println(integer);
        }
    }

    private static int minValue(int[] values) {
        return Arrays
                .stream(values)
                .distinct()
                .boxed()
                .sorted()
                .reduce(0, (l, r) -> l * 10 + r);
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        return integers
                .stream()
                .reduce(0, (l, r) -> l + r) % 2 == 0 ? integers
                .stream().filter(e -> e % 2 != 0)
                .collect(Collectors.toList()) : integers
                .stream().filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
    }
}
