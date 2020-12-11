package com.company;

import java.io.*;

public class FileMethod implements FileFilter {
    private String []array;
    public FileMethod(String...array){
        this.array=array;
    }
    private boolean check(String extension){
        for(String ext:array){
            if(extension.equals(ext)){
                return true;
            }
        }
        return false;
    }
    public static void copyFile(File in, File out) throws IOException {

        try(InputStream fis = new FileInputStream(in);
            OutputStream fos = new FileOutputStream(out)){
            streamCopy(fis, fos);
        }catch (IOException e) {
            throw e;
        }
    }


    public static void streamCopy(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[10_000_000];
        int readByte = 0;

        for (; (readByte = is.read(buffer)) > 0;) {
            os.write(buffer, 0, readByte);
        }
    }
    @Override
    public boolean accept(File pathname) {
        int point=pathname.getName().lastIndexOf(".");
        if(point==-1){
            return false;
        }
        String extension=pathname.getName().substring(point+1);
        return check(extension);
    }
}
