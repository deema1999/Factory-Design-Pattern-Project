package com.company;

public class FileParser {

public FileParser(){}
 public void getParser(String fileName,String fileType)  {
    try {
        if (fileType.equals("json")) {

            JSONFileParser p = new JSONFileParser();
            p.ParseFile(fileName);

        } else {
            if (fileType.equals("xml")) {
                XMLFileParser p = new XMLFileParser();
                p.ParseFile(fileName);

            } else {
                System.out.println("unsuitable file extension");
            }
        }
    } catch(Exception e) {
             e.printStackTrace();
         }
    }
}
