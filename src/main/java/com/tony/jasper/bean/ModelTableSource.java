package com.tony.jasper.bean;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @Auther: tony
 * @Date: 2018/9/13
 * @Description:
 */
public class ModelTableSource {
    private JRBeanCollectionDataSource tableData;

    public JRBeanCollectionDataSource getTableData() {
        return tableData;
    }

    public void setTableData(JRBeanCollectionDataSource tableData) {
        this.tableData = tableData;
    }
}
