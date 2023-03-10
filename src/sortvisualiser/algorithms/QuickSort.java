package sortvisualiser.algorithms;
import sortvisualiser.SortArray;

public class QuickSort implements ISortAlgorithm {
    private long stepDelay = 30;      //Declares a private variable to be passed as parameter in setDelay method.
    private int findPivotPoint(SortArray array, int lowIndex, int highIndex) {
        int pivotValue = array.getValue(highIndex);
        int i = lowIndex - 1;
        for (int j = lowIndex; j <= highIndex - 1; j++) {
            if (array.getValue(j) <= pivotValue) {
                i++;
                array.swap(i, j, getDelay(), true);
            }
        }
        array.swap(i + 1, highIndex, getDelay(), true);
        return i + 1;
    }

    private void quickSort(SortArray array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int pivotPoint = findPivotPoint(array, lowIndex, highIndex);
            quickSort(array, lowIndex, pivotPoint - 1);
            quickSort(array, pivotPoint + 1, highIndex);
        }
    }

    @Override
    public void runSort(SortArray array) {
        quickSort(array, 0, array.arraySize() - 1);
    }

    @Override
    public String getName() {        // getname method to return type of sort, used in MainMenuScreen and SortingVisualizerScreen
        return "Quick Sort";
    }
    public String getName1() {       // getname1 method to return time and space complexity, used in MainMenuScreen and SortingVisualizerScreen
        return "Time: (n^2)\n Space: O(n)";
    }
    @Override
    public long getDelay() {          // Used to return value of delay
        return stepDelay;
    }
    @Override
    public void setDelay(long delay) { // used to set the value of delay
        this.stepDelay = delay;        // this pointer is used to reference the current class instance variable
    }
}