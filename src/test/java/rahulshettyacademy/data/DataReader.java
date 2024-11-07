package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

    public void getJsonDataToMap() throws IOException {

            // Read json to String
            String jsonContent = FileUtils.readFileToString(
                new File(System.getProperty("user.dir") + "\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json"),
                "UTF-8" // Specify the encoding
            );

            // String to List of HashMap using Jackson Databind
            ObjectMapper mapper = new ObjectMapper();
            List<HashMap<String, String>> list = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});


    }
}
