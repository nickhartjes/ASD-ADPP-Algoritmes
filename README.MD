![HAN](https://upload.wikimedia.org/wikipedia/commons/e/eb/HAN-merkteken-descriptor.png)


[![Build Status](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes.svg?branch=master)](https://travis-ci.org/nickhartjes/ASD-ADPP-Algoritmes)
[![codecov](https://codecov.io/gh/nickhartjes/ASD-ADPP-Algoritmes/branch/master/graph/badge.svg?token=K06sZUhOmk)](https://codecov.io/gh/nickhartjes/ASD-ADPP-Algoritmes)

# Opdrachten PO_Algoritmes


[TOC]


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
Voor het maken van de graaf heb ik ook gekozen om generics te gebruiken. Zodat er de mogelijk bestaat om ook grafen te maken van andere objecten. Dat had als impact dat ik geen 2d linkedlist kon gebruiken als adjacency list. De reden hiervoor is dat ik de waarde van de vertex niet kon gebruiken als key. Dit gaat met een primitieve of niet-primitieve integer wel. Uiteindelijk heb ik er voor gekozen om een hashmap te implementeren. Dit geeft de mogelijkheid dat je met een object de juiste vertex kan oproepen, waarin dat een linkedlist staat met edges naar andere vertices.

Een adjacency list heeft standaard de voorkeur ten opzichte van een adjecency matrix. Dit omdat het efficiënter omgaat met graaf met een lage dichtheid. Is de dichtheid hoger ( wanneer de aantal edges dicht aan het aantal vertices tot de macht 2 ligt) dan is de matrix weer efficiënter.

|                                                              | Adjacency list                                               | Adjacency matrix                                             |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Store graph                                                  | O(\|V\|+\|E\|)                                               | O(\|V\|^2)                                                   |
| Add vertex                                                   | O(1)                                                         | O(\|V\|^2)                                                   |
| Add edge                                                     | O(1)                                                         | O(1)                                                         |
| Remove vertex                                                | O(\|E\|)                                                     | O(\|V\|^2)                                                   |
| Remove edge                                                  | O(\|V\|)                                                     | O(1)                                                         |
| Are vertices x and y adjacent (assuming that their storage positions are known)? | O(\|V\|)                                                     | O(1)                                                         |
| Remarks                                                      | Slow to remove vertices and edges, because it needs to find all vertices or edges | Slow to add or remove vertices, because matrix must be resized/copied |

|V| = Vertices
|E| = Edges
[Bron](https://en.wikipedia.org/wiki/Graph_(abstract_data_type)) 


Een strategy pattern is gebruikt om het Dijkstra algoritme te implementeren. Hierdoor kunnen er makkelijker verschillende shortest path algoritmes toegevoegd worden.

De graaf is zowel directed als undirected te gebruiken, en weighted en unweighted.
Dit is te doen om in de constructor de GraphDirection en GraphWeight mee te geven.

~~~java
Graph<Character> route01 = new Graph<>(GraphDirection.DIRECTED, GraphWeight.WEIGHTED);
~~~

Bij default is de graaf unweighted en undirected.

[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/graph/Graph.java)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/graph/GraphTest.java)

~~~java
Graph<Character> route01 = new Graph<>();
route01.addVertex(this.graphCharacterArray);
route01.addEdge('a', 'b');
route01.addEdge('c', 'b');
route01.addEdge('a', 'c');
~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

#### Ongewogen      
[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/graph/Graph.java)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/graph/GraphTest.java)

~~~java
Graph<Character> route05 =
    new Graph<>(GraphDirection.DIRECTED, GraphWeight.UNWEIGHTED);
route05.addVertex(this.graphCharacterArray);
route05.addEdge('a', 'b');
route05.addEdge('c', 'b');
route05.addEdge('a', 'c');
route05.addEdge('c', 'd');
route05.addEdge('d', 'e');
route05.addEdge('e', 'a');
logger.info("Graph 05: shortestpath {}", route05.searchShortestPath('a', 'e'));
// Graph 05: shortestpath Path{path=a --> c --> d --> e --> , weight=4.0}

~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

#### Gewogen      
[Code](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/graph/Graph.java)

[Testen](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/test/java/nl/nickhartjes/han/asd/adpp/graph/GraphTest.java)

~~~java
Graph<Character> route04 =
    new Graph<>(GraphDirection.UNDIRECTED, GraphWeight.WEIGHTED);
route04.addVertex(this.graphCharacterArray);
route04.addEdge('a', 'b', 8);
route04.addEdge('c', 'b', 3);
route04.addEdge('a', 'c', 6);
route04.addEdge('c', 'd', 4);
route04.addEdge('d', 'e', 7);
route04.addEdge('e', 'a', 2);
logger.info("Graph 04: shortestpath {}", route04.searchShortestPath('a', 'e'));
// Graph 04: shortestpath Path{path=a --> e --> , weight=2.2}

~~~

[Bron: codefragment](https://github.com/nickhartjes/ASD-ADPP-Algoritmes/blob/master/src/main/java/nl/nickhartjes/han/asd/adpp/Main.java)

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
