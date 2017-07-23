package executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import com.flux.utility.Constant;
import com.flux.utility.ExcelUtils;

import config.ActionKeywords;

public class DriverScript {
	
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static Method method[];

	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}

	public static void main(String[] args) throws Exception {

		new DriverScript();
		// Instead of hard coded Excel path, a Constant Variable is used
		String sPath = Constant.Path_TestData;

		// Here we are passing the Excel path and SheetName to connect with
		// Excel file
		// Again a Constant Variable is used in place of Excel Sheet Name
		ExcelUtils.setExcelFile(sPath, Constant.Sheet_TestSteps);

		

		// Hard coded values are used for Excel row & columns for now
		// In later chapters we will use these hard coded value much efficiently
		// This is the loop for reading the values of the column 3 (Action
		// Keyword) row by row
		for (int iRow = 1; iRow <= 9; iRow++) {
			// Constant Variable is used in place of Column number
			sActionKeyword = ExcelUtils.getCellData(iRow, Constant.Col_ActionKeyword);
			execute_Actions();
			ExcelUtils.setCellData("Pass", iRow, 4);
		}
	}

	private static void execute_Actions() throws Exception {
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().equals(sActionKeyword)) {
				method[i].invoke(actionKeywords);
				break;
			}
		}
	}
}