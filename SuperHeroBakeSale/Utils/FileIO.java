import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
    public String Load(String filename) {
        FileInputStream in = null;
        String returnValue;
        try {
            in = new FileInputStream(filename);

            int c;
            while ((c = in.read()) != -1) {
                returnValue += c;
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return returnValue;
    }

    public void Save(String fileName, String content)
    {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            out.write(content.getBytes());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
