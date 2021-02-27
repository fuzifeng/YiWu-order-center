package com.yiwu.order_center_server.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *
 * @author fuzifeng
 * @since 2019/11/12 11:39
 */
public class ExcelUtils {

    /**
     * 下载excel
     * @param httpServletResponse
     * @param fileName
     * @throws IOException
     */
    public static void download(HttpServletResponse httpServletResponse, String fileName, Workbook workbook) throws IOException {
        //设置文件后缀
        if (workbook instanceof HSSFWorkbook) {
            fileName = fileName + ".xls";
        } else {
            fileName = fileName + ".xlsx";
        }
        fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        httpServletResponse.setContentType("application/force-download;charset=utf-8");
        OutputStream os = httpServletResponse.getOutputStream();
        try {
            workbook.write(os);
        } finally {
            os.close();
        }
    }

    /**
     * 将对象集合转换成excel
     *
     * @param workbook XSSFWorkbook or SXSSFWorkbook or HSSFWorkbook(最大行数65535)
     * @param sheetNumber 表单序号
     * @param startRowNumber 开始的行数
     * @param objs 数据对象
     * @param clazz 对象的类
     * @param columnNames 要打印的表头(可以为空，即不打印表头)
     * @param columnFields 要打印的属性
     * @param <T>
     * @throws NoSuchFieldException
     * @throws IOException
     * @throws IllegalAccessException
     */
    public static <T> void writeObjects2Workbook(Workbook workbook, int sheetNumber, int startRowNumber, List<T> objs, Class clazz,
                                                 @Nullable String[] columnNames, String[] columnFields) throws NoSuchFieldException, IllegalAccessException {
        //校验
        if (workbook instanceof HSSFWorkbook && objs.size() > 60000) {
            throw new IllegalArgumentException("xls文件数据量不能超过60000条");
        }
        //获取要打印的表单
        Sheet sheet = workbook.getSheetAt(sheetNumber);
        //创建excel
        Row row;
        Cell cell;
        //写入表头
        if (Objects.nonNull(columnNames) && columnNames.length > 0) {
            //表头格式
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            cellStyle.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
            cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            row = sheet.createRow(startRowNumber);
            for (int i = 0; i < columnNames.length; i++) {
                cell = row.createCell(i);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(columnNames[i]);
            }
            startRowNumber = startRowNumber + 1;
        }
        //写入数据
        for (int i = 0; i < objs.size(); i++) {
            row = sheet.createRow(i + startRowNumber);
            for (int j = 0; j < columnFields.length; j++) {
                cell = row.createCell(j);
                Field field = clazz.getDeclaredField(columnFields[j]);
                field.setAccessible(true);
                cell.setCellValue(formatValue(field.get(objs.get(i))));
            }
        }
    }

    private static String formatValue(Object value) {
        if (Objects.isNull(value)) {
            return "";
        } else if (value instanceof Date) {
            return ((Date) value).toInstant().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } else {
            return value.toString();
        }
    }

    public static String getStringCellValue(XSSFCell cell) {
        if (cell == null) {
            return "";
        }
        String strCell;
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                strCell = strCell != null ? strCell.trim() : "";
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
                strCell = String.valueOf(bd);
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case XSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (StringUtils.isEmpty(strCell)) {
            return "";
        }
        return strCell;
    }

}
