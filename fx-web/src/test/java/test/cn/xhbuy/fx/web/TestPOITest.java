package test.cn.xhbuy.fx.web;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;


/**
 * TestPOI Tester.
 *
 * @author <Authors name>
 * @since <pre>���� 9, 2017</pre>
 * @version 1.0
 */
public class TestPOITest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: test1()
     *
     */
    //@Test
    public void testTest1() throws Exception {
        String filePath = "E:\\BaiduNetdiskDownload\\32\\【阶段11】物流BOS系统\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";
        //包装一个Excel文件对象
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
        //读取文件中第一个Sheet标签页
        HSSFSheet hssfSheet = workbook.getSheetAt(0);
        //遍历标签页中所有的行
        for (Row row : hssfSheet) {
            System.out.println();
            for (Cell cell : row) {
                String value = cell.getStringCellValue();
                System.out.print(value + " ");
            }
        }
    }


}

