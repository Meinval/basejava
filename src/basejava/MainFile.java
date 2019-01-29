package basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        printFileSystemTree("./", "");

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFileSystemTree(String patchName, String space) {
        File file = new File(patchName);
        if (file.isDirectory()) {
            space = space + "   ";
            System.out.println(space + file.getName());
            String[] list = file.list();
            if (list != null) {
                for (String name : list) {
                    printFileSystemTree(patchName + "/" + name, space);
                }
            }
        } else {
            System.out.println(space + file.getName());
        }
    }
}
