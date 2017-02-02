IO. Practice Task 1
===============

1\. NumberSearchEngine
---------------

Implement `NumberSearchEngine` interface and its function `hasNumberWithIndex` 
to determine whether given file has number with given index.

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


2\. NumberSwapEngine
---------------

Implement `NumberSwapEngine` interface and its function `swapMinAndMax` to 
swap minimum and maximum element in file with comma-separated sequence of unsigned integers.

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

3\. CountEngine
---------------

Implement `CountEngine` interface and number of its methods.

#### countSpecificCharacter

Count amount of characters that are equal to given character 'c'

Only characters that are equal to character 'c' should be counted

Here is example of valid file content with 5 '@' characters:
```
1 Some line with only one 'at' character: @
2
3 No 'at' characters
4 Ch@ngeRequest
5 @@@
```

#### countCharacters

Count amount of characters in file with given filename

Any characters should be applied

#### countWords

Count amount of words in file with given filename

We are assuming that word is sequence of characters that have more than one character of given character class `[a-zA-Z0-9]`
and may have any amount of other characters **except** whitespaces.

Here is example of valid file content with 7 words:
```
1 F1rst l!ne h@ve f)ve words!!!! ! ! ! ! ! !
2                        .. !
3 6!
4 this_is_the_last_word :-)
```
So, from the example above, following are valid words:
```
F1rst
l!ne
h@ve
f)ve
words
6!
this_is_the_last_word
```

#### countParagraphs

Count amount of paragraphs in file with given filename

We are assuming that paragraphs are separated by 2(or more) empty lines.

We are also assuming that paragraph is a text, that have more than one word.

Here is example of valid file content with 3 paragraphs:
```
1 First paragraph line one.
2 First paragraph line two.
3
4
5 Second paragraph line one.
6
7 Second paragraph line three.
8
9
10                  !!!!!!!!
11
12
13 Third paragraph line one.
14
15
16
17
18
```
For the example above function should return 3.

Here is example of valid file content with 0 paragraphs:
```
1 @!#$%^&*!
2 ((@
3 ;;:'
4
5 '!
```
