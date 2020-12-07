package com.yiwu.order_center_server.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ExcelData2 {
    private String value;
    private String label;
    private List<ExcelData2> children;
}
