## About ##

Adds the following variables for code templates in eclipse:
  * "formatted\_method\_parameter" - log4j logging style.
  * "formatted\_logback\_method\_parameters" - logback logging style

## `HowTo` ##

Under Window -> Preferences -> Java -> Editor -> Templates click "New.."
  * name = "lp"
  * context = "Java statements"
  * description = "Fast parameters logging"
  * Pattern:
    * log4j: "logger.trace("${enclosing\_method}. ${formatted\_method\_parameters});"
    * logback: "logger.trace("${enclosing\_method}. ${formatted\_logback\_method\_parameters});"

Click "OK"

### Usage ###

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

## Installation ##

Navigate to Help -> Install New Software...
Type site update url:
```
https://eclipse-log-param.googlecode.com/svn/site/
```

Click install

## Hints ##

Usefull for logging error stuff in catch block. Silghtly modified version of default "try" template:
```
try {
	${line_selection}
} catch (Exception ${exception_variable_name}) {
	LOG.error("unable to ${enclosing_method}. ${formatted_method_parameters}, ${exception_variable_name});
	${cursor}
}
```