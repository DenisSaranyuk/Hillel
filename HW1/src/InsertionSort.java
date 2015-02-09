public class InsertionSort {

    public static void main(String[] args) {

        InsertionSort sort = new InsertionSort();

        int[] array = {2, 10, -8, 77, -3, 1, 0, 13, 7, 5};
        sort.insertionSort(array);
        for (int i : array) { System.out.println(i);}

    }

    public void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
                array[i + 1] = key;
            }
        }
    }
}

