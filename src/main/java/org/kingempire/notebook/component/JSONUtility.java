package org.kingempire.notebook.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anurag Singh
 */
@Component
public class JSONUtility {

    public void writeListOfObjectToJsonFile(String file, List<?> list) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), list);
    }

    public List<?> readListOfObjectJSONFileArray(String file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Files.readAllBytes(Paths.get(file)), new TypeReference<List<?>>() {
        });
    }

    public void writeJSONArray(String file, JSONArray array) {

        try (FileWriter fw = new FileWriter(file)) {

            fw.write(array.toJSONString());
            fw.flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public JSONArray readJSONArray(String file) {

        JSONParser jsonParser = new JSONParser();
        JSONArray array = null;

        try (FileReader reader = new FileReader(file)) {

            Object obj = jsonParser.parse(reader);

            array = (JSONArray) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
}
