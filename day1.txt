import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("input.txt");
        System.out.println(fileData);
        ArrayList<Integer> newList = new ArrayList<Integer>(fileData.size());
        for(int i=0;i<fileData.size();i++){
            newList.add(Integer.valueOf(fileData.get(i)));
        }
        ArrayList<Integer> left = new ArrayList<Integer>(fileData.size()/2);
        ArrayList<Integer> right = new ArrayList<Integer>(fileData.size()/2);
        ArrayList<Integer> differences = new ArrayList<Integer>(fileData.size()/2);
        for(int i=0; i<fileData.size();i++){
            if(i%2==0){
                left.add(newList.get(i));
            }else{
                right.add(newList.get(i));
            }
        }
        for(int i=0;i<left.size();i++){
            differences.add(Math.abs((left.get(i)-right.get(i))));
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