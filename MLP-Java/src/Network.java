import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Network {
    private double bias = 1;
    private double[] weights = {0.0, 0.0, 0.0};
    private int [][]sets=predictSets();
    private int[][] types=FirstPerceptron.getAllTypes();
    private String string = "";
    /**
     * calculate the dot product for the list of four parameters
     * @param set
     * @param weight
     * @return
     */
    private int getPredict(int[] set , double[] weight) {
        double dot = set[0]* weight[0] + set[1]* weight[1] + set[2] * weight[2];
        return sign(dot + bias);
    }
    /**
     * loop 'iteration' times, each time can train sets to get a suitable weight and bias
     * @param num
     * @param iteration
     * @param learning_rate
     */
    public int[] training(int num,int iteration, double learning_rate) {
        int[] record=new int[150];
        while (iteration > 0) {
            int[] index = new int[sets.length];
            for (int i = 0; i < sets.length; i++)
                index[i] = i;
            shuffleArray(index);

            int errorCount = 0;
            int errorFunction = 0;

            for (int i = 0; i < index.length; i++) {
                int predict = getPredict(sets[i], weights);
                record[i]=predict;
                if(predict==1){
                    if (types[i][num]==0){
                        errorCount+=1;
                        updateWeight(sets[i],-1,learning_rate);
                    }
                }else {
                    if (types[i][num]==1) {
                        errorCount += 1;
                        updateWeight(sets[i], 1, learning_rate);
                    }
                }
            }
            double accuracy = Double.valueOf(String.valueOf(150 - errorCount)) / 150;

            iteration--;
        }
        return record;
    }
    /**
     * sigmod function
     *
     * @param x
     * @return
     */
    private int sign(double x) {
        return x > 0 ? 1 : -1;
    }
    /**
     * update weight
     *
     * @param set
     * @param type
     * @param learningRate
     */
    private void updateWeight(int[] set, int type, double learningRate) {
        weights[0] += (set[0] * type) * learningRate;
        weights[1] += (set[1] * type) * learningRate;
        weights[2] += (set[2] * type) * learningRate;
        bias += type * learningRate;
    }

    /**
     * shuffle index
     *
     * @param array
     */
    private void shuffleArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    /**
     * collect all output from first layer
     * @return
     */
    private int[][] predictSets(){
        int[][] sets=new int[150][3];
        int[] setosa=FirstPerceptron.training("Iris-setosa", 1500, 0.3);
        int[] versicolor=FirstPerceptron.training("Iris-versicolor", 1500, 0.3);
        int[] virginica=FirstPerceptron.training("Iris-virginica", 1500, 0.01);

        for (int i=0;i<150;i++)
            sets[i][0] = setosa[i];
        for (int i=0;i<150;i++)
            sets[i][1] = versicolor[i];
        for (int i=0;i<150;i++)
            sets[i][2] = virginica[i];
        return sets;
    }
    public static void main(String[] args) {
//        System.out.println(FirstPerceptron.training("Iris-setosa", 1500, 0.3));
//        System.out.println(FirstPerceptron.training("Iris-versicolor", 1500, 0.3));
//        System.out.println(FirstPerceptron.training("Iris-virginica", 1500, 0.01));
        Network network=new Network();
        System.out.println(Arrays.toString(network.training(1,1000,0.3)));

    }
}
