package com.automationanywhere.botcommand.japanesestringutils.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.botcommand.japanesestringutils.commands.basic.Normalize;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NomalizeTest {

    @Test(expectedExceptions = BotCommandException.class)
    public void NomalizeTestWithoutText() throws BotCommandException{
        String validInput = "";

        Normalize testNormalize = new Normalize();
        String type = null;
        Value<String> result = testNormalize.action(validInput, type);
    }

    @Test
    public void NomalizeTestWithoutOption(){
        String validInput = "１２３４５";
        String expectedOutput = "12345";

        Normalize testNormalize = new Normalize();
        String type = null;
        Value<String> result = testNormalize.action(validInput, type);

        Assert.assertEquals(result.get(), expectedOutput);
    }

    @Test
    public void NomalizeTestWithNFD(){
        String validInput = "ヾゞ≠⊄⊅∉∦≢ÅがぎぐげござじずぜぞだぢづでどばぱびぴぶぷべぺぼぽゔガギグゲゴザジズゼゾダヂヅデドバパビピブプベペボポヴЁЙёйヷヸヹヺǍǎǐḾḿǸǹǑǒǔǖǘǚǜÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝàáâãäåçèéêëìíîïñòóôõöùúûüýÿĀĪŪĒŌāīūēōĄĽŚŠŞŤŹŽŻąľśšşťźžżŔĂĹĆČĘĚĎŃŇŐŘŮŰŢŕăĺćčęěďńňőřůűţĈĜĤĴŜŬĉĝĥĵŝŭǽὰάὲέ侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";
        String expectedOutput = "ヾゞ≠⊄⊅∉∦≢ÅがぎぐげござじずぜぞだぢづでどばぱびぴぶぷべぺぼぽゔガギグゲゴザジズゼゾダヂヅデドバパビピブプベペボポヴЁЙёйヷヸヹヺǍǎǐḾḿǸǹǑǒǔǖǘǚǜÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝàáâãäåçèéêëìíîïñòóôõöùúûüýÿĀĪŪĒŌāīūēōĄĽŚŠŞŤŹŽŻąľśšşťźžżŔĂĹĆČĘĚĎŃŇŐŘŮŰŢŕăĺćčęěďńňőřůűţĈĜĤĴŜŬĉĝĥĵŝŭǽὰάὲέ侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";

        Normalize testNormalize = new Normalize();
        String type = "NFD";
        Value<String> result = testNormalize.action(validInput, type);

        Assert.assertEquals(result.get(), expectedOutput);
    }

    //@Test
    public void NomalizeTestWithNFKDBad(){
        String validInput = "‾｡｢｣､･ｦｧｨｩｪｫｬｭｮｯｰｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝﾞﾟ，．：；？！゛゜´｀¨＾￣＿ヾゞ／｜…‥（）［］｛｝＋＝≠＜＞″℃￥＄％＃＆＊＠＇＂－ヿゟ⊄⊅∉∦｟｠∬≢Å０１２３４５６７８９ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺℵℏ㏋ℓａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚがぎぐげござじずぜぞだぢづでどばぱびぴぶぷべぺぼぽゔガギグゲゴザジズゼゾダヂヅデドバパビピブプベペボポヴЁЙёйヷヸヹヺ⅓⅔⅕㉑㉒㉓㉔㉕㉖㉗㉘㉙㉚㉛㉜㉝㉞㉟㊱㊲㊳㊴㊵㊶㊷㊸㊹㊺㊻㊼㊽㊾㊿‼⁇⁈⁉ǍǎǐḾḿǸǹǑǒǔǖǘǚǜª¯²³¸¹º¼½¾ÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝàáâãäåçèéêëìíîïñòóôõöùúûüýÿĀĪŪĒŌāīūēōĄ˘ĽŚŠŞŤŹŽŻą˛ľśšşťź˝žżŔĂĹĆČĘĚĎŃŇŐŘŮŰŢŕăĺćčęěďńňőřůűţ˙ĈĜĤĴŜŬĉĝĥĵŝŭǽὰάὲέⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹⅺⅻⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩ㋐㋑㋒㋓㋔㋕㋖㋗㋘㋙㋚㋛㋜㋝㋞㋟㋠㋡㋢㋣㋺㋩㋥㋭㋬①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅪ㍉㌔㌢㍍㌘㌧㌃㌶㍑㍗㌍㌦㌣㌫㍊㌻㎜㎝㎞㎎㎏㏄㎡Ⅻ㍻№㏍℡㊤㊥㊦㊧㊨㈱㈲㈹㍾㍽㍼侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";
        String expectedOutput = "̅。「」、・ヲァィゥェォャュョッーアイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワン゙゚,.:;?!゙゚́`̈^̄_ヾゞ/|.....()[]{}+=≠<>′′°C¥$%#&*@'\"-コトより⊄⊅∉∦⦅⦆∫∫≢Å0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZאħHPlabcdefghijklmnopqrstuvwxyzがぎぐげござじずぜぞだぢづでどばぱびぴぶぷべぺぼぽゔガギグゲゴザジズゼゾダヂヅデドバパビピブプベペボポヴЁЙёйヷヸヹヺ1⁄32⁄31⁄5212223242526272829303132333435363738394041424344454647484950!!???!!?ǍǎǐḾḿǸǹǑǒǔǖǘǚǜā23̧1o1⁄41⁄23⁄4ÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝàáâãäåçèéêëìíîïñòóôõöùúûüýÿĀĪŪĒŌāīūēōĄ̆ĽŚŠŞŤŹŽŻą̨ľśšşťź̋žżŔĂĹĆČĘĚĎŃŇŐŘŮŰŢŕăĺćčęěďńňőřůűţ̇ĈĜĤĴŜŬĉĝĥĵŝŭǽὰάὲέiiiiiiivvviviiviiiixxxixiiabcdefghijklmnopqrstuvwxyzアイウエオカキクケコサシスセソタチツテトロハニホヘ1234567891011121314151617181920IIIIIIIVVVIVIIVIIIIXXXIミリキロセンチメートルグラムトンアールヘクタールリットルワットカロリードルセントパーセントミリバールページmmcmkmmgkgccm2XII平成NoKKTEL上中下左右(株)(有)(代)明治大正昭和侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";

        Normalize testNormalize = new Normalize();
        String type = "NFKD";
        Value<String> result = testNormalize.action(validInput, type);

        Assert.assertEquals(result.get().trim(), expectedOutput);
    }

    @Test
    public void NomalizeTestWithNFKD(){
        String validInput = "‾｡｢｣､･ｦｧｨｩｪｫｬｭｮｯｰｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝﾞﾟ，．：；？！゛゜´｀¨＾￣＿ヾゞ／｜…‥（）［］｛｝＋＝≠＜＞″℃￥＄％＃＆＊＠＇＂－ヿゟ⊄⊅∉∦｟｠∬≢Å０１２３４５６７８９ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺℵℏ㏋ℓａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚがぎぐげござじずぜぞだぢづでどばぱびぴぶぷべぺぼぽゔガギグゲゴザジズゼゾダヂヅデドバパビピブプベペボポヴЁЙёйヷヸヹヺ⅓⅔⅕㉑㉒㉓㉔㉕㉖㉗㉘㉙㉚㉛㉜㉝㉞㉟㊱㊲㊳㊴㊵㊶㊷㊸㊹㊺㊻㊼㊽㊾㊿‼⁇⁈⁉ǍǎǐḾḿǸǹǑǒǔǖǘǚǜª¯²³¸¹º¼½¾ÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝàáâãäåçèéêëìíîïñòóôõöùúûüýÿĀĪŪĒŌāīūēōĄ˘ĽŚŠŞŤŹŽŻą˛ľśšşťź˝žżŔĂĹĆČĘĚĎŃŇŐŘŮŰŢŕăĺćčęěďńňőřůűţ˙ĈĜĤĴŜŬĉĝĥĵŝŭǽὰάὲέⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹⅺⅻⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩ㋐㋑㋒㋓㋔㋕㋖㋗㋘㋙㋚㋛㋜㋝㋞㋟㋠㋡㋢㋣㋺㋩㋥㋭㋬①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅪ㍉㌔㌢㍍㌘㌧㌃㌶㍑㍗㌍㌦㌣㌫㍊㌻㎜㎝㎞㎎㎏㏄㎡Ⅻ㍻№㏍℡㊤㊥㊦㊧㊨㈱㈲㈹㍾㍽㍼侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";
        String expectedOutput = "̅。「」、・ヲァィゥェォャュョッーアイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワン゙゚,.:;?! ゙ ゚ ́` ̈^ ̄_ヾゞ/|.....()[]{}+=≠<>′′°C¥$%#&*@'\"-コトより⊄⊅∉∦⦅⦆∫∫≢Å0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZאħHPlabcdefghijklmnopqrstuvwxyzがぎぐげござじずぜぞだぢづでどばぱびぴぶぷべぺぼぽゔガギグゲゴザジズゼゾダヂヅデドバパビピブプベペボポヴЁЙёйヷヸヹヺ1⁄32⁄31⁄5212223242526272829303132333435363738394041424344454647484950!!???!!?ǍǎǐḾḿǸǹǑǒǔǖǘǚǜa ̄23 ̧1o1⁄41⁄23⁄4ÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝàáâãäåçèéêëìíîïñòóôõöùúûüýÿĀĪŪĒŌāīūēōĄ ̆ĽŚŠŞŤŹŽŻą ̨ľśšşťź ̋žżŔĂĹĆČĘĚĎŃŇŐŘŮŰŢŕăĺćčęěďńňőřůűţ ̇ĈĜĤĴŜŬĉĝĥĵŝŭǽὰάὲέiiiiiiivvviviiviiiixxxixiiabcdefghijklmnopqrstuvwxyzアイウエオカキクケコサシスセソタチツテトロハニホヘ1234567891011121314151617181920IIIIIIIVVVIVIIVIIIIXXXIミリキロセンチメートルグラムトンアールヘクタールリットルワットカロリードルセントパーセントミリバールページmmcmkmmgkgccm2XII平成NoKKTEL上中下左右(株)(有)(代)明治大正昭和侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";

        Normalize testNormalize = new Normalize();
        String type = "NFKD";
        Value<String> result = testNormalize.action(validInput, type);

        Assert.assertEquals(result.get().trim(), expectedOutput);
    }

    @Test
    public void NomalizeTestWithNFC(){
        String validInput = "Åάέ侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";
        String expectedOutput = "Åάέ侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";

        Normalize testNormalize = new Normalize();
        String type = "NFC";
        Value<String> result = testNormalize.action(validInput, type);

        Assert.assertEquals(result.get().trim(), expectedOutput);
    }

    @Test
    public void NomalizeTestWithNFKC(){
        String validInput = "‾｡｢｣､･ｦｧｨｩｪｫｬｭｮｯｰｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝﾞﾟ，．：；？！｀＾／｜…‥（）［］｛｝＋＝＜＞″℃￥＄％＃＆＊＠＇＂－ヿゟ｟｠∬Å０１２３４５６７８９ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺℵℏ㏋ℓａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ⅓⅔⅕㉑㉒㉓㉔㉕㉖㉗㉘㉙㉚㉛㉜㉝㉞㉟㊱㊲㊳㊴㊵㊶㊷㊸㊹㊺㊻㊼㊽㊾㊿‼⁇⁈⁉ª²³¸¹º¼½¾˘˛˝˙άέⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹⅺⅻⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩ㋐㋑㋒㋓㋔㋕㋖㋗㋘㋙㋚㋛㋜㋝㋞㋟㋠㋡㋢㋣㋺㋩㋥㋭㋬①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅪ㍉㌔㌢㍍㌘㌧㌃㌶㍑㍗㌍㌦㌣㌫㍊㌻㎜㎝㎞㎎㎏㏄㎡Ⅻ㍻№㏍℡㊤㊥㊦㊧㊨㈱㈲㈹㍾㍽㍼侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";
        String expectedOutput = "̅。「」、・ヲァィゥェォャュョッーアイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワン゙゚,.:;?!`^/|.....()[]{}+=<>′′°C¥$%#&*@'\"-コトより⦅⦆∫∫Å0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZאħHPlabcdefghijklmnopqrstuvwxyz1⁄32⁄31⁄5212223242526272829303132333435363738394041424344454647484950!!???!!?a23 ̧1o1⁄41⁄23⁄4 ̆ ̨ ̋ ̇άέiiiiiiivvviviiviiiixxxixiiabcdefghijklmnopqrstuvwxyzアイウエオカキクケコサシスセソタチツテトロハニホヘ1234567891011121314151617181920IIIIIIIVVVIVIIVIIIIXXXIミリキロセンチメートルグラムトンアールヘクタールリットルワットカロリードルセントパーセントミリバールページmmcmkmmgkgccm2XII平成NoKKTEL上中下左右(株)(有)(代)明治大正昭和侮僧免勉勤卑喝嘆器塚塀墨層屮廊悔慨憎懲敏既暑朗梅欄殺海渚漢煮凞猪琢碑社祉祈祐祖祝神祥禍禎福穀突節練繁署者臭著虜褐視諸謁謹賓贈逸都隆難響頻類爫縉艹艹蘒辶";

        Normalize testNormalize = new Normalize();
        String type = "NFKC";
        Value<String> result = testNormalize.action(validInput, type);

        Assert.assertEquals(result.get().trim(), expectedOutput);
    }

}
