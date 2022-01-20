package practice2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Customer {
	@Test(dataProvider = "dataProviderCapital1")
	public void createOrganization (String a,String b, int index) {
		System.out.println("State:"+a+" Capital1: "+b+" Index:"+index);
	}
	@DataProvider
	public Object[][] dataProviderCapital(){
		Object[][]objArr = new Object[5][2];
		objArr[0][0] = "Karnataka";
		objArr[0][1] = "Bangalore";
		objArr[1][0] = "Maharashtra";
		objArr[1][1] = "Mumbai";
		
		objArr[2][0] = "Punjab";
		objArr[2][1] = "Amritsar";
		objArr[3][0] = "West Bengal";
		objArr[3][1] = "Kolkata";
		objArr[4][0] = "Tamil Nadu";
		objArr[4][1] = "Karnataka";
		return objArr;		
	}
	
}