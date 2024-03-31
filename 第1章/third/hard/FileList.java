import java.io.File;
import java.util.Objects;

/**
 * 1.3.43
 * 递归打印文件夹下的文件名及子文件夹下的文件名
 */
public class FileList {
    public static void main(String[] args) {
        String filename = "第1章";
        File file = new File(filename);
        Queue<File> queue = new Queue<>();
        for (File f : Objects.requireNonNull(file.listFiles())) {
            queue.enqueue(f);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            File f = queue.dequeue();
            if (!f.isDirectory()) {
                cnt++;
                System.out.println(f.getName());
            } else {
                for (File f1 : Objects.requireNonNull(f.listFiles())) {
                    queue.enqueue(f1);
                }
            }
        }
        System.out.println(filename + "下共有: " + cnt + "个文件");
    }
}
