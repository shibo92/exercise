package jvm.shengsiyuan;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

/**
 * @author by shibo on 2020/4/23.
 */
public class Test16 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("我的classLoader");
        myClassLoader.setPath("D:\\Workspace\\");
        Class<?> clazz = myClassLoader.loadClass("jvm.shengsiyuan.Test01");
        System.out.println(clazz.hashCode());
        Object obj = clazz.getDeclaredConstructor().newInstance();
        System.out.println(obj);
        MyClassLoader myClassLoader2 = new MyClassLoader("我的classLoader");
        myClassLoader2.setPath("D:\\Workspace\\");
        Class<?> clazz2 = myClassLoader2.loadClass("jvm.shengsiyuan.Test01");
        System.out.println(clazz2.hashCode());
        Object obj2 = clazz2.getDeclaredConstructor().newInstance();
        System.out.println(obj2);
    }
}

class MyClassLoader extends ClassLoader {
    private String name;
    private String path;
    private final String fileExtionsion = ".class";

    public MyClassLoader(String classLoaderName) {
        super();
        this.name = classLoaderName;
    }

    public MyClassLoader(String classLoaderName, ClassLoader classLoader) {
        super(classLoader);
        this.name = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "[[ " + this.name + " ]]";
    }

    @Override
    public Class<?> findClass(String classFullName) {
        System.out.println("自定义classLoader");
        byte[] classData = this.loadClassData(classFullName);
        return defineClass(classFullName, classData, 0, classData.length);
    }

    private byte[] loadClassData(String classFullName) {
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] result = null;
        try {
            classFullName = classFullName.replace(".", "\\");
            inputStream = new FileInputStream(new File(this.path + classFullName + this.fileExtionsion));
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
