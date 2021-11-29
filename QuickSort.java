import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int vetordesordenado[] = {6,3,4,5,2,7,1,9,8,0};
		quickSort(vetordesordenado, 0, vetordesordenado.length-1);
		System.out.println(Arrays.toString(vetordesordenado));
		}

	private static void quickSort(int[] v, int esq, int dir) {
		if (esq <dir) {
			int j = separar(v, esq, dir);
			quickSort(v, esq, j-1);
			quickSort(v, j+1, dir);
		}
	}

	private static int separar(int[] v, int esq, int dir) {
		int i = esq+1;
		int j = dir;
		int pivo = v[esq];
		while (i <= j) {
			if (v[i] <= pivo)
				i++;
			else if (v[j] > pivo)
				j--;
			else if (i<=j) {
				trocar(v,i,j);
				i++;
				j--;
			}
		}
		trocar(v, esq, j);
		return j;
	}

	private static void trocar(int[] v, int i, int j) {
		int aux=v[i];
		v[i] = v[j];
		v[j] = aux;
	}

}
