public class Exercicio4 {

    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <= (n / 2) - 1; i++) {
            
            int filhoEsq = 2 * i + 1;
            int filhoDir = 2 * i + 2;

            if (filhoEsq < n && arr[i] > arr[filhoEsq]) {
                return false;
            }

            if (filhoDir < n && arr[i] > arr[filhoDir]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] valido = {1, 3, 5, 7, 9, 8};
        int[] invalido = {5, 3, 8, 1, 2};
        
        System.out.println("É MinHeap? " + isMinHeap(valido));
        System.out.println("É MinHeap? " + isMinHeap(invalido));
    }
}
