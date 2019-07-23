package model;

import java.io.*;
import java.util.*;

public class ListError {
    private Set<String> errors = new HashSet<>();
    private String path = System.getProperty("user.dir");
    public ListError(){
        System.out.println(path+"/ListError.txt");
        getListErrorFromFile();

    }
    private void getListErrorFromFile() {
        try {
            FileInputStream inF = new FileInputStream(path+"\\ListError.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inF,"Cp1251"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                errors.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  Set<String>  getListError(){
        return errors;
    }

}
