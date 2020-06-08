package com.pourush.springjdbctemplate;

import com.pourush.springjdbctemplate.dao.EmployeeDao;
import com.pourush.springjdbctemplate.dao.EmployeeDaoWithPreparedStatment;
import com.pourush.springjdbctemplate.dto.Employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by pourush.sinha on 17/01/19.
 */
public class JdbcTemplateMainClass {

    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("file:/Users/pourush.sinha/practice_project/db_concept/applicationContext.xml");

        /*EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
        int status=dao.saveEmployee(new Employee(102,"Amit",35000));
        System.out.println(status);*/

        EmployeeDaoWithPreparedStatment employeeDaoWithPreparedStatment=(EmployeeDaoWithPreparedStatment)ctx.getBean("preparedstatmentdao");
        Boolean status2=employeeDaoWithPreparedStatment.setEmploayeePrepared(new Employee(104,"preparedStatmentDao",35000));
        System.out.println(status2);

    }


}
