# Tree Builder

## Overview

This application is used to construct entire tree from an array of edges and return the root node 1.

### Technologies

Programming Language : Java 17 \
Libraries Used : Junit 4.13.2, Maven 2.4 

### Key Points

1. 1 is the root node.
2. There is no duplicated edge.
3. There is no isolated node.
4. Thus, N nodes, n-1 edges.
5. Positions in the tuple do not indicate direction.


### Algorithm

1. Create hashmap to store first edge nodes in provided input array and parent nodes
2. If root node 1 id found and is not stored in map then add other element as child to root node.
3. If first element of edge is parent then add second element as child to first
4. If second element of edge is parent then add first element as child to second
5. Create node for both element in first edge and add first node to 2nd as child and vice-versa as we can't determine who is parent and store in map

### Limitations

Assumed that inputs passed to program are inlined with key points. Application will return root node 1 even if there will be violation of requirements.

### Install and Run

mvn test : to run test cases \
mvn clean package : create jar \
java -jar target/tree-builder-1.0-SNAPSHOT.jar : run the application

### Input
````
[[4, 5], [5, 3], [1, 5], [2, 1]]
````
### Output
````
Node{data=1, children=[Node{data=5, children=[Node{data=4, children=[]}, Node{data=3, children=[]}]}, Node{data=2, children=[]}]}
