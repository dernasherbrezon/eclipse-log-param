About
-----

Adds the following variables for code templates in eclipse:
  * "formatted_method_parameter" - log4j logging style.
  * "formatted_logback_method_parameters" - logback logging style

HowTo
-----

Under Window -> Preferences -> Java -> Editor -> Templates click "New.."
 * name = "lp"
 * context = "Java statements"
 * description = "Fast parameters logging"
 * Pattern:
   * log4j: "logger.trace("${enclosing_method}. ${formatted_method_parameters});"
   * logback: "logger.trace("${enclosing_method}. ${formatted_logback_method_parameters});"

Click "OK"

Usage
======

In method type "lp" and press "ctrl" + "space". Consider the following method:
```
public static void saveUserPreferences(String userName, String[] preferences) {

}
```

The result will be:
  * log4j style:
```
public static void saveUserPreferences(String userName, String[] preferences) {
    logger.trace("saveUserPreferences. userName: " + userName + " preferences: " + preferences);
}
```
  * logback style:
```
public static void saveUserPreferences(String userName, String[] preferences) {
    logger.trace("saveUserPreferences. userName: {}, preferences: {}", userName, preferences);
}
```

Hints
-------

Usefull for logging error stuff in catch block. Silghtly modified version of default "try" template:
```
try {
	${line_selection}
} catch (Exception ${exception_variable_name}) {
	LOG.error("unable to ${enclosing_method}. ${formatted_method_parameters}, ${exception_variable_name});
	${cursor}
}
```
