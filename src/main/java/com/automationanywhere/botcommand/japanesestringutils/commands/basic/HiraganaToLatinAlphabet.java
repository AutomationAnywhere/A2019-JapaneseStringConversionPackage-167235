package com.automationanywhere.botcommand.japanesestringutils.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.ibm.icu.text.*;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

/**
 *
 * Converts Hiragana in the source string to Romaji.
 * Accepts one String inputs.
 * The string must be Not NULL and providing the output variable is also mandatory.
 *
 * @author Yuji Hirose
 */

@BotCommand

@CommandPkg(
		//Unique name inside a package and label to display.
		name = "HiraganaToLatinAlphabet", label = "[[HiraganaToLatinAlphabet.label]]",
		node_label = "[[HiraganaToLatinAlphabet.node_label]]", description = "[[HiraganaToLatinAlphabet.description]]", icon = "StringIcon.svg",

		//Return type information. return_type ensures only the right kind of variable is provided on the UI. 
		return_label = "[[HiraganaToLatinAlphabet.return_label]]", return_type = STRING, return_required = true)
public class HiraganaToLatinAlphabet {
	
	private static final Messages MESSAGES = MessagesFactory
			.getMessages("com.automationanywhere.botcommand.japanesestringutils.messages");

	@Execute
	public Value<String> action(
			//Idx 1 would be displayed first, with a text box for entering the value.
			@Idx(index = "1", type = TEXT)
			//UI labels.
			@Pkg(label = "[[HiraganaToLatinAlphabet.targetString.label]]")
			//Ensure that a validation error is thrown when the value is null.
			@NotEmpty
			String targetString) {
		
		//Internal validation, to disallow empty strings. No null check needed as we have NotEmpty on targetString.
		if ("".equals(targetString.trim()))
			throw new BotCommandException(MESSAGES.getString("emptyInputString", "targetString"));

		//Business logic
		Transliterator transliterator = Transliterator.getInstance("Hiragana-Latin");
		String result = transliterator.transliterate(targetString);

		//Return StringValue.
		return new StringValue(result);
	}
}
