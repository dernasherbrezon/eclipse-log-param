package com.google.code.logparams;

import java.util.regex.Pattern;

final class Resolver {

	private static final Pattern COMMA = Pattern.compile(",");

	static Appendable resolve(String str, boolean isLogback) {
		String[] args = COMMA.split(str);
		StringBuilder result = new StringBuilder();
		if (args.length == 0 || str.length() == 0) {
			result.append("\"");
		} else {
			if (isLogback) {
				resolveLogback(args, result);
			} else {
				resolveLog4j(args, result);
			}
		}
		return result;
	}

	private static void resolveLog4j(String[] args, StringBuilder result) {
		for (int i = 0; i < args.length; i++) {
			if (i != 0) {
				result.append("+ \" ");
			}
			String arg = args[i].trim();
			result.append(arg);
			result.append(": \" + ");
			result.append(arg);
		}
	}

	private static void resolveLogback(String[] args, StringBuilder result) {
		for (int i = 0; i < args.length; i++) {
			if (i != 0) {
				result.append(", ");
			}
			String arg = args[i].trim();
			result.append(arg).append(": {}");
		}
		result.append("\"");
		if (args.length < 3) {
			for (int i = 0; i < args.length; i++) {
				result.append(",");
				String arg = args[i].trim();
				result.append(arg);
			}
		} else {
			result.append(", new Object[] {");
			for (int i = 0; i < args.length; i++) {
				if (i != 0) {
					result.append(",");
				}
				String arg = args[i].trim();
				result.append(arg);
			}
			result.append("}");
		}
	}

	private Resolver() {
		// do nothing
	}

}
