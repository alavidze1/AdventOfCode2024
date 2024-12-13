import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/day3input");
        System.out.println(fileData);
        ArrayList<String[]> newList = new ArrayList<String[]>(fileData.size());
        for (int i = 0; i < fileData.size(); i++) {
            newList.add(fileData.get(i).split(" "));
        }
        int[][] numbers = new int[newList.size()][5];
        for (int i = 0; i < newList.size(); i++) {
            for (int o = 0; o < newList.get(i)[0].length(); o++) {
                numbers[i][o] = Integer.parseInt(newList.get(i)[o]);
            }

        }
        int count = 0;
        int temp = 0;
        for (int i = 0; i < numbers.length; i++){
            for(int o=0;o<numbers[i].length;o++){
                System.out.print(numbers[i][o]);
                System.out.println();
            }

        }

        for (int i = 0; i < numbers.length; i++) {
            if (isSafe(numbers[i])) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isSafe(int[] list) {
        boolean safe = false;
        int[] arrSorted = list.clone();
        int[] arrReversed = list.clone();
        for (int i = 0; i < arrReversed.length / 2; i++) {
            int t = arrReversed[i];
            arrReversed[i] = arrReversed[arrReversed.length - 1 - i];
            arrReversed[arrReversed.length - 1 - i] = t;
        }
        Arrays.sort(arrSorted);
        if (Arrays.equals(arrSorted, list) || Arrays.equals(arrSorted, arrReversed)) {

            if (Math.abs(list[0] - list[1]) <= 3) {
                if (Math.abs(list[1] - list[2]) <= 3) {
                    if (Math.abs(list[2] - list[3]) <= 3) {
                        if (Math.abs(list[3] - list[4]) <= 3) {
                            if (getConsecutiveNumbers(list)==0)
                                safe = true;
                                System.out.println(list[0]);
                        }else{
                            safe=false;
                        }

                    }else{safe=false;}

                } else {
                    safe = false;
                }


            }


        }
        return safe;
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
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }



        public static int getConsecutiveNumbers(int [] list) {
            int consecutives = 0;
            for(int i = 1; i < list.length; i++) {
                if(list[i] - list[i-1] == 1)
                    consecutives++;

            }

            return consecutives;
        }

    }
