![HAN](https://upload.wikimedia.org/wikipedia/commons/e/eb/HAN-merkteken-descriptor.png)

##### Travis ci   

[![Build Status](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes.svg?branch=master)](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes)
[![codecov](https://codecov.io/gh/nickhartjes/ASD-ADPP-Algoritmes/branch/master/graph/badge.svg?token=K06sZUhOmk)](https://codecov.io/gh/nickhartjes/ASD-ADPP-Algoritmes)

# Opdrachten PO_Algoritmes


## Opdracht 1      
Programmeer Quicksort uit zoals in de opgave van Sorteeralgoritmes, maar deze keer generic voor klassen die de Comparable<T> interface implementeren

## Opdracht 2   
Implementeer Dijkstra’s algoritme en unweighted shortest path.  
Gebruik eigen implementaties van datastructuren. Alleen de java.util.PriorityQueue mag u ook gebruiken.

## Opdracht 3   
Maak een BinarySearchTree waarin de values ints zijn.  
a.	Implementeer de operatie insert.   
b.	Implementeer recursief de operaties find, findMin en findMax.   
c.  (bonus) Implementeer de operatie remove(int x). Hint: bestudeer de implementaties in het boek.


## Preconditions
- Java SDK 11 and up

# Toelichting Opdrachten

## Aspect

### Reproduceerbaarheid

#### Online-compileerbaarheide 

De java sourcecode word door [travis-ci.com](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes) en/of  [travis-ci.org](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes) gebouwd met behulp van een gradle wrapper. Tijdens de bouwpoging worden eerste de externe library's opgehaald, en daarna word de applicatie gebouwd. De volgende stap is het runnen van de testen. Aan de hand van deze testen word er ook een code coverage rapport gegenereerd. Deze is te vinden op [CodeCov](https://codecov.io/gh/nickhartjes/ASD-ADPP-Algoritmes). 
Als laatste stap word `gradle run` uitgevoerd. De applicatie word uitgevoerd, en alle voorbeelden in de main worden uitgevoerd.

### Quicksort

#### Generic programming
[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/sort/GenericQuickSort.java)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/sort/GenericQuickSortTest.java)

~~~java
var quickMergeCharacter = new GenericQuickSort<Character>();
var quickMergeStudent = new GenericQuickSort<Student>();
~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

#### Pivotselectie

Om op een goede en uitbreidbare manier een pivotselectie te implementeren heb ik zelf gekozen om een  strategy pattern toe te passen. Hierbij kunnen ook toekomstige manier voor pivots makkelijk worden toegevoegd.  
De volgende 3 pivot's zijn geimplementeerd

- Random
- Middle 
- Median Of Three

[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/tree/master/src/main/java/nl/nickhartjes/han/asd/adpp/sort/pivot)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/sort/GenericQuickSortTest.java)

~~~java
var quickMergeStudent = new GenericQuickSort<Student>();
quickMergeStudent.sort(this.studentArray, new MiddlePivot<>());
quickMergeStudent.sort(this.studentArray, new RandomPivot<>());
quickMergeStudent.sort(this.studentArray, new MedianOfThreePivot<>());
~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

#### Geautomatiseerd testen op bekende input 
[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/sort/GenericQuickSortTest.java)
Resultaat van testen in : [travis-ci.com](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes) en/of  [travis-ci.org](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes) 

### Kortste paden  

#### Datastructuren     
[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/graph/Graph.java)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/graph/GraphTest.java)

~~~java
var quickMergeStudent = new GenericQuickSort<Student>();
quickMergeStudent.sort(this.studentArray, new MiddlePivot<>());
quickMergeStudent.sort(this.studentArray, new RandomPivot<>());
quickMergeStudent.sort(this.studentArray, new MedianOfThreePivot<>());
~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

#### Ongewogen      
dfgd

#### Gewogen      
dsgfdf

#### Geautomatiseerd testen op bekende input      
[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/graph/GraphTest.java)
Resultaat van testen in : [travis-ci.com](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes) en/of  [travis-ci.org](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes) 

### Binaire zoekboom  

#### insert      
[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/binary_search_tree/BinarySearchTree.java)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/binary_search_tree/BinarySearchTreeTest.java)

~~~java
BinarySearchTree<Integer> binarySearchTree01 = new BinarySearchTree<>();
binarySearchTree01.insert(10);
binarySearchTree01.insert(15);
binarySearchTree01.insert(11);
binarySearchTree01.insert(8);
binarySearchTree01.insert(2);
binarySearchTree01.insert(1);
// or
binarySearchTree01.insert(3, 2, 4, 2, 77, 3, 213423, 34, 223, 443, -33);
~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

#### find   
[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/binary_search_tree/BinarySearchTree.java)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/binary_search_tree/BinarySearchTreeTest.java)

~~~java
BinarySearchTree<Integer> binarySearchTree01 = new BinarySearchTree<>();
binarySearchTree01.insert(3, 2, 4, 2, 77, 3, 213423, 34, 223, 443, -33);
Integer node = binarySearchTree01.search(2);
~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

#### findMin en findMax      
[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/binary_search_tree/BinarySearchTree.java)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/binary_search_tree/BinarySearchTreeTest.java)

~~~java
BinarySearchTree<Integer> binarySearchTree01 = new BinarySearchTree<>();
binarySearchTree01.insert(3, 2, 4, 2, 77, 3, 213423, 34, 223, 443, -33);
Integer node1 = binarySearchTree01.findMax();
Integer node2 = binarySearchTree01.findMin();
~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

#### remove      
[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/binary_search_tree/BinarySearchTree.java)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/binary_search_tree/BinarySearchTreeTest.java)

~~~java
BinarySearchTree<Integer> binarySearchTree01 = new BinarySearchTree<>();
binarySearchTree01.insert(3, 2, 4, 2, 77, 3, 213423, 34, 223, 443, -33);
binarySearchTree01.remove(213423);
~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

#### Geautomatiseerd testen op bekende input      
[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/binary_search_tree/BinarySearchTreeTest.java)
Resultaat van testen in : [travis-ci.com](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes) en/of  [travis-ci.org](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes) 

# Beoordelingsmodel

| Aspect              | Weging | Criterium                               | Minimum (%) | 100% (lezen van links naar rechts)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | 50%                                                                                                                                                                                                           | 0%                                                                                                                         | Beoordeling (%) | Knock-out? | Score |
|---------------------|--------|-----------------------------------------|-------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|-----------------|------------|-------|
| Reproduceerbaarheid | 1      | Online-compileerbaarheid                | 100         | * Ontwikkelt in een programmeertaal naar keuze uitsluitend een volledige, eigenstandige softwaremodule die d.m.v. een veilige webomgeving te compileren/interpreteren en draaien is. Bijv.: een werkend stuk broncode dat via GitLab.com en GitLab CI gebouwd en getest kan worden.                                                                                                                                                                                                                                                                                                                                                                | * Ontwikkelt deels.                                                                                                                                                                                           | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            |       |
| Quicksort           | 1      | Generic programming                     | 0           | * Ontwikkelt implementatie generic, ten minste voor klassen die Comparable implementeren.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | * Ontwikkelt generic maar niet ten minste voor Comparable.                                                                                                                                                    | * Ontwikkelt niet generic of niets.                                                                                        |                 |            | 0     |
|                     | 1      | Pivotselectie                           | 0           | * Ontwikkelt zodanig dat pivot willekeurig of median-of-3 geselecteerd wordt.* Ontwikkelt zodanig dat rijen korter dan 3 niet met ander sorteeralgoritme (bijv. Insertion sort) gesorteerd worden.                                                                                                                                                                                                                                                                                                                                                                                                                                                 | * Ontwikkelt zodanig dat pivot niet willekeurig of median-of-3 geselecteerd wordt, maar ook niet het eerste of laatste element. Bijv. door een per abuis foute implementatie.* Idem.                          | * Ontwikkelt zodanig dat eerste of laatste element altijd pivot wordt of ontwikkelt niets.* Ontwikkelt niet of nauwelijks. |                 |            | 0     |
|                     | 1      | Geautomatiseerd testen op bekende input | 50          | * Ontwikkelt in totaal ten minste 5 unit tests voor sorteren die (ook) werken voor deze Quicksort-implementatie.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | * Ontwikkelt in totaal 2 unit tests.                                                                                                                                                                          | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            | 0     |
|                     | 4      | Correctheid bij onbekende input         | 0           | * Ontwikkelt implementatie die 100 % van een vaste door de beoordelaar te bedenken set test inputs correct verwerkt, d.w.z. volgens Quicksort en met de correcte uitkomst.                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | * 50 %.                                                                                                                                                                                                       | * 0 %.                                                                                                                     |                 |            | 0     |
| Kortste paden       | 1      | Datastructuren                          | 0           | * Reproduceert een implementatie als class van gerichte grafen met vertices van een specificeerbaar niet-primitief type, int gewichten en op basis van een adjacency matrix, adjacency lists of adjacency sets-representatie. Verwijst naar alle bronnen waaruit de implementatie gereproduceerd is. (Echte subdatastructuren binnen uw graaf-klasse worden niet beoordeeld, dus mogen bijv. uit de standard library komen.)* Motiveert keuze voor representatie uit de drie mogelijkheden, verwijzend naar verwachte aantallen en verhoudingen tussen vertices, edges, en operaties, en gespecificeerd in termen van tijd- en ruimtecomplexiteit. | * Reproduceert deels niet volgens specificatie of met een overige representatie dan de drie mogelijkheden. Bijv. gebruikt een externe library.* Motiveert deels (correct) en/of specificeert deels (correct). | * Ontwikkelt niet of nauwelijks.* Motiveert niet of nauwelijks.                                                            |                 |            | 0     |
|                     | 2      | Ongewogen                               | 0           | * Ontwikkelt een algoritme-implementatie voor het ongewogen kortste pad van alle nodes naar alle andere nodes in een graaf, d.m.v. een methode van de graaf-klasse.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | * Ontwikkelt zodanig dat een externe library deels of volledig de implementatie bevat.                                                                                                                        | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            | 0     |
|                     | 2      | Gewogen                                 | 0           | * Ontwikkelt een algoritme-implementatie voor het gewogen kortste pad van alle nodes naar alle andere nodes in een graaf volgens Dijkstra's algoritme, d.m.v. een methode van de graaf-klasse.                                                                                                                                                                                                                                                                                                                                                                                                                                                     | * Ontwikkelt zodanig dat een externe library deels of volledig de implementatie bevat.                                                                                                                        | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            | 0     |
|                     | 1      | Geautomatiseerd testen op bekende input | 50          | * Ontwikkelt in totaal ten minste 5 unit tests waarin implementatie zowel als gewogen en ongewogen kortstepadimplementaties getest worden.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | * Ontwikkelt in totaal 2 unit tests waarin zowel methoden voor gewogen als ongewogen kortste paden gecoverd zijn.                                                                                             | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            | 0     |
|                     | 4      | Correctheid bij onbekende input         | 0           | * Ontwikkelt implementatie die 100 % van een vaste door de beoordelaar te bedenken set test inputs correct verwerkt, d.w.z. volgens de kortstepaden-algoritmes en met de juiste uitkomst.                                                                                                                                                                                                                                                                                                                                                                                                                                                          | * 50 %.                                                                                                                                                                                                       | * 0 %.                                                                                                                     |                 |            | 0     |
| Binaire zoekboom    | 2      | insert                                  | 0           | * Ontwikkelt de operatie met de semantiek insert d.m.v. een methode van de klasse.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | * Ontwikkelt deels.                                                                                                                                                                                           | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            | 0     |
|                     | 2      | find                                    | 0           | * Ontwikkelt de operatie met de semantiek find d.m.v. een methode van de klasse.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | * Ontwikkelt deels.                                                                                                                                                                                           | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            | 0     |
|                     | 2      | findMin en findMax                      | 0           | * Ontwikkelt de operaties met de semantieken findMin en findMax d.m.v. methoden van de klassen.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | * Ontwikkelt deels.                                                                                                                                                                                           | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            | 0     |
|                     | 1      | remove                                  | 0           | * Ontwikkelt de operatie met de semantieken remove d.m.v. een methode van de klasse.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               | * Ontwikkelt deels.                                                                                                                                                                                           | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            | 0     |
|                     | 1      | Geautomatiseerd testen op bekende input | 50          | * Ontwikkelt in totaal ten minste 5 unit tests waarin alle gevraagde operaties gecoverd zijn.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | * Ontwikkelt in totaal 2 unit tests waarin 2 van de gevraagde operaties gecoverd zijn.                                                                                                                        | * Ontwikkelt niet of nauwelijks.                                                                                           |                 |            | 0     |
|                     | 4      | Correctheid bij onbekende input         | 0           | * Ontwikkelt implementatie die 100 % van een vaste door de beoordelaar te bedenken set test inputs correct verwerkt, d.w.z. in een binaire zoekboom de operaties uitvoert met een correcte uitkomst.                                                                                                                                                                                                                                                                                                                                                                                                                                               | * 50 %.                                                                                                                                                                                                       | * 0 %.                                                                                                                     |                 |            | 0     |
| Totaal              | 29     |                                         |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |                                                                                                                                                                                                               |                                                                                                                            |                 |            | 0     |
| Cijfer              | 1,00   |                                         |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |                                                                                                                                                                                                               |                                                                                                                            |                 |            |       |
