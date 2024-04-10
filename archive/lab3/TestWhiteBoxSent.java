package lab3;

import org.example.lab1.Insurance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestWhiteBoxSent {

    @DataProvider
    public Object[][] DataPro(){

        return new Object[][]{
                //原因（年龄        性别   婚姻状况）   结果
                {9876,        'F',    true,   0},  //
                {19,        'M',    false,  2000}, //
                {48,        'F',    true,   200},  //
        };
    }
    @Test(dataProvider = "DataPro")
    public void TestInsurance(int age,char gender, boolean married,int exp_output){
        Assert.assertEquals(Insurance.premium(age, gender, married),exp_output);
    }
}
