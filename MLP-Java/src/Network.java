import java.util.ArrayList;
import java.util.Random;

public class Network {
    private static double bias = 1;
    private static double[] weights = {0.0, 0.0, 0.0};
    private String string = "";
    /**
     * calculate the dot product for the list of four parameters
     *
     * @param set
     * @param weight
     * @return
     */
    private static int getPredict(int[] set , double[] weight) {
        double dot = set[0]* weight[0] + set[1]* weight[1] + set[2] * weight[2];
        return sign(dot + bias);
    }
    /**
     * sigmod function
     *
     * @param x
     * @return
     */
    private static int sign(double x) {
        return x > 0 ? 1 : -1;
    }
    /**
     * update weight
     *
     * @param set
     * @param type
     * @param learningRate
     */
    private static void updateWeight(int[] set, int type, double learningRate) {
        weights[0] += (set[0] * type) * learningRate;
        weights[1] += (set[0] * type) * learningRate;
        weights[2] += (set[0] * type) * learningRate;
        bias += type * learningRate;
    }

    /**
     * shuffle index
     *
     * @param array
     */
    private static void shuffleArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
