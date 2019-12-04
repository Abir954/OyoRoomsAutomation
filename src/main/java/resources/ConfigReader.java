package resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    String result = "";
    InputStream inputStream;
    String propValue=null;

    public String getPropValues(String value) throws IOException {
        try {
            inputStream = new FileInputStream("src\\main\\java\\resources\\TestData.properties");
            Properties prop = new Properties();
            String propFileName = "TestData.properties";
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            propValue = prop.getProperty(value);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return propValue;
    }
}
