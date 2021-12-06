package LeetCode.Array.GasStation;

public class Main {

    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasSum = 0, mileageSum = 0;

        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i] - cost[i];
            if (gasSum < 0) {
                index = i + 1;
                gasSum = 0;
            }
            mileageSum += gas[i] - cost[i];
        }

        return mileageSum >= 0 ? index : -1;
    }

}
