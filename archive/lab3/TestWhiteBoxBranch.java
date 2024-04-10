package lab3;

import org.example.lab1.Insurance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestWhiteBoxBranch {

    @DataProvider
    public Object[][] DataPro(){

        return new Object[][]{
                //原因（年龄        性别   婚姻状况）   结果
                {2381,      'F',    true,   0},  //
                {24,        'M',    false,  2000}, //
                {49,        'F',    true,   200},  //
                {33,        'M',    false,   500},  //
        };
    }
    @Test(dataProvider = "DataPro")
    public void TestInsurance(int age,char gender, boolean married,int exp_output){
        Assert.assertEquals(Insurance.premium(age, gender, married),exp_output);
    }
}
