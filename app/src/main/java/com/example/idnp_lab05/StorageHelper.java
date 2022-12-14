package com.example.idnp_lab05;

import android.content.Context;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StorageHelper {

    public static void writeFile(Context context, String filename, String write) {
        if (!write.isEmpty()) {
            try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
                OutputStreamWriter outputWriter=new OutputStreamWriter(fos);
                outputWriter.write(write);
                outputWriter.flush();
                System.out.println(write);
                outputWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readFile(Context context, String filename) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        if (isFileExist(context, filename)) {
            try {
                FileInputStream fis = context.openFileInput(filename);
                InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(inputStreamReader);
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    result = sb.toString();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
        return result;
    }

    public static boolean isFileExist(Context context, String filename) {
        for (String file : context.fileList()) {
            if (file.equals(filename)) {
                return true;
            }
        }
        return false;
    }
}
