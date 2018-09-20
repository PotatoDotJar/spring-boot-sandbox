package com.potatosaucevfx.springbootsandbox.service;

import com.potatosaucevfx.springbootsandbox.model.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Richard Nader Jr. <heelyskidrj@gmail.com>
 */
public class JsonService {
    
    public static ArrayList<Person> readTableData() {
        ArrayList<Person> personList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            File file = new ClassPathResource("static/data/tableData.json").getFile();
            Object obj = parser.parse(new FileReader(file));
            JSONArray array = (JSONArray) ((JSONObject) obj).get("data");
            
            Iterator<JSONArray> it = array.iterator();
            
            while(it.hasNext()) {
                Person p = new Person();
                JSONArray personDat = it.next();
                p.setName((String) personDat.get(0));
                p.setOccupation((String) personDat.get(1));
                p.setLocation((String) personDat.get(2));
                p.setExtention(Integer.parseInt((String) personDat.get(3)));
                p.setStartDate((String) personDat.get(4));
                p.setSalary((String) personDat.get(5));
                personList.add(p);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return personList;
    }
}
