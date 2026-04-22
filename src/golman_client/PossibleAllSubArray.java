package golman_client;

import java.util.ArrayList;
import java.util.List;

public class PossibleAllSubArray {
    public static void main(String[] args) {

        int[] arr = {6, 8, 9, 2};

        List<List<Integer>> allSubarray =  generatePossibleArray(arr);

        //System.err.println(allSubarray);

        for (List<Integer> integers : allSubarray) {
            System.out.println(integers);
        }

    }

    private static List<List<Integer>> generatePossibleArray(int[] arr) {

        List<List<Integer>> allPossibleSubArrays = new ArrayList<>();

        for (int start = 0; start < arr.length; start++) {

            List<Integer> subArray = new ArrayList<>();

            for (int end = start; end < arr.length; end++) {

                subArray.add(arr[end]);
                allPossibleSubArrays.add(new ArrayList<>(subArray));
            }


        }
        return allPossibleSubArrays;

    }
}
