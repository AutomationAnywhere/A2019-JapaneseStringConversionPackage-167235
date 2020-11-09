package com.automationanywhere.botcommand.japanesestringutils.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HalfwidthToFullwidthTest {
    @Test
    public void HalfwidthToFullwidth(){
        String validInput = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!#$%&()*+,-./:;<=>?@[\\¥]^_{|}~｡｢｣､･ｦｧｨｩｪｫｬｭｮｯｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ";
        String expectedOutput = "ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ１２３４５６７８９０！＃＄％＆（）＊＋，－．／：；＜＝＞？＠［＼￥］＾＿｛｜｝～。「」、・ヲァィゥェォャュョッアイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワン";

        HalfwidthToFullwidth testHalfwidthToFullwidth = new HalfwidthToFullwidth();
        Value<String> result = testHalfwidthToFullwidth.action(validInput);

        Assert.assertEquals(result.get(), expectedOutput);
    }


    @Test(expectedExceptions = BotCommandException.class)
    public void HalfwidthToFullwidthTestWithoutText() throws BotCommandException{
        String validInput = "";

        HalfwidthToFullwidth testHalfwidthToFullwidth = new HalfwidthToFullwidth();
        Value<String> result = testHalfwidthToFullwidth.action(validInput);
    }

}
