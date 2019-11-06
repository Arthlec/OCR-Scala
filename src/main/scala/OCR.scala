import net.sourceforge.tess4j.Tesseract

trait OCR {
  val tesseract: Tesseract = new Tesseract
  tesseract.setDatapath("src/main/data/letter.data.gz")
}
