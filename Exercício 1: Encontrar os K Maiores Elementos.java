import java.util.*;

public class Exercicio1 {

    public static List<Integer> findKthLargest(int[] arr, int k) {
        // Usamos um Min-Heap (Padrão do Java)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            
            // Se o tamanho do heap exceder K, removemos o menor elemento presente.
            // Isso garante que fiquem apenas os maiores no final.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Converte o heap para uma lista para retornar
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] dados = {3, 2, 1, 5, 6, 4};
        System.out.println("K Maiores: " + findKthLargest(dados, 2)); // Esperado: [5, 6] (ordem pode variar)
    }
}
