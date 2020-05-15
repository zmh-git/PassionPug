package org.xtendedunreal.ut.xpugbotj;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;
import org.slf4j.LoggerFactory;

public class XPugBot {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Starter.class);

	final static String secretToken = Configuration.token;
	final static String prefix = Configuration.prefix;

	/***
	 * Launch the bot
	 */
	public void start(String secretToken) {

		// Enable debugging, if no slf4j logger was found
		FallbackLoggerConfiguration.setDebug(true);

		logger.info(" Starting UTServerController");

		DiscordApi api = new DiscordApiBuilder().setToken(secretToken).login().join();

		// Add a listener which answers with "Pong!" if someone writes "!ping"
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase(prefix + "ping")) {
				event.getChannel().sendMessage("Pong!");
			}
		});

		// Print the invite url of your bot
		System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());

		logger.info(" Initializing commands...");
		// Add listeners
	}

}
