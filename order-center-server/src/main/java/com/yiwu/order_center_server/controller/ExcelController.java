package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.dto.ExcelData;
import com.yiwu.order_center_server.dto.ExcelData2;
import com.yiwu.order_center_server.utils.ExcelUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/excel")
public class ExcelController {


    @PostMapping("/readExcelData")
    public List<ExcelData> uploadThirdOrderFile(@RequestParam("file") MultipartFile file,
                                     HttpServletRequest request) {
        List<ExcelData> detailList = new ArrayList<>();
        InputStream is = null;
        try {
            is = file.getInputStream();
            XSSFWorkbook wb = new XSSFWorkbook(is);
            XSSFSheet sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
			/*if (rowNum > 100) {
				throw new Exception("数据不能超过100条");
			} else if (rowNum <= 0) {
				throw new Exception("数据不能小于0条");
			}*/
            for (int i = 2; i <= rowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                String area = ExcelUtils.getStringCellValue(row.getCell(1));
                String unit = ExcelUtils.getStringCellValue(row.getCell(2));
                String name = ExcelUtils.getStringCellValue(row.getCell(3));
                String result = ExcelUtils.getStringCellValue(row.getCell(4));
                ExcelData data = new ExcelData();
                data.setRegion(area.trim());
                data.setName(name.trim());
                data.setCompany(unit.trim());
                data.setResult(result.trim());

                detailList.add(data);
            }
        } catch (IOException e) {
//            LOGGER.error("order upload analysisFileToList error:{}", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
//                    LOGGER.error("order upload analysisFileToList error:{}", e);
                }
            }
        }
//        return Resp.success(detailList);
        return detailList;
    }

    @PostMapping("/readExcelData2")
    public Resp uploadThirdOrderFile2(@RequestParam("file") MultipartFile file,
                                     HttpServletRequest request) {
        List<ExcelData2> list = new ArrayList<>();
        List<String> sss = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        InputStream is = null;
        try {
            is = file.getInputStream();
            XSSFWorkbook wb = new XSSFWorkbook(is);
            XSSFSheet sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 2; i <= rowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                String area = ExcelUtils.getStringCellValue(row.getCell(1));
                String unit = ExcelUtils.getStringCellValue(row.getCell(2));
                if (map.containsKey(area)) {
                    map.get(area).add(unit.trim());
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(unit.replaceAll(" ", ""));
                    map.put(area, set);
                    sss.add(area);
                }
            }
        } catch (IOException e) {
//            LOGGER.error("order upload analysisFileToList error:{}", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
//                    LOGGER.error("order upload analysisFileToList error:{}", e);
                }
            }
        }
        for (String a : sss) {
            ExcelData2 e = new ExcelData2();
            e.setLabel(a);
            e.setValue(a);
            Set<String> set = map.get(a);
            List<ExcelData2> child = new ArrayList<>();
            for (String s : set) {
                ExcelData2 re = new ExcelData2();
                re.setValue(s);
                re.setLabel(s);
                child.add(re);
            }
            e.setChildren(child);
            list.add(e);
        }

        return Resp.success(list);
    }
}
