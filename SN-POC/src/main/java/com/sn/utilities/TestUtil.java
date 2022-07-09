package com.sn.utilities;

import java.util.ArrayList;

public class TestUtil
{
	
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel(String Sheetname)
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		try 
		{
			//reader=new Xls_Reader("E:\\InhouseProjectSN\\SN-POC\\src\\main\\java\\com\\sn\\testData\\Data.xlsx");
             reader=new Xls_Reader("E:\\InhouseProjectSN\\SN-POC\\src\\main\\java\\com\\sn\\testData\\Data1.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int rowNum=2;rowNum<=reader.getRowCount(Sheetname);rowNum++)
		{
			if(Sheetname.equals("Describeissue") )
			{
			String Description=reader.getCellData("Describeissue","Description",rowNum);
			System.out.println(Description);
			
			Object ob[]= {Description};
			myData.add(ob);
			}
			else
			{
			String Caller=reader.getCellData("ChildIncidentData","Caller",rowNum);
			System.out.println(Caller);
			String Shortdescription=reader.getCellData("ChildIncidentData","Shortdescription",rowNum);
			System.out.println(Shortdescription);
			String Childcaller=reader.getCellData("ChildIncidentData","Childcaller",rowNum);
			System.out.println(Childcaller);
			String ChildShortdescription=reader.getCellData("IncidentData","childshortdescr",rowNum);
			System.out.println(ChildShortdescription);
			
			Object ob2[]= {Caller,Shortdescription,Childcaller, ChildShortdescription};
			myData.add(ob2);
			}
		}
		return myData;
		
	}
	

}