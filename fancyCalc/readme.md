# fancyCalc

## Context-free grammar

- $CALCULATION → EXPRESSION$
- $EXPRESSION → VALUE\ |\ VALUE\ OPERATOR\ EXPRESSION\ |\ (EXPRESSION)$
- $VALUE → NUMBER\ |\ SIGN\ NUMBER$
- $NUMBER → UNSIGNED\ |\ UNSIGNED.UNSIGNED$
- $UNSIGNED → DIGIT\ |\ DIGIT\ UNSIGNED$
- $DIGIT → 0|1|2|3|4|5|6|7|8|9$
- $SIGN → -|\epsilon$
- $OPERATOR → +|-|*|/$

## Regular expressions

Integer:

Float:
