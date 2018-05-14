package com.lianbi.core.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelDate {

	public static List<String[]> getAllExcelData(InputStream is,String fileName) {
		List<String[]> list = new ArrayList<String[]>();
		try {
			Workbook book = null;
			boolean isExcel2003 = true;
			if (isExcel2007(fileName)) {
				isExcel2003 = false;
			}
			if (isExcel2003) {
				book = new HSSFWorkbook(is);
			} else {
			    book = new XSSFWorkbook(is);
			}

			Sheet sheet = book.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			int cells = 0;
			if (rows >= 1 && sheet.getRow(0) != null) {
				cells = sheet.getRow(0).getPhysicalNumberOfCells();
			}

			for (int i = 1; i < rows; i++) {//从第二行开始倒入  第一行是表名称 第二行是表头
				Row row = sheet.getRow(i);
				if (row == null) {
					continue;
				}
				String[] str = new String[cells];
				for (int j = 0; j < cells; j++) {
					Cell cell = row.getCell(j);

					String cellValue = "";

					if (null != cell) {
						// 以下是判断数据的类型
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC: // 数字
							cellValue = cell.getNumericCellValue() + "";
							break;

						case HSSFCell.CELL_TYPE_STRING: // 字符串
							cellValue = cell.getStringCellValue();
							break;

						case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
							cellValue = cell.getBooleanCellValue() + "";
							break;

						case HSSFCell.CELL_TYPE_FORMULA: // 公式
							cellValue = cell.getCellFormula() + "";
							break;

						case HSSFCell.CELL_TYPE_BLANK: // 空值
							cellValue = "";
							break;
						case HSSFCell.CELL_TYPE_ERROR: // 故障
							cellValue = "非法字符";
							break;
						default:
							cellValue = "未知类型";
							break;
						}
					}
					str[j] = cellValue;
				}
				list.add(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	private static boolean isExcel2007(String fileName) {
//		return fileName.matches("^.+\\.(?i)(xlsx)$");
		return "xlsx".equals(fileName);
	}
}
