package itHillel;

import java.util.ArrayList;
import java.util.List;
import static itHillel.Main.ArrayToList.toList;


public class Main {
    public class ArrayToList {
        public static <T> List<T> toList(T[] arr) {
            List<T> list = new ArrayList<>();
            for (T elem : arr) {
                list.add(elem);
            }
            return list;
        }

    }
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5};
        List<Integer> intList = toList(intArr);
        System.out.println(intList);

        String[] strArr = {"apple", "orange", "banana"};
        List<String> strList = toList(strArr);
        System.out.println(strList);
    }
}

