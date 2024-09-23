### Java Primitives
``` java
boolean someBoolean = false;
short someShort = 12;
float someFloat = 12.0f;
int someInt = 12;
long someLong = L12;
double someDouble = 12;
char someChar = 'a';

String someString = "test";
```
|Data Type  |	Default Value (for fields)| Size (bits) |
| -                         | -         | -     |
| byte                      |	0       | 8     |
| short                     |	0       | 16    |
| int                       |	0       | 32    |
| long                      |	0L      | 64    |
| float                     |	0.0f    | 32    |
| double                    |	0.0d    | 64    |
| char                      |	'\u0000'| 16    |
| String (or any object)    |   null    |  8*+  |
| boolean                   |   false   | 1*    |
---
| byte | number | letter | 
|-|-|-|
| 0     | 0     | '\0' Null character |
| 1     | 1     | '\1' Start of Heading |
| 10    | 2     |   |
| 11    | 3     |
| 100   | 4     |  
| 101   |   5|
| 110 | 6|
| 111 | 7|



2 bits = 4
3 bits = 8

2* 2* 2 = 2^3
10 *10 * 10 = 10^3

2^4 = 16