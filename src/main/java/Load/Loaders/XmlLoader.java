package Load.Loaders;

import Load.Loader;
import Transform.ItemAsMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class XmlLoader extends GeneralLoader implements Loader {
    @Override
    public void load(ArrayList<ArrayList<ItemAsMap>> item, File[] dest) {
        if (checkFilesNum(item, dest)) {
            for (int i = 0; i < item.size(); i++) {
                String data = "<labTests>\n";
                for (int j = 0; j < item.get(i).size(); j++) {
                    data += "\t<labTest>\n";
                    HashMap<String, String> map = item.get(i).get(j).getParameters();
                    for (String key : map.keySet()) {
                        data += "\t\t<" + key + ">";
                        data += map.get(key);
                        data += "</" + key + ">\n";
                    }
                    data += "\t</labTest>\n";
                }
                data += "</labTests>";
                write(dest[i], data);
            }
        }
        else
            System.out.println("you need to open " + (item.size() - dest.length) + " more files");
    }
}
