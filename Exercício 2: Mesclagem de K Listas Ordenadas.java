import java.util.*;

public class Exercicio2 {

    static class Elemento implements Comparable<Elemento> {
        int valor;
        int indexDaLista;
        int indexDoElemento;

        public Elemento(int valor, int indexDaLista, int indexDoElemento) {
            this.valor = valor;
            this.indexDaLista = indexDaLista;
            this.indexDoElemento = indexDoElemento;
        }

        @Override
        public int compareTo(Elemento outro) {
            return Integer.compare(this.valor, outro.valor);
        }
    }

    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        List<Integer> resultado = new ArrayList<>();
        PriorityQueue<Elemento> minHeap = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.add(new Elemento(lists.get(i).get(0), i, 0));
            }
        }

        while (!minHeap.isEmpty()) {
            Elemento atual = minHeap.poll();
            resultado.add(atual.valor);

            int proximoIndex = atual.indexDoElemento + 1;
            List<Integer> listaDeOrigem = lists.get(atual.indexDaLista);

            if (proximoIndex < listaDeOrigem.size()) {
                minHeap.add(new Elemento(listaDeOrigem.get(proximoIndex), atual.indexDaLista, proximoIndex));
            }
        }

        return resultado;
    }
}
