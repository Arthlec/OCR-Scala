package main.scala

import java.io.File

import net.sourceforge.tess4j.{ITesseract, Tesseract}

object Controller {


  def ocr(imagePath : String): String = {
    val tesseract: ITesseract = new Tesseract
    tesseract.setDatapath("src/main/data/tessdata")
    tesseract.setLanguage("eng")
    tesseract.setTessVariable("user_defined_dpi", "300")
    val text = tesseract.doOCR(new File("src" + imagePath))
    text
  }
}
