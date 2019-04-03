import java.util.*;

public class FirstPerceptron {
    private double bias = 1;
    private double[] weights = {0.0, 0.0, 0.0, 0.0};
    private String string = "";
    private ArrayList<FlowerBean> allFlower;

    public FirstPerceptron(ArrayList<FlowerBean> allFlower) {
        this.allFlower = allFlower;
    }

    /**
     * calculate the dot product for the list of four parameters
     * @param fb
     * @param weight
     * @return
     */
    private int getPredict(FlowerBean fb, double[] weight) {
        double dot = fb.getPLength() * weight[0] + fb.getPWidth() * weight[1] + fb.getSLength() * weight[2] + fb.getSWidth() * weight[3];
        return sign(dot + bias);

    }

    public void training(String flowerName, int iteration, double learning_rate){
        loadIris(flowerName);
        while(iteration >0){
            int [] index=new int[allFlower.size()];
            for(int i=0;i<allFlower.size();i++)
                index[i]=i;
            shuffleArray(index);
            System.out.println(index);
            iteration--;
        }
    }
    private static void shuffleArray(int[] array)
    {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    /**
     * sigmod function
     * @param x
     * @return
     */
    private int sign(double x) {
        return x > 0 ? 1 : -1;
    }

    /**
     * load data from iris.data
     * ep:SLength=5.1, SWidth=3.5, PLength=1.4, PWidth=0.2, FlowerName='Iris-setosa', type=1
     * @param flowerName
     */
    private void loadIris(String flowerName) {
        for (int i = 0; i < 150; i++) {
            if (allFlower.get(i).getFlowerName().equals(flowerName)) {
                allFlower.get(i).setType(1);
            } else {
                allFlower.get(i).setType(-1);
            }
        }
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public static void main(String[] args) {
        FirstPerceptron fp = new FirstPerceptron(FileToObject.getFlower());
        fp.training("Iris-setosa",1,2.1);
    }
}


