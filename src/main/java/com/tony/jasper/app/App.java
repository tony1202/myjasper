package com.tony.jasper.app;

import com.tony.jasper.bean.Fields;
import com.tony.jasper.bean.ModelTableSource;
import com.tony.jasper.bean.Student;
import com.tony.jasper.jdbc.MysqlJDBC;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {

    public static void test1(){
        String jasperPath = App.class.getResource("/jasper/sql.jasper").getPath();
        Connection connection = MysqlJDBC.getConnection();
        String outPath = "J:/sql.pdf";
        Map<String,Object> params = new HashMap<>();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, params, connection);
            JasperExportManager.exportReportToPdfFile(jasperPrint,outPath);
        } catch (JRException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void test2(){
        String jasperPath = App.class.getResource("/jasper/table.jasper").getPath();
        String outPath = "J:/table.pdf";
        Map<String,Object> params = new HashMap<>();
        List<Fields> list = new ArrayList<>();
        List<Student> students = new ArrayList<Student>(){{
            add(new Student(1,"tony"));
            add(new Student(2,"grace"));
        }};

        params.put("aa","student");
        params.put("bb",new JRBeanCollectionDataSource(students));
        for (int i=0;i<10;i++){
            Fields fields = null;
            if (i!=6){

                fields = new Fields("field"+i,"field"+i,"field"+i,"field"+i);
            }else {
                fields = new Fields("小美","tony","grace","丽丽");
            }
            list.add(fields);
        }
        ModelTableSource mts = new ModelTableSource();
        mts.setTableData(new JRBeanCollectionDataSource(list));
        List<ModelTableSource> lmts = new ArrayList<>();
        lmts.add(mts);
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, params,new JRBeanCollectionDataSource(lmts));
            JasperExportManager.exportReportToPdfFile(jasperPrint,outPath);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test2();
    }
}
