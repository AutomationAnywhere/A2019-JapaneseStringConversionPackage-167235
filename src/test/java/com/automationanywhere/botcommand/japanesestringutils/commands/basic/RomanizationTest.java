package com.automationanywhere.botcommand.japanesestringutils.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RomanizationTest{
    @Test
    public void Romanization(){
        String validInput = "あいうえおかきくけこがぎぐげごさしすせそざじずぜぞたちつてとだぢづでどなにぬねのはひふへほばびぶべぼぱぴぷぺぽまみむめもやゆよらりるれろわをんぁぃぅぇぉきゃきぃきゅきぇきょくぁくぃくぅくぇくぉぎゃぎぃぎゅぎぇぎょぐぁぐぃぐぅぐぇぐぉしゃしぃしゅしぇしょすぁすぃすぅすぇすぉじゃじぃじゅじぇじょちゃちぃちゅちぇちょてゃてぃてゅてぇてょとぁとぃとぅとぇとぉぢゃぢぃぢゅぢぇぢょでゃでぃでゅでぇでょどぁどぃどぅどぇどぉにゃにぃにゅにぇにょひゃひぃひゅひぇひょふぁふぃふぅふぇふぉびゃびぃびゅびぇびょぴゃぴぃぴゅぴぇぴょみゃみぃみゅみぇみょりゃりぃりゅりぇりょうぁうぃ";
        String expectedOutput = "aiueokakikukekogagigugegosashisusesozajizuzezotachitsutetodadjidzudedonaninunenohahifuhehobabibubebopapipupepomamimumemoyayuyorarirurerowawon~a~i~u~e~okyakyikyukyekyoku~aku~iku~uku~eku~ogyagyigyugyegyogu~agu~igu~ugu~egu~oshashi~ishusheshosu~asu~isu~usu~esu~ojaji~ijujejochachi~ichuchechote~yatite~yute~ete~yoto~ato~ito~uto~eto~odjadji~idjudjedjode~yadide~yude~ede~yodo~ado~ido~udo~edo~onyanyinyunyenyohyahyihyuhyehyofafifu~ufefobyabyibyubyebyopyapyipyupyepyomyamyimyumyemyoryaryiryuryeryou~au~i";

        HiraganaToLatinAlphabet testRomanization = new HiraganaToLatinAlphabet();
        Value<String> result = testRomanization.action(validInput);

        Assert.assertEquals(result.get(), expectedOutput);
    }


    @Test(expectedExceptions = BotCommandException.class)
    public void RomanizationTestWithoutText() throws BotCommandException{
        String validInput = "";
        HiraganaToLatinAlphabet testRomanization = new HiraganaToLatinAlphabet();
        Value<String> result = testRomanization.action(validInput);
    }

}
