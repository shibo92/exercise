package spider2.spider;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        replaceName("C:\\Users\\Administrator\\Desktop\\了 - 副本","C:\\Users\\Administrator\\Desktop\\a");
    }

    public static void replaceName(String url, String newUrl){
        File file = new File(url);
        if(file.exists() && file.isDirectory()){
            File[] childFiles = file.listFiles();
            String path = file.getAbsolutePath();
            for(File childFile : childFiles){
                if(childFile.isFile()){
                    String oldName = childFile.getName();
                    String newName = oldName;
                    if(oldName.contains("@")){
                        newName = oldName.substring(0,oldName.indexOf("@"));
                    }
                    childFile.renameTo(new File(path + "\\" + newName));
                }
            }
        }
    }

}
