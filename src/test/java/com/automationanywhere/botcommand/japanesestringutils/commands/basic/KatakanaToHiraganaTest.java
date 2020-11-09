package com.automationanywhere.botcommand.japanesestringutils.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatakanaToHiraganaTest {
    @Test
    public void KatakanaToHiragana(){
        String validInput = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポァィゥェォャュョッ";
        String expectedOutput = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをんがぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽぁぃぅぇぉゃゅょっ";

        KatakanaToHiragana testKatakanaToHiragana = new KatakanaToHiragana();
        Value<String> result = testKatakanaToHiragana.action(validInput);

        Assert.assertEquals(result.get(), expectedOutput);
    }


    @Test(expectedExceptions = BotCommandException.class)
    public void KatakanaToHiraganaTestWithoutText() throws BotCommandException{
        String validInput = "";

        KatakanaToHiragana testKatakanaToHiragana = new KatakanaToHiragana();
        Value<String> result = testKatakanaToHiragana.action(validInput);

    }

}
