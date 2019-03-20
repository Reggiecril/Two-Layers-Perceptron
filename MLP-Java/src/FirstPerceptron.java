import java.util.ArrayList;
import java.util.HashMap;

public class FirstPerceptron {
    private double bias=1;
    private double[] weights={0.0,0.0,0.0};
    private String string="";
    private HashMap<String, ArrayList<FlowerBean>> map;
    public FirstPerceptron(HashMap<String, ArrayList<FlowerBean>> map){
        this.map=map;
    }

    public static void main(String[] args){
//        FirstPerceptron fp=new FirstPerceptron();
        FileToObject fto=new FileToObject();
        System.out.println(fto.getFlower());
    }
}


