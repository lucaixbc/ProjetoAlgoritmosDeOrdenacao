import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ProjetoOrdenacao {
	//PROGRAMA PRINCIPAL
	public static void main(String[] args) {
		System.out.println("Gerando 10 números aleatórios de 0 a 50	 para ordenar:");
		int[] vetordesordenado = numAleatorio(10);
			System.out.println(Arrays.toString(vetordesordenado));
			System.out.println("\n");
			System.out.println("Tipos de algoritmos de ordenação: ");
			System.out.println("1 - BubbleSort");
			System.out.println("2 - SelectionSort");
			System.out.println("3 - InserctionSort");
			System.out.println("4 - MergeSort");
			System.out.println("5 - QuickSort");
			System.out.println("\n");
			System.out.println("Digite o número que indica qual tipo iremos utilizar: ");
			Scanner entrada = new Scanner(System.in);
			int tipo = entrada.nextInt();
			
			if (tipo == 1) {
				System.out.println("Utilizando BubbleSort: ");
				bubbleSort(vetordesordenado);
				System.out.println(Arrays.toString(vetordesordenado));
			}
			else if (tipo == 2) {
				System.out.println("Utilizando SelectionSort: ");
				selectionSort(vetordesordenado);
				System.out.println(Arrays.toString(vetordesordenado));
			}
			else if (tipo == 3) {
				System.out.println("Utilizando InserctionSort: ");
				inserctionSort(vetordesordenado);
				System.out.println(Arrays.toString(vetordesordenado));
			}
			else if (tipo == 4) {
				System.out.println("Utilizando MergeSort: ");
				mergeSort(vetordesordenado, new int[vetordesordenado.length], 0, vetordesordenado.length-1);
				System.out.println(Arrays.toString(vetordesordenado));
			}
			else if (tipo == 5) {
				System.out.println("Utilizando QuickSort: ");
				quickSort(vetordesordenado, 0, vetordesordenado.length-1);
				System.out.println(Arrays.toString(vetordesordenado));
			}
			else {
				System.out.println("Finalizado!!!");
			}
	}
	
	//MÉTODOS
	
	//Método BubbleSort
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
	
	private static void trocarB(int[] vetor, int i, int menor) {
		int aux = vetor[i];
		vetor[i] = vetor[menor];
		vetor[menor] = aux;
	}
	
	//Método SelectionSort
	private static int[] selectionSort(int [] vetor) {
		for (int i = 0; i<vetor.length; i++) {
			int menor = i;
			for (int j=i+1; j<vetor.length; j++) {
				if (vetor[j] < vetor[menor]) 
					menor = j;
			}
				trocarB(vetor, i , menor);
		}
		return vetor;
	}
		
	//Método InserctionSort
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
	
	//Método MergeSort
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
	
	//Método QuickSort
	private static int[] quickSort(int[] v, int esq, int dir) {
		if (esq <dir) {
			int j = separar(v, esq, dir);
			quickSort(v, esq, j-1);
			quickSort(v, j+1, dir);
		}
		return v;
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
				trocarQ(v,i,j);
				i++;
				j--;
			}
		}
		trocarQ(v, esq, j);
		return j;
	}

	private static void trocarQ(int[] v, int i, int j) {
		int aux=v[i];
		v[i] = v[j];
		v[j] = aux;
	}
	
	//Gerando números aleatórios
	private static int[] numAleatorio(int tam) {
		int num;
		int vetor[] = new int[tam];
		Random r = new Random();
		for (int i = 0; i < vetor.length; i++) {
			num = r.nextInt(50);
			for(int j=0; j<vetor.length; j++) {
				if(num == vetor[j] && j!=i) {
					num = r.nextInt(50);
				}else {
					vetor[i] = num;
			}
		}
		}
		return vetor;
		
	}
}