import com.sun.tools.javac.comp.Flow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FileToObject {
    //sepal_length sepal_width petal_length petal_width
    private static ArrayList<String> readFile(String filename){
        ArrayList<String> list=new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/"+filename));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.equals("")) break;
                list.add(str);
            }
        } catch (IOException e) {
        }
        return list;
    }
    private static ArrayList<FlowerBean> flowerObject(ArrayList<String> list){
        ArrayList<FlowerBean> flowerBeans=new ArrayList<>();
        for(String str:list){
            String[] flowerString = str.split(",");
            flowerBeans.add(new FlowerBean(Double.parseDouble(flowerString[0]),Double.parseDouble(flowerString[1]),Double.parseDouble(flowerString[2]),Double.parseDouble(flowerString[3]),flowerString[4]));

        }
        return flowerBeans;
    }
    public static ArrayList<FlowerBean> getFlower(){
        return flowerObject(readFile("iris.data"));
    }
}
