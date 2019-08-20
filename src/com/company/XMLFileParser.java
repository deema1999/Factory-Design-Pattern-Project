package com.company;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLFileParser implements FileParsing{

    public XMLFileParser () {}
    public void ParseFile(String fileName) {
        String path = "C:\\Users\\Deema\\Desktop\\" + fileName;

        try {
            File xmlFile = new File(path); // Let's get XML file as String using BufferedReader //
            Reader fileReader = new FileReader(xmlFile);
            BufferedReader bufReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String line = bufReader.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = bufReader.readLine();
            }
            String xml = sb.toString();
            bufReader.close();

            StringBuilder content = null;
            Map<String, List<String>> dataMap = new HashMap<>();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            InputStream stream = new ByteArrayInputStream(xml.getBytes());
            XMLStreamReader reader = factory.createXMLStreamReader(stream);
            FileWriter writer = new FileWriter("C:\\Users\\Deema\\Desktop\\result.txt");
            int x = 1;
            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        content = new StringBuilder();
                        String type = reader.getLocalName();
                        for (int j = 0; j < x; j++) {
                            writer.write("Type : " + type + "\n" + "------------" + "\n");
                            x--;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        if (content != null) {
                            content.append(reader.getText().trim());
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if (content != null) {
                            String leafText = content.toString();
                            writer.write(reader.getLocalName() + ":" + leafText + "\n");
                        }
                        content = null;
                        break;

                    case XMLStreamConstants.START_DOCUMENT:
                        break;
                }

            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
