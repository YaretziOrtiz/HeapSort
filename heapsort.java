import java.util.Scanner;

class heapsort {

    // Función para aplicar heapify a un subárbol con raíz en el nodo i
    static void heapify(int arr[], int n, int i) {
        int largest = i; // Inicializa el nodo raíz
        int l = 2 * i + 1; // Hijo izquierdo
        int r = 2 * i + 2; // Hijo derecho

        // Si el hijo izquierdo es mayor que la raíz
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // Si el hijo derecho es mayor que el mayor hasta ahora
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // Si el mayor no es la raíz
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursivamente aplica heapify al subárbol afectado
            heapify(arr, n, largest);
        }
    }

    // Función principal para realizar el ordenamiento por Heap Sort
    static void heapSort(int arr[]) {
        int n = arr.length;

        // Construye el heap (reorganiza el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrae elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llama a heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }

    // Función para imprimir el arreglo
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Función principal
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de elementos a ordenar: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];

        System.out.println("Ingrese los elementos:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Ordena el arreglo usando Heap Sort
        heapSort(arr);

        System.out.println("El arreglo ordenado es: ");
        printArray(arr);

        scanner.close();
    }
}
