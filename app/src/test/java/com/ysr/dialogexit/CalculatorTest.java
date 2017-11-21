package com.ysr.dialogexit;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * @author yangshirong
 * @data 2017/11/21.
 * 邮箱 yangshirong@log56.com
 */
public class CalculatorTest {
    @Test
    public void add() throws Exception {
        Calculator calculator = new Calculator();
        int sum = calculator.add(1, 2);
        assertEquals(3, sum);
    }

}