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
Currently there is a case that I have been testing that doesn't work in which an isolated node with only one connection to the rest of the graph cannot find the path to the other nodes

## Structure
The Node class is used as a data structure for the priority queue, each class contains its own adjacency list in the form of the edge values to each other node.

## Challenges
At first I was using an adjacency matrix representation, so I had to re-do the code structure. In addition there were some null pointer bugs that had to be worked out by making sure each constructor
initialized all the components.

## Acknowledgements
Chris Kuszmaul for explanation of Dijkstra's algorithm  
Rafi Long Explained some aspects of implementation of Dijkstra's algorithm in Java  
Julian Knodt Helped explain some aspects of priority queue usage for Dijkstra