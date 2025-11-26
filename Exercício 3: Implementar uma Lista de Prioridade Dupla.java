import java.util.*;

public class DualPriorityQueue {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private Map<Integer, Integer> mapFrequencia;
  
    public DualPriorityQueue() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        mapFrequencia = new HashMap<>();
    }

    public void insert(int value) {
        minHeap.add(value);
        maxHeap.add(value);
        mapFrequencia.put(value, mapFrequencia.getOrDefault(value, 0) + 1);
    }
  
    private void limparTopo(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && mapFrequencia.getOrDefault(heap.peek(), 0) == 0) {
            heap.poll();
        }
    }

    public int getMax() {
        limparTopo(maxHeap);
        if (maxHeap.isEmpty()) throw new NoSuchElementException("Fila vazia");
        return maxHeap.peek();
    }

    public int getMin() {
        limparTopo(minHeap);
        if (minHeap.isEmpty()) throw new NoSuchElementException("Fila vazia");
        return minHeap.peek();
    }

    public int removeMax() {
        int max = getMax();
        maxHeap.poll();
        decrementarFrequencia(max);
        return max;
    }

    public int removeMin() {
        int min = getMin();
        minHeap.poll();
        decrementarFrequencia(min);
        return min;
    }

    private void decrementarFrequencia(int val) {
        mapFrequencia.put(val, mapFrequencia.get(val) - 1);
    }
}
