import java.util.*;

public class Exercicio1 {

    public static List<Integer> findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] dados = {3, 2, 1, 5, 6, 4};
        System.out.println("K Maiores: " + findKthLargest(dados, 2));
    }
}
