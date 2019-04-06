import java.util.*;

public class FirstPerceptron {
    private static double bias = 1;
    private static double[] weights = {0.0, 0.0, 0.0, 0.0};
    private String string = "";
    private static ArrayList<FlowerBean> allFlower=FileToObject.getFlower();

    /**
     * calculate the dot product for the list of four parameters
     *
     * @param fb
     * @param weight
     * @return
     */
    private static int getPredict(FlowerBean fb, double[] weight) {
        double dot = fb.getSLength() * weight[0] + fb.getSWidth() * weight[1] + fb.getPLength() * weight[2] + fb.getPWidth() * weight[3];
        return sign(dot + bias);
    }

    /**
     * loop 'iteration' times, each time can train sets to get a suitable weight and bias
     *
     * @param flowerName
     * @param iteration
     * @param learning_rate
     */
    public static int[] training(String flowerName, int iteration, double learning_rate) {
        loadIris(flowerName);
        int[] finalPredict = new int[allFlower.size()];
        int count = 1;
        while (iteration > 0) {
            int[] index = new int[allFlower.size()];
            for (int i = 0; i < allFlower.size(); i++)
                index[i] = i;
            shuffleArray(index);

            int errorCount = 0;
            int errorFunction = 0;

            for (int i = 0; i < index.length; i++) {
                int predict = getPredict(allFlower.get(index[i]), weights);
                finalPredict[index[i]] = predict;
                if (predict * allFlower.get(index[i]).getType() != 1) {
                    errorCount++;
                    errorFunction -= (allFlower.get(index[i]).getType() * allFlower.get(index[i]).getSLength() * weights[0] + allFlower.get(index[i]).getSWidth() * weights[1] + allFlower.get(index[i]).getPLength() * weights[2] + allFlower.get(index[i]).getPWidth() * weights[3]);
                    updateWeight(allFlower.get(index[i]), allFlower.get(index[i]).getType(), learning_rate);
                }
            }
            double accuracy = Double.valueOf(String.valueOf(150 - errorCount)) / 150;
            if (count >= 500) {
                if (algorithmFlower(accuracy, flowerName)) {
                    System.out.println(flowerName.replace("Iris-","") + " got " + accuracy * 100 + "% accuracy which weight is " + Arrays.toString(weights) + " and bias is " + bias+" at iteration "+count);
                    break;
                }
            }
            count++;
            iteration--;
        }
        return finalPredict;
    }

    private static boolean algorithmFlower(double accuracy, String flowerName) {
        if (flowerName.equals("Iris-setosa")) {
            return accuracy == 1.0 ? true : false;
        } else if (flowerName.equals("Iris-versicolor")) {
            return accuracy >= 0.75 ? true : false;
        } else if (flowerName.equals("Iris-virginica")) {
            return accuracy >= 0.975 ? true : false;
        }
        return true;
    }

    /**
     * update weight
     *
     * @param fb
     * @param type
     * @param learningRate
     */
    private static void updateWeight(FlowerBean fb, int type, double learningRate) {
        weights[0] += (fb.getSLength() * type) * learningRate;
        weights[1] += (fb.getSWidth() * type) * learningRate;
        weights[2] += (fb.getPLength() * type) * learningRate;
        weights[3] += (fb.getPWidth() * type) * learningRate;
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
     * load data from iris.data
     * ep:SLength=5.1, SWidth=3.5, PLength=1.4, PWidth=0.2, FlowerName='Iris-setosa', type=1
     *
     * @param flowerName
     */
    private static void loadIris(String flowerName) {
        for (int i = 0; i < 150; i++) {
            if (allFlower.get(i).getFlowerName().equals(flowerName)) {
                allFlower.get(i).setType(1);
            } else {
                allFlower.get(i).setType(-1);
            }
        }
    }

    /**
     * collect all types
     * @return
     */
    public static int[][] getAllTypes(){
        int[][] types=new int[3][150];
        for(int i=0;i<types[0].length;i++){
            if (i<50){
                types[0][i]=1;
                types[1][i]=0;
                types[2][i]=0;
            }else if(i>49 && i<100){
                types[0][i]=0;
                types[1][i]=1;
                types[2][i]=0;
            }else {
                types[0][i]=0;
                types[1][i]=0;
                types[2][i]=1;
            }
        }
        return types;
    }

    public static void main(String[] args) {
//        System.out.println(FirstPerceptron.training("Iris-setosa", 1500, 0.3));
//        System.out.println(FirstPerceptron.training("Iris-versicolor", 1500, 0.3));
//        System.out.println(FirstPerceptron.training("Iris-virginica", 1500, 0.01));
        System.out.println(FirstPerceptron.getAllTypes());

    }
}


