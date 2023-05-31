package main;

import java.io.File;
import java.io.FileWriter;

public class Log {
    //write ./rsc/log.txt
    public static void write(String s) {
        File f = new File("./rsc/log.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(f, true);
            fw.write(s + "\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
