## Transformer ##

Annotate member variables for transformation

```java
public class User {
	@DateFormat(from = "MM-dd-yyyy", to = "yyyy/MM/dd")
	private String date;
}
```

Instantiate

```java
Transformer transformer = new Transformer(object);
```

Transform

```java
transformer.transform();
```

## Date Format ###

Change the format of a date string

```java
@DateFormat(from = "MM-dd-yyyy", to = "yyyy/MM/dd")
```

Data types supported
- String

Format used by java.text.SimpleDateFormat


## Custom ##

Transforms against a custom class

```java
@CustomTransformer(MyManipulation.clss)
```

Required
- value - Class that implements Manipulation

**Note:** Custom transformation class must implement the Manipulation interface
