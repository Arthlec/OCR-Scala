package main.scala

import net.sourceforge.tess4j.Tesseract
import net.sourceforge.tess4j.TesseractException

import scala.reflect.io.File

object Controller extends App {
  val tesseract = new Tesseract();
  try {

//    tesseract.setDatapath("D:/Tess4J/tessdata");
    val text = tesseract.doOCR(new File("main/data/mnist_png/testing/0/3.png"))

    // path of your image file
    System.out.print(text);
  }
  catch (TesseractException e) {
    e.printStackTrace();
  }
}
