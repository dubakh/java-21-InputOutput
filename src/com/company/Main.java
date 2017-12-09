package com.company;

import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
	    //File file = new File("/Users/boris/Desktop/test.txt");
        // InputStream inputStream = new FileInputStream(file);
        InputStream inputStream = new URL("https://www.google.co.il/").openStream();
        OutputStream outputStream = System.out;
        try {
            copy(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte [] buff = new byte[64 * 1024];

        while(inputStream.available() > 0) {


            int count = inputStream.read(buff);

            outputStream.write(buff, 0, count);
        }
        inputStream.close();
        outputStream.close();
    }
}
