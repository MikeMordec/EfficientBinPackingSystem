# EfficientBinPackingSystem
Streamlined Bin Packing System: An Optimized Solution for Efficiently Organizing Items into Bins

This repository contains a Java implementation of an efficient bin packing system designed to organize items into bins using the First Fit and Next Fit algorithms.

## Overview

Bin packing is a combinatorial optimization problem where items of different sizes must be packed into a finite number of bins of fixed capacity. This system offers solutions to this problem through two algorithms:

- **First Fit**: Iterates through the items and places each item into the first bin with sufficient space.
- **Next Fit**: Creates a new bin when the current one cannot accommodate the next item.

## Usage

To use this bin packing system:

1. Compile the Java files.
2. Run the `BinPacking` class.
3. Input the number of items to pack and the bin capacity when prompted.
4. View the results, including the items packed into bins and the total number of bins used.

## Features

- **Dynamic Packing**: Generates random item sizes within the specified capacity for testing purposes.
- **Efficient Algorithms**: Implements First Fit and Next Fit algorithms for optimized bin packing.
- **Summarization**: Provides a summary of the packed bins, including the total number of bins used and the sum of values in each bin.
