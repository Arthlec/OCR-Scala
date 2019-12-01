package main.scala

import java.io.File

import net.sourceforge.tess4j.{ITesseract, Tesseract}
import scalafx.embed.swing.SwingFXUtils
import scalafx.scene.image.{Image, PixelReader, WritableImage}
import scalafx.scene.paint.Color

object Controller {
  def gray2binary(image : Image): Image = {
    val height = image.getHeight.toInt
    val width = image.getWidth.toInt

    val pixelReader = image.pixelReader.get
    val writableImage : WritableImage = new WritableImage(pixelReader, width, height)
    val pixelWriter = writableImage.pixelWriter

    // Mandatory for loop to use pixelReader object
    val pixelsValue = for {
      y <- 0 until height
      x <- 0 until width
    } yield {
      (pixelReader.getColor(x, y).grayscale.blue * 255).toInt // or red or green
    }

    // https://damieng.com/blog/2014/12/11/sequence-averages-in-scala
    val threshold = pixelsValue.foldLeft((0.0, 1)) { case ((avg, idx), next) => (avg + (next - avg)/idx, idx + 1) }._1

    // Mandatory for loop to use pixelReader object
    for {
      y <- 0 until height
      x <- 0 until width
    } {
      val componentValue = (pixelReader.getColor(x, y).grayscale.blue * 255).toInt // or red or green
      if (componentValue > threshold) pixelWriter.setColor(x, y, Color.White)
      else pixelWriter.setColor(x, y, Color.Black)
    }
    writableImage
  }

  def ocr(image : Image): String = {
    val tesseract: ITesseract = new Tesseract
    tesseract.setDatapath("src/main/data/tessdata")
    tesseract.setLanguage("eng")
    tesseract.setTessVariable("user_defined_dpi", "300")
    val text = tesseract.doOCR(SwingFXUtils.fromFXImage(image, null))
    text
  }
}
