package chatgpat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxProfit {
    public static void main(String[] args) {

        int[] prices  = {7, 1, 5, 3, 6, 4};

        int[] minPrice = {Integer.MAX_VALUE};

        int maxProfit = IntStream.of(prices).map(price -> {

            minPrice[0] = Math.min(minPrice[0], price);

            return price - minPrice[0];

        }).max().orElse(0);

        System.out.println(maxProfit);

        String str = "Java Stream API makes data processing easy";

        String string = Arrays.stream(str.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null);

        System.out.println(string);

    }
}
