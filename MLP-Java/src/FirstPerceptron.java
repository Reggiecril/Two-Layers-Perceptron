import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstPerceptron {
    private double bias=1;
    private double[] weights={0.0,0.0,0.0};
    private String string="";
    private ArrayList<FlowerBean> allFlower;
    public FirstPerceptron(ArrayList<FlowerBean> allFlower){
        this.allFlower=allFlower;
    }
//    def predict(self, oneSet, weight):
//            # oneSet[X1,X2,X3] Weights[W1,W2,W3]
//            # x=(X1*W1)+(X2*W2)+(X3*W3)+bias
//        # return sign(x)
//    i = self.sign(np.dot(oneSet, weight) + self.bias)
//            return i
//    private int predict()
    public training(String flowerName, int iteration, double learning_rate){

    }
    private int sign(int x){
        return x>0?1:-1;
    }

    private void loadIris(String flowerName){
        for(int i=0;i<150;i++){
            if(allFlower.get(i).getFlowerName().equals(flowerName)){
                allFlower.get(i).setType(1);
            }else{
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

    public static void main(String[] args){
        FirstPerceptron fp=new FirstPerceptron(FileToObject.getFlower());
        System.out.println();
    }
}


