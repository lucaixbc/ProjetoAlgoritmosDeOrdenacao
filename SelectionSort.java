import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] vetordesordenado = {5, 6, 9, 10, 4, 3, 1, 2, 7, 8};
		selectionSort(vetordesordenado);
		System.out.println(Arrays.toString(vetordesordenado));
		

	}
	private static void trocar(int[] vetor, int i, int menor) {
		int aux = vetor[i];
		vetor[i] = vetor[menor];
		vetor[menor] = aux;
	}
	
	private static int[] selectionSort(int [] vetor) {
		for (int i = 0; i<vetor.length; i++) {
			int menor = i;
			for (int j=i+1; j<vetor.length; j++) {
				if (vetor[j] < vetor[menor]) 
					menor = j;
			}
				trocar(vetor, i , menor);
		}
		return vetor;
	}
}
