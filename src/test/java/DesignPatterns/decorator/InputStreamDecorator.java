package DesignPatterns.decorator;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

/**
 * @author shibo
 * @date 19-12-17 上午10:51
 */
public class InputStreamDecorator {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("123");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        CheckedInputStream checkedInputStream = new CheckedInputStream(bufferedInputStream, new CRC32());
        DataInputStream dataInputStream = new DataInputStream(checkedInputStream);
    }
}
