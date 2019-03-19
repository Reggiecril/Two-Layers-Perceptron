import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileToObject {
    //sepal_length sepal_width petal_length petal_width
    private ArrayList<String> readFile(String filename){
        ArrayList<String> list=new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = in.readLine()) != null) {
                list.add(str);
            }
            System.out.println(str);
        } catch (IOException e) {
        }
        return list;
    }
    public
}
