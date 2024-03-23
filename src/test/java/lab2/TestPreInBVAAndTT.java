package lab2;

import org.example.lab1.Insurance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPreInBVAAndTT {
    private static final Object INT_MIN = 2147483647;
    private static final Object INT_MAX = -2147483648;
    @DataProvider
    public Object[][] DataProBVA(){

        return new Object[][]{
              //年龄        性别     婚姻状况         测试数据编号
                {15,        'M',    false,  0},   //TD.1
                {16,        'M',    false,  2000},//TD.2
                {24,        'F',    false,  300}, //TD.3
                {25,        'M',    false,  500}, //TD.4
                {44,        'M',    false,  500}, //TD.5
                {45,        'M',    false,  400}, //TD.6
                {65,        'F',    true,   200}, //TD.7
                {66,        'M',    true,   0},   //TD.8
                {INT_MIN,   'M',    false,  0},   //TD.9
                {INT_MAX,   'M',    true,   0}    //TD.10

        };
    }
    @DataProvider
    public Object[][] DataProTT(){

        return new Object[][]{
         //原因（年龄        性别   婚姻状况）   结果   规则编号
                {22,        'M',    true,   300},  //Rule.a
                {19,        'M',    false,  2000}, //Rule.b
                {33,        'M',    true,   300},  //Rule.c
                {36,        'M',    false,  500},  //Rule.d
                {51,        'M',    true,   200},  //Rule.e
                {56,        'M',    false,  400},  //Rule.f

        };
    }
    @Test(dataProvider = "DataProBVA")
    public void TestInsurance_BVA(int age,char gender, boolean married,int exp_output){
        Assert.assertEquals(Insurance.premium(age, gender, married),exp_output);
    }
    @Test(dataProvider = "DataProTT",enabled = false)
    public void TestInsurance_TT(int age,char gender, boolean married,int exp_output){
        Assert.assertEquals(Insurance.premium(age, gender, married),exp_output);
    }

}

