package com.company;


import com.google.gson.GsonBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JSONFileParser implements FileParsing {

    public JSONFileParser (){}
    public void ParseFile(String fileName) {

        JSONParser parser = new JSONParser();
        String json = "";
        String j = "";
        try {
            String path = "C:\\Users\\Deema\\Desktop\\"+fileName;
            json = new String ( Files.readAllBytes( Paths.get(path) ) );
            GsonBuilder builder = new GsonBuilder();
            ObjectMapper oMapper = new ObjectMapper();
            Object L = builder.create().fromJson(json, Object.class);

            Map<String, Object> map = oMapper.convertValue(L,Map.class);
            FileWriter writer = new FileWriter("C:\\Users\\Deema\\Desktop\\result.txt");
           for (Map.Entry<String, Object> entry : map.entrySet()) {

               writer.write("Type" + " : " + entry.getKey() + "\n" + "-------------" + "\n" + entry.getValue().toString().replaceAll("\\{", "\n").replaceAll("\\}", "\n")
                       .replaceAll("\\,", "\n").replaceAll("\\=", ":")
               );
           }
           writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
