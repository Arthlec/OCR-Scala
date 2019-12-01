#  Optical Character Recognition (OCR) in Scala

Course unit : DSIA-5201C  

Author : Arthur Lecert

Teacher : Angelo Corsero

## Introduction

In this project, I tried to combine image processing and the library Tesseract to solve the OCR problem.
Using functional programming was mandatory in this course.

To improve the quality of the prediction, [several methods](https://github.com/tesseract-ocr/tesseract/wiki/ImproveQuality)
exist. Binarisation is implemented in the code.

## Data
 
#### [IAM Handwriting Database](http://www.fki.inf.unibe.ch/databases/iam-handwriting-database)

The IAM Handwriting Database contains forms of handwritten English text which can be used to train and test
handwritten text recognizers and to perform writer identification and verification experiments.
 
### Dataset for future implementation
#### [The Street View Text Dataset](http://www.iapr-tc11.org/mediawiki/index.php?title=The_Street_View_Text_Dataset)

The Street View Text (SVT) dataset was harvested from Google Street View. Image text in this data exhibits high
variability and often has low resolution. In dealing with outdoor street level imagery, we note two characteristics.
(1) Image text often comes from business signage and (2) business names are easily available through geographic
business searches. These factors make the SVT set uniquely suited for word spotting in the wild: given a street view
image, the goal is to identify words from nearby businesses. More details about the data set can be found in our
paper, Word Spotting in the Wild. For our up-to-date benchmarks on this data, see our paper, End-to-end Scene
Text Recognition.
This dataset only has word-level annotations (no character bounding boxes) and should be used for:
- cropped lexicon-driven word recognition and
- full image lexicon-driven word detection and recognition. 

## List of Libraries used in the project

- [ScalaFX](http://www.scalafx.org/)
- [OS-Lib](https://github.com/lihaoyi/os-lib)
- [Tess4J](http://tess4j.sourceforge.net/)

## Prerequisites

- [Scala](https://www.scala-lang.org/)
- [Scala Build Tool](https://www.scala-sbt.org/)

Or you can use IntelliJ IDEA with Scala and sbt plugins.

## Compile & Run

From the root directory of the project, you can compile the project:
```bash
sbt compile
```
Run the project:
```bash
sbt run
```
