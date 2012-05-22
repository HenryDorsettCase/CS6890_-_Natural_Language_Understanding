CS 6890: Assignment 4 (The Last One ?)
Due: Tuesday, November 10, 2009, by 11:59 p.m.
Vladimir Kulyukin
Department of Computer Science
Utah State University
General Guidelines
This is a coding assignment. Submit your NetBeans project via Blackboard.
SAM: Script Applier Mechanism
Implement the Micro SAM system as discussed in Lectures 8 and 9 and in Chapter 6 of
Schank and Riesbeck’s “Inside Computer Understanding” (the handout). Your system
should have two scripts: the shopping script and the restaurant script. The shopping
script should be as follows (you can add the time slot to each pattern):
• Roles: ?SHOPPER, ?STORE, ?PRODUCT, ?SOMEPLACE.
• Selection Restrictions: ?SHOPPER is a human PP, ?STORE is a store,
?PRODUCT is an inanimate PP, ?SOMPLACE is a location.
• Events:
1. (PTRANS :ACTOR ?SHOPPER :OBJECT ?SHOPPER :TO ?STORE)
2. (PTRANS :ACTOR ?SHOPPER :OBJECT ?PRODUCT :TO ?SHOPPER)
3. (ATRANS :ACTOR ?STORE :OBJECT ?PRODUCT :FROM ?STORE :TO
?SHOPPER)
4. (ATRANS :ACTOR ?SHOPPER :OBJECT (MONEY) :FROM ?SHOPPER
:TO ?STORE)
5. (PTRANS :ACTOR ?SHOPPER :OBJECT ?SHOPPER :FROM ?STORE
:TO ?SOMEPLACE)
Develop a restaurant script that includes the following events: 1) Go to restaurant; 2)
Order meal; 3) Eat meal; 4) Pay; 5) Leave restaurant. The restaurant script should have
the same structure as the shopping script, i.e. it must have roles, selection restrictions, and
events represented as CD patterns.
Test your system on the following two stories. The output of processing each story is an
appropriate instantiated script and the bindings.
• Story 1: John went to the store. He got a kite. He went home.
• Story 2: John went to a restaurant. He ordered a lobster. He left.