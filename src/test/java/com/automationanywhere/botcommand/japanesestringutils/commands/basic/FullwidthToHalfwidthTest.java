package com.automationanywhere.botcommand.japanesestringutils.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FullwidthToHalfwidthTest {
    @Test
    public void FullwidthToHalfwidth(){
        String validInput = "ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ１２３４５６７８９０！＃＄％＆（）＊＋，－．／：；＜＝＞？＠［＼￥］＾＿｛｜｝～。「」、・ヲァィゥェォャュョッアイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワン";
        String expectedOutput = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!#$%&()*+,-./:;<=>?@[\\¥]^_{|}~｡｢｣､･ｦｧｨｩｪｫｬｭｮｯｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ";

        FullwidthToHalfwidth testFullwidthToHalfwidth = new FullwidthToHalfwidth();
        Value<String> result = testFullwidthToHalfwidth.action(validInput);

        Assert.assertEquals(result.get(), expectedOutput);
    }


    @Test(expectedExceptions = BotCommandException.class)
    public void FullwidthToHalfwidthTestWithoutText() throws BotCommandException{
        String validInput = "";

        FullwidthToHalfwidth testFullwidthToHalfwidth = new FullwidthToHalfwidth();
        Value<String> result = testFullwidthToHalfwidth.action(validInput);
    }

}
