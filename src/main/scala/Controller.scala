package main.scala

import java.io.File

import net.sourceforge.tess4j.{ITesseract, Tesseract}
import scalafx.scene.image.Image

object Controller {
  def gray2binary(image : Image): Image = {
    val pixelReader = image.pixelReader
    pixelReader
    image
  }

  def ocr(imagePath : String): String = {
    val tesseract: ITesseract = new Tesseract
    tesseract.setDatapath("src/main/data/tessdata")
    tesseract.setLanguage("eng")
    tesseract.setTessVariable("user_defined_dpi", "300")
    val text = tesseract.doOCR(new File("src" + imagePath))
    text
  }
}
