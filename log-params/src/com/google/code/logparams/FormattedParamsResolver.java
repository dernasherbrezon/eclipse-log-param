package com.google.code.logparams;

import java.util.regex.Pattern;

import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.jface.text.templates.TemplateVariableResolver;

public class FormattedParamsResolver extends TemplateVariableResolver {

	private static final Pattern COMMA = Pattern.compile(",");
	
	@Override
	protected String resolve(TemplateContext context) {
		TemplateVariable v = new TemplateVariable("enclosing_method_arguments","", null);
		context.getContextType().resolve(v, context);
		String[] values = v.getValues();
		if( values == null || values.length != 1 ) {
			return "";
		}
		String[] args = COMMA.split(values[0]);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			if( i != 0 ) {
				result.append("+ \" ");
			}
			String arg = args[i].trim();
			result.append(arg);
			result.append(": \" + ");
			result.append(arg);
		}
		return result.toString();
	}

}
