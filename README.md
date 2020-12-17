# DM549-Scripts
Scripts til beregninger af DM549 problemer

En masse lort til at hjælpe med eksameneren

______________________________
@ Andreas Rosenstjerne
# Truth	table Generator
generere et truth table med logiske expression :)

download python 3, hvis det ikke allerede er på maskinen :D
derfter kan du køre `Truth table generator.py`

# logiske udtryk
- `!`, `~`, `not`, `¬` er the samme.
- `&`, `*`, `and`, `∧`, er det samme.
- `|`, `+`, `or`, `∨`, `v` er det samme.
- `<->`, `↔` er det samme.
- `->`, `→` er det samme.
- `^`, `⊕` er det samme.

burde kunne læse en fil og output til en fil, men kan ikke lige få det
til at fungere... lortet virker ellers som det skal. så fjernet det igen :))
______________________________

# udsagn calc

# relation på mængder

# kongruens calc
 
 CongruenceCalculator.java:

 programmet beder om input fra brugeren ved hjælp af popups fra javax.swing.JOptionPane
 printer svar i kommandoprompten.
 
 congruenceArray(int a, int m, int min, int max)
 returnerer et array af tal der er kongruente med a modulo m
 
 isCongruence(int a, int b, int modulus)
 returnerer boolsk værdi hvis a er kongruent med b modulo modulus
 
# matrix multiplication calc

_____________________________
@ William Bundgaard 
# RSAChecker 
- Tjekker for gangbare RSA nøgler og modulo, og hjælper med at kryptere og dekryptere.

- Dette kan ikke bruges i DM549, men den var sjov at lave

- Skrevet i java: RSAChecker.java

- Status: færdig 

- Den kan tjekke om en RSA er vallid

- Den har et simpelt user interface, og kan kryptere og dekryptere besker insat af brugeren. 

- Hvis RSAen ikke er gyldig, afslutter den automatisk selv systemet.

# mængde calc

Work in progress

Ikke helt sikker på hvad der skal være. Jeg tager gerne immod indput

Status: semi færdig

Det er muligt at:
- Tilføje mængder 
- Tilføje mængder fra en fil
- Redefinere universet
- Redefinere universet fra en fil, og tilføje mængder fra samme fil
- Tilføje elementer til en allerede eksisterene fil
- Lave sammensætningen af to mænger 
- Lave fælesmængden af to mængder 
- Lave en mænge fratrukket en anden mængde 
- Lave en invers mængde 
- Printe en allerede exsisterende mængde 
- Printe en mænge skabt af en operator 
- Tilføje en mænge skabt af en operator 
- Printe universet 
- Printe alle mængder 
- Printe menuen igen 
- Endre det univers den benytter sig af (mellem integers og strenge) 

Jeg tager gerne immod ideer til hvis der mangler noget

UPDATE: Det er nu muligt at bruge strenge til universet ved at mappe tal til strenge. Dette kan rettes i filen "intToCharMap.txt" hvis man ønsker at endre denne mapping. (Dette er den bedste måde at ender universet på. Lige nu bruger den det enelske alfabet som stenge universet, og dertil alle tallene fra 1 til 26)
_____________________________
