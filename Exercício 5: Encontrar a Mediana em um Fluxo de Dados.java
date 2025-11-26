import java.util.*;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeapMetadeInferior;
    private PriorityQueue<Integer> minHeapMetadeSuperior;

    public MedianFinder() {

        maxHeapMetadeInferior = new PriorityQueue<>(Collections.reverseOrder());

        minHeapMetadeSuperior = new PriorityQueue<>();
    }

    public void addNum(int num) {

        maxHeapMetadeInferior.add(num);

        minHeapMetadeSuperior.add(maxHeapMetadeInferior.poll());

        if (maxHeapMetadeInferior.size() < minHeapMetadeSuperior.size()) {
            maxHeapMetadeInferior.add(minHeapMetadeSuperior.poll());
        }
    }

    public double findMedian() {

        if (maxHeapMetadeInferior.size() > minHeapMetadeSuperior.size()) {
            return maxHeapMetadeInferior.peek();
        } 

        else {
            return (maxHeapMetadeInferior.peek() + minHeapMetadeSuperior.peek()) / 2.0;
        }
    }
}
