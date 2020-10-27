package TestInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Random random = new Random();

        Map<Integer, Character> map = new HashMap<>();

        map.put(0, 'N');
        map.put(2, 'S');
        map.put(3, 'E');
        map.put(1, 'W');

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < 100000000; i++) {
            int rand = (int) (random.nextInt(100) + (1e9 + 7));
            temp.append(map.get(rand % 4));
        }

        System.out.println(temp);

        String filename = "largeInputString.txt";

        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write("\"" + temp + "\"");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
