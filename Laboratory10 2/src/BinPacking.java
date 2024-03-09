import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BinPacking {
    public static void main(String args[]) {
        ArrayList<Integer> itemsToPack = new ArrayList<>();
        int number;
        int capacity;

        Scanner sc = new Scanner(System.in);

        System.out.println("How many items are to be packed?");
        number = sc.nextInt();

        System.out.println("Enter the bin capacity?");
        capacity = sc.nextInt();

        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int item = random.nextInt(capacity) + 1;
            itemsToPack.add(item);
        }

        System.out.println("-----------------------------");
        System.out.println("\nItems to pack:");
        System.out.println(itemsToPack);
        System.out.println("-----------------------------");

        System.out.println("First Fit result:");
        ArrayList<ArrayList<Integer>> firstFitBins = firstFit(itemsToPack, capacity);
        summarizeBins(firstFitBins);

        System.out.println("Next Fit result:");
        ArrayList<ArrayList<Integer>> nextFitBins = nextFit(itemsToPack, capacity);
        summarizeBins(nextFitBins);
    }

    public static ArrayList<ArrayList<Integer>> firstFit(ArrayList<Integer> items, int capacity) {
        ArrayList<ArrayList<Integer>> bins = new ArrayList<>();
        for (int item : items) {
            boolean placed = false;
            for (ArrayList<Integer> bin : bins) {
                int binCapacity = capacity - sum(bin);
                if (item <= binCapacity) {
                    bin.add(item);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                ArrayList<Integer> newBin = new ArrayList<>();
                newBin.add(item);
                bins.add(newBin);
            }
        }
        return bins;
    }

    public static ArrayList<ArrayList<Integer>> nextFit(ArrayList<Integer> items, int capacity) {
        ArrayList<ArrayList<Integer>> bins = new ArrayList<>();
        ArrayList<Integer> currentBin = new ArrayList<>();
        bins.add(currentBin);

        for (int item : items) {
            int binCapacity = capacity - sum(currentBin);
            if (item <= binCapacity) {
                currentBin.add(item);
            } else {
                currentBin = new ArrayList<>();
                currentBin.add(item);
                bins.add(currentBin);
            }
        }
        return bins;
    }

    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public static void summarizeBins(ArrayList<ArrayList<Integer>> bins) {
        int totalBins = bins.size();
        System.out.println("Values for each bin:");
        for (ArrayList<Integer> bin : bins) {
            System.out.print(sum(bin) + " ");
        }
        System.out.println("\nTotal number of bins used: " + totalBins);
    }
}
