package jvm.shengsiyuan;

import java.io.*;

/**
 * @author by shibo on 2020/4/23.
 */
public class Test16 extends ClassLoader {
    private String classLoaderName;
    private final String fileExtension = ".class";

    public Test16(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public Test16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[[" + this.classLoaderName + "]]";
    }

    @Override
    public Class<?> findClass(String classFullName) {
        byte[] data = this.loadClassData(classFullName);
        return this.defineClass(classFullName, data, 0, data.length);
    }

    /**
     * 根据类全路径名加载
     *
     * @param classFullName
     * @return
     */
    private byte[] loadClassData(String classFullName) {
        InputStream inputStream = null;
        byte[] resultData = null;
        ByteArrayOutputStream baos = null;

        this.classLoaderName = this.classLoaderName.replace(".", "/");
        try {
            inputStream = new FileInputStream(new File(classFullName + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = inputStream.read()) != -1) {
                baos.write(ch);
            }
            resultData = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultData;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Test16 myTest16 = new Test16("我的classLoader");
        Class<?> clazz = myTest16.loadClass("jvm.shengsiyuan.Test01");
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
}
