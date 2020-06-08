package com.pourush.springjdbctemplate.dao;

import com.google.gson.Gson;
import com.pourush.springjdbctemplate.dto.Employee;
import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.lang.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.text.DecimalFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by pourush.sinha on 17/01/19.
 */

@Data
public class EmployeeDao {
    static String[] arr ={"deleted","created_at","labels","workshop_status","new_batch_id","discarded_reason","workshop_name","workshop_location","workshop_address"};
    static Map<String,String> map =new HashMap<>();

    static final List<String> keysToBeIgnored = Arrays.asList(arr);
    private JdbcTemplate jdbcTemplate;

    public int saveEmployee(Employee e){
        String query="insert into employee values( '"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
        return jdbcTemplate.update(query);
    }
    public int updateEmployee(Employee e){
        String query="update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }
    public int deleteEmployee(Employee e){
        String query="delete from employee where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }

    public static void main(String[] args) throws IOException {
        map.put("total","Integer");
        map.put("booking_time","Date");
        map.put("estimated_delivery_time","Date");
        map.put("last_transition_at","Date");
        map.put("hours_in_workshop","Integer");
        map.put("last_edt_change","Date");
        map.put("first_booking_time","Date");
        map.put("totalestimate","Integer");
        map.put("parent_id","String");
        map.put("item_total","Integer");
        map.put("approved_amount","Integer");
        map.put("old_batch_id","String");
        map.put("last_document_upload_at","Date");
        map.put("last_comment_at","Date");
        map.put("workshop_address","String");
        map.put("discarded_reason","String");
        map.put("workshop_id","String");
        map.put("approved_quantity","Integer");
        map.put("last_uploaded_file","String");
        map.put("vehicle_delivery_time","Date");
        map.put("mobile_number","String");
        map.put("rejection_reason","String");
        map.put("status","String");
        map.put("estimate_creator_name","String");
        map.put("estimate_creator_number","String");
        map.put("first_booking_time","Date");
        map.put("odometer_reading","Integer");
        map.put("total_estimate_raised","Integer");
        map.put("estimated_delivery_time","Date");
        map.put("total_approved_estimate_amount","Integer");
        map.put("total_ola_approved_amount","Integer");
        map.put("policy_start_date","Date");
        map.put("estimate_key","String");
        map.put("car_maker","String");
        map.put("time_of_loss","Date");
        map.put("driver_license_validity","Date");
        map.put("obd_odometer_reading","String");
        map.put("part_charge","Integer");
        map.put("assignee","String");
        map.put("rsa_driver_mobile_number","String");
        map.put("last_comment_by_workshop","String");
        map.put("rsa_driver_name","String");
        map.put("rsa_vehicle_number","String");
        map.put("car_model","String");
        map.put("service_rating","Integer");
        map.put("surveyor_mobile_number","String");
        map.put("claim_number","String");
        map.put("surveyor_name","String");
        map.put("description","String");


        String csvFile = "/Users/pourush.sinha/Desktop/table.csv";
        BufferedReader br = null;
        File file = new File("/Users/pourush.sinha/Desktop/report.csv");
        BufferedWriter output = null;
        output = new BufferedWriter(new FileWriter(file));
        StringBuilder stringBuilder= new StringBuilder();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    csvFile));
            String line = reader.readLine();
            int totalDiff = 0;
            int count=0;
            while (line != null) {
                Boolean isBool =false;
                StringBuilder stringBuilder1=new StringBuilder();
                count++;
                if(count !=1) {
                    //System.out.println(StringUtils.ordinalIndexOf(line.replace("\"\"", "\""), ",", 3));
                    String  str =line.replace("\"\"", "\"");
                    String ticket = str.substring(StringUtils.ordinalIndexOf(str, ",", 1)+1,StringUtils.ordinalIndexOf(str, ",", 2));
                    String table = str.substring(StringUtils.ordinalIndexOf(str, ",", 2)+1,StringUtils.ordinalIndexOf(str, ",", 3));
                    int startIndex =StringUtils.ordinalIndexOf(str, ",", 3);
                   // System.out.println(startIndex);
                   // System.out.println(str);
                   // System.out.println(str.substring(startIndex+1,str.length() -1));
                    str =str.substring(startIndex+1,str.length() -1);
                   // System.out.println("\"\"");
                   // System.out.println(str);
                    if(!str.equals("\"\"")) {
                        //Gson gson= new Gson();
                       ///Map<String,Object> map= gson.fromJson(str.replace("\"{", "{"), Map.class);
                        JSONObject objArray = new JSONObject(str.replace("\"{", "{"));
                        Iterator itr =objArray.keys();


                        while (itr.hasNext()){
                            String val =(String)itr.next();
                            if(!keysToBeIgnored.contains(val)) {
                                JSONObject jsonObject = (JSONObject)objArray.get(val);
                               // System.out.println(val+" "+jsonObject);
                                Map<String,Object> map1 = parseData(map.get(val),jsonObject.get("old"),jsonObject.get("new"));
                                if(isBool==false && !(boolean)map1.get("diff")){
                                    isBool=true;
                                }
                                if(!(boolean)map1.get("diff")){
                                    stringBuilder1.append(",,"+val + "," + map1.get("old") + "," + map1.get("new") + "\n");
                                }


                            }


                        }

                        /*System.out.println(obj);
                        JSONArray arr = obj.getJSONArray();
*/
                        // typecasting obj to JSONObject
                       // JSONObject jo = (JSONObject) obj;
                        // read next line

                    }
                    if(isBool){
                        totalDiff++;
                        System.out.println(table+","+ticket+",,,\n");
                        System.out.println(stringBuilder1.toString());
                        stringBuilder.append(table+","+ticket+",column,Oldata,NewData\n");
                        stringBuilder.append(stringBuilder1.toString());


                    }

                }

                line = reader.readLine();

            }
            output.write(stringBuilder.toString());
            System.out.println(totalDiff);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    static  Map<String,Object> parseData(String dataType ,Object oldObject ,Object newObject) throws ParseException {
        Map<String,Object> val =new HashMap<>();
        final double THRESHOLD = .01;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        switch (dataType){

            case "Integer" :
                if(oldObject.toString()=="null" && newObject.toString() != "null" ||
                        oldObject.toString()!="null" && newObject.toString() == "null"  ){
                    val.put("old",oldObject.toString());
                    val.put("new",newObject.toString());
                    val.put("diff",false);
                    return val;
                }
                double oldOb = Double.parseDouble(oldObject.toString());
                double newObj = Double.parseDouble(newObject.toString());
                val.put("old",oldOb);
                val.put("new",newObj);
                val.put("diff",Math.abs(oldOb - newObj) < THRESHOLD);
                return val;
            case "Date" :
                if(oldObject.toString()=="null" && newObject.toString() != "null" ||
                        oldObject.toString()!="null" && newObject.toString() == "null"  ) {
                    val.put("old", oldObject.toString());
                    val.put("new", newObject.toString());
                    val.put("diff", false);
                    return val;
                }
                DateTime oldTimeObject = DateTime.parse(oldObject.toString(), org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
                DateTime newTimeObject = new  DateTime(newObject.toString() , DateTimeZone.UTC );
                val.put("old",oldTimeObject);
                val.put("new",newTimeObject);
                val.put("diff",oldTimeObject == newTimeObject);
                return val;
            case "String" :
                String newString =((String)newObject.toString()).trim();
                String oldString =((String)oldObject.toString()).trim();

                val.put("old",oldString);
                val.put("new",newString);
                val.put("diff",(newString.equals(oldString)));
                return val;
            default:
                return null;
        }

    }
}
