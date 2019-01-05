package com.cg.payroll.Test;

import org.junit.After;
import org.junit.AfterClass;

//import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.payroll.Exceptions.AssociatedetailsNotFoundException;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.payrollutil.PayrollUtil;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;



public class PayRollServicesTest {
	
	
	@BeforeClass
	public static void setUpTestEnv() {
		PayrollServices=new PayrollServicesImpl();
	}
@Before
public void setUpTestData() {
	Associate associate1=new Associate(320000, "LAKSHMI", "Somineni", "'IT","A4", "HGFSGF4568", "lakshmi@gmail.com", new Salary(300000, 1200, 1500,9776), new BankDetails("HDFC", 434453,558936488));
	Associate associate2=new Associate(320000, "LAKSHMI", "Somineni", "'IT","A4", "HGFSGF4568", "lakshmi@gmail.com", new Salary(300000, 1200, 1500,9776), new BankDetails("HDFC", 434453,558936488));
	PayrollUtil.associates.put(associate1.getAssociateID(), associate1);
	PayrollUtil.associates.put(associate1.getAssociateID(), associate2);
	PayrollUtil.ASSOCIATIVE_ID_COUNTER=103;
}
@Test
public void testAcceptAssociateDetailsForValidData() {
	int expectedAssociateId=103;
	int actualAssociateId=PayrollServices.acceptAssociateDetails(320000, "LAKSHMI", "Somineni", "'IT","A4", "HGFSGF4568", "lakshmi@gmail.com", new Salary(300000, 1200, 1500,9776), new BankDetails("HDFC", 434453,558936488));
Assert.assertEquals(expectedAssociateId, actualAssociateId);
Assert.assertEquals(expectedAssociateId,actualAssociateId);
}


@Test(expected=AssociatedetailsNotFoundException.class)
public void testGetAssociateDataForInvalidAssociateId()throws AssociatedetailsNotFoundException) {
	payrollServices.getAssocaiteDetails(2124);
}


@Test
public void testGetAssociateDataForValidAssociateId()throws AssociatedetailsNotFoundException){
	Associate expectedAssociate=new Associate(320000, "LAKSHMI", "Somineni", "'IT","A4", "HGFSGF4568", "lakshmi@gmail.com", new Salary(300000, 1200, 1500,9776), new BankDetails("HDFC", 434453,558936488));
	Associate actualAssociate=payrollServices.getAssociateDetails(102);
	Assert.assertEquals(expectedAssociate,actualAssociate);
	
	@After
	public void tearDownTestData() {
		PayrollUtil.getASSOCIATIVE_ID_COUNTER()=100;
		PayrollUtil.associates.clear();
	}
	@AfterClass
	public static void tearDownTestEnv() {
		payrollServices=null;
	}
	
}


	


