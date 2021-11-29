import java.util.Arrays;

public class BubbleSort
{
	public static void main(String[] args) {
		int[] vetordesordenado = {50,10,1,2,5,27,7,99,4};
		bubbleSort(vetordesordenado);
		System.out.println(Arrays.toString(vetordesordenado));
		
	}
	private static int[] bubbleSort(int[] vetordesordenado) {
    int n = vetordesordenado.length;
    
    for ( int i=0; i<n; i++) {
        for ( int j=0; j<n-1; j++) {
            if (vetordesordenado[j] > vetordesordenado[j+1]) {
                int aux = vetordesordenado[j];
                vetordesordenado[j] = vetordesordenado[j+1];
                vetordesordenado[j+1] = aux;
            }
        }
    }
    return vetordesordenado;
}
}
