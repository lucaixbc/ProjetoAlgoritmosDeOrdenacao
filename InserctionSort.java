import java.util.Arrays;

public class InserctionSort {

	public static void main(String[] args) {
		int[] vetordesordenado = {5, 6, 9, 10, 4, 3, 1, 2, 7, 8};
		inserctionSort(vetordesordenado);
		System.out.println(Arrays.toString(vetordesordenado));

	}

	private static int[] inserctionSort(int[] vetor) {
		int aux, j;
		for (int i=1; i<vetor.length; i++) {
			aux = vetor[i];
			j = i-1;
			
			while((j>=0) &&(vetor[j]> aux))  {
				vetor[j+1] = vetor[j];
				j--;
			}
			vetor[j+1] = aux;
		}
		return vetor;
	}
}