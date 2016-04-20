package com.ho.minhhuy.savingdata;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Hi on 4/11/2016.
 */
public class FileManager {
    static Context context;
    static String filename="fileSave.txt";
    public FileManager(Context c){
        context=c;
    }
    public static void doWork(){
            if(!isExternalStorageReadable()){
                Toast.makeText(context, "Bạn có không có thẻ SD Card", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(context, "Bạn có SD Card", Toast.LENGTH_LONG).show();
            }
    }
    public static void writeDataBNT(Person p){
        File file = new File(context.getFilesDir(), filename);
        String string =p.getName()+";"+p.getAge()+",";
        FileOutputStream outputStream;

        try {
            if(file.exists()) {
                outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
            }else{
                outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            }
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Person>  readDataBNT()
    {
        ArrayList<Person> listPS = new ArrayList<Person>();
        try {
            FileInputStream in= context.openFileInput(filename);
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            String data="";

            while((data=reader.readLine())!=null)
            {
                String[] a = data.split(",");
                for(String ab:a){
                    Person ps = new Person();
                    String[] b = ab.split(";");
                    ps.setName(b[0]);
                    ps.setAge(b[1]);
                    listPS.add(ps);
                }
            }
            System.out.print(listPS.size());
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listPS;
    }


    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }


    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }








}
