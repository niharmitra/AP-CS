# Implementation of Dijkstra's Algorithm In Java
By Nihar Mitra for AP CS

## Introduction
Dijkstra's algorithm is an algorithm that finds the shortest paths between nodes of a graph. Given a starting node, it proceeds to find the shortest paths
to every other node in the graph.

The output for this is a single source path. The single source path is represented by indicating the previous node in the path for each node. By following this backwards,
one can find the path for each node from the source.

## Specification
Implement a method that takes an adjacency list representation of a graph, a starting node, and runs Dijkstra's algorithm on it,
returning an ordered collection representing the single source shortest path as determined by Dijkstra's algorithm.

This code is able to meet this specification.

## Current Issues
I am unaware of any issues with the code currently.

## Structure
The Node class is used as a data structure for the priority queue, each class contains its own adjacency list in the form of the edge values to each other node.
The Dijkstra static method is called on an ArrayList of these nodes (the graph) and given a start node in order to run.
Each node can be formed in many ways, but the most convenient is to pass the name, followed by values of the edges to each other node as doubles, with null instead of infinity.

## Challenges
At first I was using an adjacency matrix representation, so I had to re-do the code structure. In addition there were some null pointer bugs that had to be worked out by making sure each constructor
initialized all the components. 
Another challenge was a bug that took me a while to find. Priority queue does not reupdate/order itself when an instance variable of an element is modified.
Because that instance variable (the source distance) was supposed to be the basis of the priority queue's order, when the start node's source distance was set to 0 after the formation of the
priority queue, the priority queue was not in the correct order.

## Acknowledgements
Chris Kuszmaul for explanation of Dijkstra's algorithm  
Rafi Long Explained some aspects of implementation of Dijkstra's algorithm in Java  
Julian Knodt Explained priority queue implementation for Dijkstra