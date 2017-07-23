package com.flux.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Constant {
	//1411380720005,
	public static final String mpan = "1411381210006,1411364000003,1411338400000,1411320010009,1411364313001,1411365800005,1411387200003,1411387400006,1411337500006,1411337720005,1411338010003,1610014486279,1610014486297,1610014486288,1610014486394,1610014486385,1610014486376,1610014486367,1610014486358,1620000151254,1620001012000,1610014486311,1610014484778,1610014484796,1610014484801,1610014484810,1610014484820,1610014484839,1610014484848,1610014484857,1610014484963,1610014484972,1610014484981,1610014484990,1610014485007,1610014485016,1610014485025,1610014485034,1610014485043,1610014485070,1610014485080,1610014485099,1610014485104,1610014485122,1610014485131,1610014485140,1610014485150,1610014485169,1610014485187,1610014485196,1610014485201,1610014485210,1610014485220,1610014485239,1610014485178,1610014890633,1610014730406,1610014486561,1610014730390,1610014486534,1610014486525,1610014486516,1610014486507,1610014486446,1610014486437,1610014486428,1610014486419,1610014486827,1610014486818,1610014486809,1610014486793,1610014486784,1610014486775,1610014486766,1610014486757,1610014486748,1610014486739,1610014486710,1610014484661,1610014484670,1610014484680,1610014484699,1610014484704,1610014484713,1610014484467,1610014487788,1610014484476,1610014484485,1610014487760,1610014487750,1610014487741,1610014486924";
	public static List<String> list = new ArrayList<String>(Arrays.asList(mpan.split(",")));
	public static String url = LoadProperties.getProp().getProperty("url");
	public static String surl = LoadProperties.getProp().getProperty("surl");
	public static String user_brand = LoadProperties.getProp().getProperty("brand");
	public static String email_prefix = "testemailround";
	public static String email_suffix = "@email.com";
	public static String superuser_email = LoadProperties.getProp().getProperty("email");
	public static String admin_pwd = LoadProperties.getProp().getProperty("password");
	public static String admin_token = LoadProperties.getProp().getProperty("token");
	public static String user_first_name = "test";
	public static String user_last_name = "surname";
	public static String user_date_of_birth = "19";
	public static String user_month_of_birth = "January";
	public static String user_year_of_birth = "1990";
	public static String user_contact_number = "02102412345";
	public static String js_inbound_consumer_vanity_address_attributes_building_number = "document.getElementById('inbound_consumer_vanity_address_attributes_building_number').value = '7';";
	public static String js_inbound_consumer_vanity_address_attributes_thoroughfare = "document.getElementById('inbound_consumer_vanity_address_attributes_thoroughfare').value = 'Horselydown Lane';";
	public static String js_inbound_consumer_vanity_address_attributes_locality = "document.getElementById('inbound_consumer_vanity_address_attributes_locality').value = 'LONDON';";
	public static String js_inbound_consumer_vanity_address_attributes_postcode = "document.getElementById('inbound_consumer_vanity_address_attributes_postcode').value = 'SE1 2LN';";
	public static String js_fm_county = "document.getElementById('fm-county').value = 'London';";
	public static String js_fm_country = "document.getElementById('fm-country').value = 'England';";
	
	
	public static String setupuk_path = LoadProperties.getProp().getProperty("setupuk_path");
	public static String MRA_DEL_path = LoadProperties.getProp().getProperty("MRA_DEL_path");
	public static String ssd = LoadProperties.getProp().getProperty("ssd"); 
	public static String stop_at = LoadProperties.getProp().getProperty("stop_at");
	public static String exist_mpan = LoadProperties.getProp().getProperty("mpan");
	
	
	public static String byeuk_path = LoadProperties.getProp().getProperty("byeuk_path");
	public static String meter_number = LoadProperties.getProp().getProperty("meter_number");
	public static String register_serial = LoadProperties.getProp().getProperty("register_serial");
	public static String outbound_date = LoadProperties.getProp().getProperty("outbound_date");
	public static String last_reading = LoadProperties.getProp().getProperty("last_reading");
	
	
	public static String current_mpan = "";
	public static String use_exist_mpan = LoadProperties.getProp().getProperty("use_exist_mpan");
	public static String switch_complete = "In Progress - Completed (Inactive)";
	public static final String Path_OR = "src/config/DATA.txt";
	public static final String Path_TestData = "src/dataEngine/DataEngine.xlsx";
	public static final String File_TestData = "DataEngine.xlsx";
 
	//List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID =1 ;
	public static final int Col_ActionKeyword =3 ;
 
	//List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "Test Steps";
}
