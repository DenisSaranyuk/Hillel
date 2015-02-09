import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Created by denis on 20.10.14.
 */
public class TestFileOperation {
    @Test
    public void testCreateFile() {
        File file = new File("1.txt");
        FileOperations.createFile("1.txt");
        assertTrue("Fyi", file.exists());
    }

    @Test
    public void testDeleteFile(){
        File file = new File("1.txt");
        FileOperations.deleteFile("1.txt");
        assertTrue("Fyi", !file.exists());
    }
}
