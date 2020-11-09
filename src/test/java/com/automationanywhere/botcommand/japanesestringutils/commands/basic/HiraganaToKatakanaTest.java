package com.automationanywhere.botcommand.japanesestringutils.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HiraganaToKatakanaTest {
    @Test
    public void HiraganaToKatakana(){
        String validInput = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをんがぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽぁぃぅぇぉゃゅょっ";
        String expectedOutput = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポァィゥェォャュョッ";

        HiraganaToKatakana testHiraganaToKatakana = new HiraganaToKatakana();
        Value<String> result = testHiraganaToKatakana.action(validInput);

        Assert.assertEquals(result.get(), expectedOutput);
    }


    @Test(expectedExceptions = BotCommandException.class)
    public void HiraganaToKatakanaTestWithoutText() throws BotCommandException{
        String validInput = "";

        HiraganaToKatakana testHiraganaToKatakana = new HiraganaToKatakana();
        Value<String> result = testHiraganaToKatakana.action(validInput);
    }

}
