package com.google.code.logparams;

import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.jface.text.templates.TemplateVariableResolver;

public class FormattedParamsResolver extends TemplateVariableResolver {

	@Override
	protected String resolve(TemplateContext context) {
		TemplateVariable v = new TemplateVariable("enclosing_method_arguments","", null);
		context.getContextType().resolve(v, context);
		String[] values = v.getValues();
		if( values == null || values.length != 1 ) {
			return "";
		}
		Appendable result = Resolver.resolve(values[0], false);
		return result.toString();
	}

}
