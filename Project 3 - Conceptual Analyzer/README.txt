CS 6890: Assignment 3
Due: Tuesday, October 27, 2009, by 11:59 p.m.
Vladimir Kulyukin
Department of Computer Science
Utah State University
General Guidelines
This is a coding assignment. Submit your NetBeans project via Blackboard.
Conceptual Analyzer
Implement a conceptual analyzer that can handle the following three sentences:
1. John gave Mary a book.
2. Mary gave a book to John.
3. John took Mary to Chicago.
Your CA should map the sentences to the following corresponding CDs:
1. (ATRANS :ACTOR (HUMAN :NAME (JOHN) :GENDER (MALE))
:OBJECT (BOOK :REF (INDEF))
:FROM (HUMAN :NAME (JOHN) :GENDER (MALE))
:TO (HUMAN :NAME (MARY) :GENDER (FEMALE))
:TIME (PAST));
2. (ATRANS :ACTOR (HUMAN :NAME (MARY) :GENDER (FEMALE))
:OBJECT (BOOK :REF (INDEF))
:FROM (HUMAN :NAME (MARY) :GENDER (FEMALE))
:TO (HUMAN :NAME (JOHN) :GENDER (MALE))
:TIME (PAST));
3. (PTRANS :ACTOR (HUMAN :NAME (JOHN) :GENDER (MALE))
:OBJECT (HUMAN :NAME (MARY) :GENDER (FEMALE))
:FROM NIL
:TO (CITY :NAME (CHICAGO))
:TIME (PAST)).
You do not have to handle ambiguity in this assignment (unless, of course, you want
an extra challenge ?). Thus, you can associate with gave only the meaning of
ATRANS and with took only the meaning of PTRANS.