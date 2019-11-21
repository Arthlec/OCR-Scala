package main.scala

import java.io.File

import net.sourceforge.tess4j.{ITesseract, Tesseract}

object Controller {
  def ocr(imagePath : String): String = {
    System.out.println(imagePath)
    val tesseract: ITesseract = new Tesseract
    tesseract.setDatapath("src/main/data/tessdata")
    tesseract.setLanguage("eng")
    val text = tesseract.doOCR(new File("src" + imagePath))
    text
  }
}
