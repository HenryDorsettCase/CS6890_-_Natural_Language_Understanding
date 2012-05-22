Christopher H. Weber
CS6890 NLP
Project One
Due: 9/14/09 midnight

This program uses the jdsl library.
The jdsl jar is included as well as the source code.
The project itself is also bundled into a jar.

*Run the program without cmd line args if you wish.

Notes:
+prn makes it easier to parse all possible incoming strings, rather than prn.
All surface strings must conclude with a #, as it seemed as such in the book.

*If you desire to enter command line args, use the following set of strings:

+prn+1sg
+prn+3sg+musc
+prn+3sg+fem
+prn+1pl
fox+n+sg
fox+n+pl
finch+n+sg
finch+n+pl
goose+n+sg
goose+n+pl
fox+v+pres_form+3sg
burn+v+past_form
burn+v+past_part
catch+v+past_form
catch+v+past_part
speak+v+past_form
speak+v+past_part
see+v+past_form
see+v+past_part
see+v+pres_form+pl
see+v+pres_form+3sg

i#
he#
she#
we#
fox#
foxes#
finch#
finches#
goose#
geese#
foxes#
burned#
caught#
spoke#
spoken#
saw#
seen#
see#
sees#

i# saw# geese#
we# see# geese#
he# sees# geese#
she# sees# geese#

+prn+1sg see+v+past_form goose+n+pl
+prn+1pl see+v+pres_form+pl goose+n+pl
+prn+3sg+musc see+v+pres_form+3sg goose+n+pl
+prn+3sg+fem see+v+pres_form+3sg goose+n+pl