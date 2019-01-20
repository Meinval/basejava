package basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * gkislin
 * 21.07.2016
 */
public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        checkForDIrAndPrint("./");

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void checkForDIrAndPrint(String patchName) {
        File file = new File(patchName);
        if (file.isDirectory()) {
            System.out.println(file.getName() + " is directory=true");
            String[] list = file.list();
            if (list != null) {
                for (String name : list) {
                    checkForDIrAndPrint(patchName + "/" + name);
                }
            }
        } else {
            System.out.println(file.getName() + " is directory=false");
        }
    }
}
