package ScenerioBased;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMapFindTop3Value {

    public static void main(String[] args) {

        Map<String, Integer> stringIntegerMap = Map.of("Naveen K", 87, "Sagar J", 65, "Aditya Y", 82, "Priyanka", 32, "Harish K", 57);

        TreeMap map = new TreeMap(stringIntegerMap);
        System.out.println("key Based sorting :"+map); //based on key sorting is oky but

        //based on value soring

        LinkedHashMap<String, Integer> sorted1 = stringIntegerMap.entrySet().stream().sorted((v1, v2) -> v1.getValue().compareTo(v2.getValue())).limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e, r) -> e, LinkedHashMap::new));

        System.err.println("Min 3 value :"+sorted1);
        LinkedHashMap<String, Integer> sorted2 = stringIntegerMap.entrySet().stream().sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue())).limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e, r) -> e, LinkedHashMap::new));

        System.err.println("Max 3 value :"+sorted2);

        LinkedHashMap<String, Integer> collect = stringIntegerMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e, r) -> e, LinkedHashMap::new));

        System.err.println("Levaraging merge funtion "+collect);

    }
}
