import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int vetordesordenado[] = {9, 8, 4, 6, 3};
		mergeSort(vetordesordenado, new int[vetordesordenado.length], 0, vetordesordenado.length-1);
		System.out.println(Arrays.toString(vetordesordenado));
	}
	private static int[] mergeSort(int [] v, int[] w, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio+fim)/2;
			mergeSort(v, w, inicio, meio);
			mergeSort(v, w, meio+1, fim);
			intercalar(v, w, inicio, meio, fim);
		}
		return v;
	}
	private static void intercalar(int[] v, int[] w, int inicio, int meio, int fim) {
		for (int k=inicio; k<=fim; k++)
			w[k] = v[k];
		
		int i=inicio;
		int j=meio + 1;
		
		for (int k=inicio; k<=fim; k++) {
			if (i>meio) v[k] = w[j++];
			else if (j>fim) v[k] = w[i++];
			else if (w[i] < w[j]) v[k] = w[i++];
			else v[k] = w[j++];
		}
	}
}
