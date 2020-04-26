package jvm.shengsiyuan;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author by shibo on 2020/4/23.
 */
public class Test16 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("我的classLoader");
        Class<?> clazz = myClassLoader.loadClass("jvm.shengsiyuan.Test01");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        System.out.println(obj);
    }
}

class MyClassLoader extends ClassLoader {
    private String name;
    private final String fileExtionsion = ".class";

    public MyClassLoader(String classLoaderName) {
        super();
        this.name = classLoaderName;
    }

    public MyClassLoader(String classLoaderName, ClassLoader classLoader) {
        super(classLoader);
        this.name = classLoaderName;
    }

    @Override
    public String toString() {
        return "[[ " + this.name + " ]]";
    }

    @Override
    public Class<?> findClass(String classFullName) {
        byte[] classData = this.loadClassData(classFullName);
        return this.defineClass(classFullName, classData, 0, classData.length);
    }

    private byte[] loadClassData(String classFullName) {
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] result = null;
        try {
            inputStream = new FileInputStream(new File(classFullName + this.fileExtionsion));
            int ch;
            while ((ch = inputStream.read()) != -1) {
                outputStream.write(ch);
            }
            result = outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
