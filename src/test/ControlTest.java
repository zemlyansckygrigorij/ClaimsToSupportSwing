package test;

import test.ControlDateTimeTest;

import java.io.*;

public class ControlTest {
    private ControlTest(){}
    static{ }
    public static void runTest(){
       //set output result tests to text file
        PrintStream outResults = getPrintStreamForAppend(getFile("E:\\test.txt"));
        System.setOut(outResults);

        // run test
        System.out.println("----------------------------------------------------------------------------------------------------------");
        ControlDateTimeTest test = new ControlDateTimeTest();
        test.testFormatDateTime("yyyyMMdd hh mm ss a");



    }



    private static PrintStream getPrintStreamForAppend(File file){
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(file, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return out;
    }

    private static File getFile(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  file;
    }
}
