package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {
    private static final char CHAR = 'a';

    public int readBytesAndFindAs(String file) {
        Path path = Path.of(file);
        try (InputStream ins = new BufferedInputStream(Files.newInputStream(path)) ) {
            byte[] buffer = new byte[1000];
            int size = 0;
            int sum = 0;
            while ( (size = ins.read(buffer)) > 0 ){
                sum += lookForChar(buffer, CHAR);
            }
            return sum;
        } catch(IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    private int lookForChar(byte[] buffer, char c){
        int result = 0;
        byte searched = (byte)c;
        for (byte actual : buffer){
            if (actual == searched){
                result++;
            }
        }
        return result;
    }

//A "hivatalos" megoldással is 5063 az eredmény
//    public int readBytesAndFindAs(String fileName){
//        Path path  = Path.of(fileName);
//        int sumOfA =0;
//        try(InputStream inputStream = Files.newInputStream(path)){
//            byte[] buffer = new byte[1000];
//            int size = 0;
//            while((size=inputStream.read(buffer))>0){
//
//                for(byte b : buffer){
//                    if(b==97){
//                        sumOfA++;
//                    }
//                }
//            }
//        } catch (IOException e) {
//            throw new IllegalStateException("Can't find file!",e);
//        }
//        return sumOfA;
//    }
}
