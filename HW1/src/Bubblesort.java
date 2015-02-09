public class Bubblesort {

    public static void main(String[] args) {

        Bubblesort sort = new Bubblesort();

        int[] array = {2, 10, -8, 77, -3, 1, 0, 13, 7, 5};
        sort.bubblesort(array);
        for (int i: array) { System.out.println(i); }

    }

    public void bubblesort(int[] arr) {
        int min;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    min = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = min;
                }
            }
        }
    }
}

