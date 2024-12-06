import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("testday11");
        System.out.println(fileData);
        ArrayList<Integer> newList = new ArrayList<Integer>(fileData.size());
        String[] splitStr;
        for(int i=0;i<fileData.size();i++){
            splitStr=fileData.get(i).split("\\s+");
            for(int p=0;p< splitStr.length;p++){
                newList.add(Integer.valueOf(splitStr[p]));
            }

        }
        System.out.println(newList);
        ArrayList<Integer> left = new ArrayList<Integer>(fileData.size()/2);
        ArrayList<Integer> right = new ArrayList<Integer>(fileData.size()/2);
        ArrayList<Integer> differences = new ArrayList<Integer>(fileData.size()/2);
        for(int i=0; i<newList.size();i++){
            if(i%2==0){
                left.add(newList.get(i));
            }else{
                right.add(newList.get(i));
            }
        }
        System.out.println(left);
        Collections.sort(left);
        System.out.println(right);
        Collections.sort(right);
        for(int i=0;i<left.size();i++){
            differences.add(Math.abs((left.get(i)-right.get(i))));
            System.out.println(Math.abs((left.get(i)-right.get(i))));
        }
        int sum = 0;
        for(int i = 0; i < differences.size(); i++) {
            sum += differences.get(i);
        }
        System.out.println("New List size: "+ newList.size());
        System.out.println("Left size: "+ left.size());
        System.out.println("Right size: "+ right.size());
        System.out.println("Differences size: "+ differences.size());
        System.out.println(sum);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}