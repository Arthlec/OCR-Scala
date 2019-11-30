/***
 * Optical Character Recognition (OCR)
 *
 *
 * *** IAM Handwriting Database (http://www.fki.inf.unibe.ch/databases/iam-handwriting-database) ***
 * The IAM Handwriting Database contains forms of handwritten English text which can be used to train and test
 * handwritten text recognizers and to perform writer identification and verification experiments.
 *
 * *** The Street View Text Dataset (http://www.iapr-tc11.org/mediawiki/index.php?title=The_Street_View_Text_Dataset) ***
 * The Street View Text (SVT) dataset was harvested from Google Street View. Image text in this data exhibits high
 * variability and often has low resolution. In dealing with outdoor street level imagery, we note two characteristics.
 * (1) Image text often comes from business signage and (2) business names are easily available through geographic
 * business searches. These factors make the SVT set uniquely suited for word spotting in the wild: given a street view
 * image, the goal is to identify words from nearby businesses. More details about the data set can be found in our
 * paper, Word Spotting in the Wild [1]. For our up-to-date benchmarks on this data, see our paper, End-to-end Scene
 * Text Recognition [2].
 * This dataset only has word-level annotations (no character bounding boxes) and should be used for
 * - cropped lexicon-driven word recognition and
 * - full image lexicon-driven word detection and recognition.
 *
 * Other Datasets for future implementation :
 * https://lionbridge.ai/datasets/15-best-ocr-handwriting-datasets/
 */
package main.scala

import main.scala.View._
import os.{Path, RelPath}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.canvas.Canvas

import scala.util.Random

object Main extends JFXApp {
  val windowHeight = 1000
  val windowWidth = 1200
  val canvasOriginal = new Canvas(windowWidth, 400)
  val canvasProcessed = new Canvas(windowWidth, 400)
  val numberOfImages = 30
  val wd: Path = os.pwd
  val datasetsPath: RelPath = os.rel/"src"/"main"/"data"/"datasets"/"IAM_words"

  val imagesIdxDataset: IndexedSeq[Path] = Random.shuffle(os.walk(wd/datasetsPath).filter(_.ext == "png")).take(numberOfImages)
  val imagesIterator: Iterator[Path] = imagesIdxDataset.iterator

  stage = refresh(windowWidth, windowHeight, canvasOriginal, canvasProcessed, imagesIterator)

  def setStage(primaryStage: PrimaryStage): Unit ={
    stage = primaryStage
  }
}
