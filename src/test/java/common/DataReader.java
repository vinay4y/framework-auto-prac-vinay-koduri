package common;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;


    public class DataReader {
        YamlReader reader;
        ArrayList obj;
        // This method will read the YML file provided and get the Value based on "Key" for that "email"
        // "index" to fetch the value from the provided index.
        public DataReader(String filePath, String email)  throws FileNotFoundException,YamlException{
            reader = new YamlReader(new FileReader(filePath));
            Object object = reader.read();
            Map map = (Map) object;
            obj =(ArrayList) map.get(email);
        }
        public String getvalue_ymlfile(String key) throws   ArrayStoreException{
            Map map1 = (Map) obj.get(0);
            return map1.get(key).toString();
        }
    }


