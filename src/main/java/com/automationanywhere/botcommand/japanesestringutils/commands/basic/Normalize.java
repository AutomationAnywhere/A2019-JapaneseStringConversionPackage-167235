package com.automationanywhere.botcommand.japanesestringutils.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.AttributeType;

import java.text.Normalizer;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

/**
 *
 * Unify variations in Unicode text notation.
 * Accepts one String inputs.
 * The string must be Not NULL and providing the output variable is also mandatory.
 *
 * @author Yuji Hirose
 */

@BotCommand

@CommandPkg(
		//Unique name inside a package and label to display.
		name = "Normalize", label = "[[Normalize.label]]",
		node_label = "[[Normalize.node_label]]", description = "[[Normalize.description]]", icon = "StringIcon.svg",

		//Return type information. return_type ensures only the right kind of variable is provided on the UI. 
		return_label = "[[Normalize.return_label]]", return_type = STRING, return_required = true)
public class Normalize {
	
	private static final Messages MESSAGES = MessagesFactory
			.getMessages("com.automationanywhere.botcommand.japanesestringutils.messages");

	@Execute
	public Value<String> action(
			//Idx 1 would be displayed first, with a text box for entering the value.
			@Idx(index = "1", type = TEXT)
			//UI labels.
			@Pkg(label = "[[Normalize.targetString.label]]")
			//Ensure that a validation error is thrown when the value is null.
			@NotEmpty
			String targetString,
			@Idx(index = "2", type = AttributeType.SELECT, options = {
					@Idx.Option(index = "2.1", pkg = @Pkg(label = "[[Normalize.type.2.1.label]]", value = "NFKC")),
					@Idx.Option(index = "2.2", pkg = @Pkg(label = "[[Normalize.type.2.2.label]]", value = "NFKD")),
					@Idx.Option(index = "2.3", pkg = @Pkg(label = "[[Normalize.type.2.3.label]]", value = "NFC")),
					@Idx.Option(index = "2.4", pkg = @Pkg(label = "[[Normalize.type.2.4.label]]", value = "NFD"))
			})	@Pkg(label = "[[Normalize.type.label]]")
				String type
			) {
		
		//Internal validation, to disallow empty strings. No null check needed as we have NotEmpty on targetString.
		if ("".equals(targetString.trim()))
			throw new BotCommandException(MESSAGES.getString("emptyInputString", "targetString"));

		if (null==type)
			type = "NFKC";

		String result = "";

		//Business logic
		switch (type){
			case "NFKC":
				result = Normalizer.normalize(targetString, Normalizer.Form.NFKC);
				break;
			case "NFKD":
				result = Normalizer.normalize(targetString, Normalizer.Form.NFKD);
				break;
			case "NFC":
				result = Normalizer.normalize(targetString, Normalizer.Form.NFC);
				break;
			case "NFD":
				result = Normalizer.normalize(targetString, Normalizer.Form.NFD);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + type);
		}

		//Return StringValue.
		return new StringValue(result);
	}
}
