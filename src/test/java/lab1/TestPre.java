package lab1;

import org.example.Insurance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.constant.ConstantDescs.NULL;

public class TestPre {

    @DataProvider
    public Object[][] DataPro(){

        return new Object[][]{
                {20,'M',FALSE,2000},
                {35,'F',TRUE,300},
                {55,'F',TRUE,200},
                {35,'M',FALSE,500},
                {57,'M',FALSE,400},
                {10,'M',FALSE,0},
                {95,'M',TRUE,0},
                {35,'Q',FALSE,0},
                {55,'F',NULL,0}
        };
    }
    @Test(dataProvider = "DataPro")
    public void TestInsurance(int age,char gender, boolean married,int exp_output){
        Assert.assertEquals(Insurance.premium(age, gender, married),exp_output);
    }
}
