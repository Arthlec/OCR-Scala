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
  val numberOfImages = 50
  val wd: Path = os.pwd
  val datasetsPath: RelPath = os.rel/"src"/"main"/"data"/"datasets"/"IAM_words"

  val imagesIdxDataset: IndexedSeq[Path] = Random.shuffle(os.walk(wd/datasetsPath).filter(_.ext == "png")).take(numberOfImages)
  val imagesIterator: Iterator[Path] = imagesIdxDataset.iterator

  stage = refresh(windowWidth, windowHeight, canvasOriginal, canvasProcessed, imagesIterator)

  def setStage(primaryStage: PrimaryStage): Unit ={
    stage = primaryStage
  }
}
