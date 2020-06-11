package com.pourush.springjdbctemplate.dao;

import com.pourush.springjdbctemplate.dto.Employee;
import com.sun.tools.javac.util.Convert;
import lombok.Data;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Created by pourush.sinha on 20/01/19.
 */

@Data
public class EmployeeDaoWithPreparedStatment implements PreparedStatementCallback<Boolean> {
    private JdbcTemplate jdbcTemplate;


    public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
        return  preparedStatement.execute();

    }
    public Boolean setEmploayeePreparedStatement(Employee emploayee) throws SQLException {
        String query="insert into employee values(?,?,?)";
        PreparedStatement preparedStatement = jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setInt(1,emploayee.getId());
        preparedStatement.setString(2,emploayee.getName());
        preparedStatement.setFloat(3,emploayee.getSalary());
        return jdbcTemplate.execute(query,this);
        //return doInPreparedStatement(preparedStatement);

    }


    /*public Boolean setEmploayeePreparedStatement(final Employee emploayee) throws SQLException {
        String query="insert into employee values(?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,emploayee.getId());
                ps.setString(2,emploayee.getName());
                ps.setFloat(3,emploayee.getSalary());

                return ps.execute();

            }
        });

    }*/

    public Boolean setEmploayeePrepared(Employee emploayee) throws SQLException {
        String query="insert into employee values(?,?,?)";

        return setEmploayeePreparedStatement(emploayee);
    }

    public static void main(String[] args) {
        String textToHash = "9703380047|sai190109@gmail.com|Sai|Nadh|13.00|Foodpanda-OMPP|0.74598100 1551853916|Of2K1LnnLOB26m7bQmz7";
        MessageDigest sha512 = null;
        try {
            sha512 = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            // not possible, sha512 is part of java
        }
        String hash = null;
        if (sha512 != null) {
            sha512.update(textToHash.getBytes());
            hash = convertByteToHex(sha512.digest());
        }
        System.out.print(hash);
    }

    private static String convertByteToHex(byte data[]) {
        StringBuilder hexData = new StringBuilder();
        for (byte aData : data) {
            hexData.append(Integer.toString((aData & 0xff) + 0x100, 16).substring(1));
        }
        return hexData.toString();
    }





}
