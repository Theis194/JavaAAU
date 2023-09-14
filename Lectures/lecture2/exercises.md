# Exercise 1
Consider the following two variable declarations:

``` java
byte small = 10;
int big = 99;
```

How will you assign the value in the big variable to the small variable?

``` java
byte small = 10;
int big = 99;

small = (byte) big;
```

# Exercise 2
Can you cast a boolean value to an int type, as shown in the following statement?

``` java
boolean done = true;
int x = (int) done;
```

What happens when you compile this snippet of code?

You get a type casting error.

# Exercise 3
Are the boolean literals true and false the same as integers 1 and 0?

They are not, and you can't implicitly convert boolean to int.

# Exercise 4
Consider the following snippet of code:

``` java
int x = 23;
x = x++ % x;
```

What will be the value of x after this snippet of code is executed? Explain your
answer with steps performed explaining how the value of x changes during the
execution of the second statement.

x would be 23. Because the expression x = x++ % x evaluates to x = 23 % 24.

# Exercise 5
Explain why the following snippet of code does not compile:

``` java
int x = 10;
boolean yes = (x = 20);
```

You don't get a boolean value from the parantheses (x = 20) since it is an assingment of 20 to x.

# Exercise 6
What will be the value assigned to the variable named yes when the following
snippet of code is executed?

``` Java
int x = 10;
boolean yes = (x == 20);
```

Since the parantheses is a boolean operation it will evaluate to false and then assign it to the variable yes.

# Exercise 7
What will be the output when the following snippet of code is executed?

``` java
boolean b = true;
String str = !b +" is not " + b;
System.out.println(str);
```

false is not true

# Exercise 8
Complete the second statement using the ternary operator (? :) and the bitwise
AND operator (&) that will make a message "x is odd". Your code must contain
the following tokens in any order: x, &,==, ?, :, "odd", and "even". You may use
additional tokens as needed:

``` java
int x = 19;
String msg = x % 2 == 0 ? "even" : "odd";
System.out.println("x is " + msg);
```

# Exervise 9
Fix the compile-time errors in the following snippet of code. Make sure the fixed
code prints the value of y:
``` java
int x = 10;
int y = 20;
if (x = 10)
    y++;
    System.out.println("y = " + y);
else
    y--;
    System.out.println("y = " + y);
 ```
 
Fixed:
``` java
int x = 10;
int y = 20;
if (x == 10)
{
    y++;
    System.out.println("y = " + y);
}else
{
    y--;
    System.out.println("y = " + y);
}
```

# Exercise 10
Rewrite the following snippet of code using an if-else statement. Make sure
that the switch and if-else statements both have the same output when you
initialize the variable x to another value. (Hint: This is a tricky question because
there are no break statements in any case labels.)

``` java
int x = 50;
switch (x) {
 case 10:
    System.out.println("Ten");
 default:
    System.out.println("No-match");
 case 20:
    System.out.println("Twenty");
}
```

``` java
    int x = 50;
    if (x == 10) {
        System.out.println("Ten");
        System.out.println("No-match");
        System.out.println("Twenty");
    } else if (x == 20) {
        System.out.println("Twenty");
    } else {
        System.out.println("No-match");
        System.out.println("Twenty");
    }
```

# Exercise 11
The intent of the following for statement is to print integers from 1 to 10 in reverse
order. The code does not print the numbers as intended. Identify the logical error
and fix the code, so it prints 10, 9, 8, …1:

``` java
for(byte b = 10; b >= 1; b++)
    System.out.println(b);
```

Fixed:
``` java
for(byte b = 10; b >= 1; b--)
    System.out.println(b);
```

# Exervise 12
Write a snippet of code using a for statement that calculates the sum of all
integers from 1 to 10 and prints it on the standard output. The template for your
code is as follows:

``` java
int sum = 0;
for(<your-code>; <your-code>; <your-code>);
System.out.println("Sum = " + sum);
```

``` java
int sum = 0;
for(int i = 0; i <= 10; i++);
System.out.println("Sum = " + sum);
```

# Exercise 13
Revise your solution to exercise 10 (Exercise 11, Chapter 6) and make sure that System.out.println is called three times exactly and the calls are the same as in the switch statement (each of them is used only once)

``` java
int x = 10;
if (x == 10) {
    System.out.println("Ten");
    x++;
} 
if(x != 10 && x != 20) {
    System.out.println("No-match");
    x = 20;
}
if (x == 20) {
    System.out.println("Twenty");
    x += 10;
} 
```

# Exercise 14
Use a nested for statement to print the following pyramid.
```
   *
  ***
 *****
*******
```

``` java
int height = 4;
int stars = 1;
for (int i = height; i >= 0; i--) {
    for (int j = i - 1; j >= 0; j--) {
        System.out.print(" ");
    }
    for (int k = 0; k < stars; k++) {
        System.out.print("*");
    }
    System.out.print("\n");
    stars += 2;
}
```

# Exercise 15
 Complete the following snippet so that it computes the Fibonacci of an integer n ( replace ?1 and ?2 by zero, one, or more statements )

``` java
int n = 15;
int fib = 0;
int k = 0;
?1
while ( k < n ) {
  ?2
}
System.out.println("The Fibonacci of "+n+" is "+fib);
```

Fixed:
``` java
int n = 15;
int fib = 0;
int k = 0;
int previous = 0;
int previous2 = 1;
while ( k < n ) {
    fib = previous + previous2;
    previous2 = previous;
    previous = fib;
    System.out.println(fib);
    k++;
}
System.out.println("The Fibonacci of "+n+" is "+fib);
```