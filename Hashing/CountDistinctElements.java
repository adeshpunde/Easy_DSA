
/*
 *   unique number
 */
import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            hs.add(num[i]);
        }
        System.out.println(hs.size());
    }
}

/*
 * Output:
 * 7
 */

/*The code you provided is a Java program that counts the number of distinct (unique) elements in an array using a `HashSet`. Here's a breakdown of the code and its output:

1. An array `num` is declared and initialized with a list of integers.

2. A `HashSet` named `hs` is created. A `HashSet` is a collection that does not allow duplicate elements, so it can be used to store distinct values.

3. A `for` loop is used to iterate through the elements of the `num` array. In each iteration, the current element (`num[i]`) is added to the `HashSet` `hs` using the `add` method.

4. After adding all the elements to the `HashSet`, the program prints the size of the `HashSet` using the `size` method. The size of the `HashSet` represents the number of distinct elements in the original array.

5. The expected output is `7`, which indicates that there are 7 distinct elements in the `num` array: 1, 2, 3, 4, 5, 6, and 7.

The code effectively demonstrates how to count the number of distinct elements in an array using a `HashSet`.*/
