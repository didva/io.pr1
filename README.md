IO Practice Task 1
===============

1\. Has Number With Index
---------------

Determine whether given file has number with given index.

Expect that given file(if present in filesystem) will have only one unsigned integer per line.

Here is valid example of possible file content:
```
1    5775
2    0
3
4    555
5    111
6
7    9
8
9    1
10   111111
```
In the given example above there are numbers with indexes: `[1,2,4,5,7,9,10]` and there are no numbers with index `[3,6,8]`

Find additional information in JavaDocs of `NumberSearchEngine` interface.


2\. Swap Minimum And Maximum
---------------

Swap minimum and maximum element in file with comma-separated sequence of unsigned integers.

Expect that given file(if present in filesystem) will contain comma-separated sequence of unsigned integers in only one line.

Here is valid example of possible file content:
```
1,2,3,4,    7 ,    4 , 10,    0,    9999 ,  1,    0,       2
```
In the given example above there is only one maximum element that is equal to 9999
and possible two minimum elements that are equal to 0.

In case you have got one maximum and more than one minimum element - swap maximum with the very <b>first</b> minimum element.
For the example above, the result should be:
```
1,2,3,4,    7 ,    4 , 10,    9999,     0,  1,    0,       2
```

In case you have got one minimum and more than one maximum element - swap minimum with the <b>first</b> maximum element.
From:
```
1,2,2,3,4,9,5,6,9
```
To:
```
9,2,2,3,4,1,5,6,9
```

In case you have got many minimum and many maximum elements - swap earlier minimum with earlier maximum element.
From:
```
1,1,2,3,4,9,5,6,9,9
```
To:
```
9,9,2,3,4,1,5,6,1,9
```
Detailed show case of the case with many minimum and many maximum elements:
```
n - minimum element
x - maximum element
input:
1,1,2,3,4,9,5,6,9,9
^ ^       ^     ^ ^
n n       x     x x

Swap first minimum with first maximum (n1 -> x1) result:
9,1,2,3,4,1,5,6,9,9

Swap second minimum with second maximum (n2 -> x2) result:
9,9,2,3,4,1,5,6,1,9

result:
9,9,2,3,4,1,5,6,1,9
```
