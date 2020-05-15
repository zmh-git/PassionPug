package org.xtendedunreal.ut.xpugbotj;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

public class Starter 
{
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Starter.class);
	
	static String secretToken = "";
	final static String prefix = Configuration.prefix;
	
	public static XPugBot bot = new XPugBot();

	private static String fileToken = "token";
	public static void main( String[] args )
    {
		secretToken = loadToken();
		bot.start(secretToken);
    }
	private static String loadToken() {
		String secretToken = null;
	    File file = new File(fileToken);
	    try {
			return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// -- No token, no bot... :(
			logger.error("Could nmot read the token from file, can not continue, terminating...");
			logger.error("Error message: {}", e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	    if (StringUtils.isEmpty(secretToken)) {
			logger.error("Token file contents are empty :( can not continue, terminating...");
			System.exit(2);
	    }
		return secretToken;
	}
}
