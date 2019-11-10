/***
 * Optical Character Recognition (OCR)
 *
 *
 * Datasets :
 * https://lionbridge.ai/datasets/15-best-ocr-handwriting-datasets/
 *
 * *** Stanford Dataset (http://ai.stanford.edu/~btaskar/ocr/) ***
 * The tab delimited data file (letter.data.gz) contains a line for each letter, with its label, pixel values,
 * and several additional fields listed in letter.names file.
 * Columns : id, letter, next_id, word_id, position, fold, p_0_0, p_0_1, ...
 * Lettres en 16 x 8 pixels
 *
 *
 * *** The MNIST Database (http://yann.lecun.com/exdb/mnist/) ***
 * The MNIST database of handwritten digits, available from this page, has a training set of 60,000 examples, and a test
 * set of 10,000 examples. It is a subset of a larger set available from NIST. The digits have been size-normalized and
 * centered in a fixed-size image.
 * The original black and white (bilevel) images from NIST were size normalized to fit in a 20x20 pixel box while
 * preserving their aspect ratio. The resulting images contain grey levels as a result of the anti-aliasing technique
 * used by the normalization algorithm. the images were centered in a 28x28 image by computing the center of mass of the
 * pixels, and translating the image so as to position this point at the center of the 28x28 field.
 *
 * Getting the dataset as a PNG format (https://github.com/myleott/mnist_png)
 *
 *
 * Ressources :
 * https://en.wikipedia.org/wiki/Optical_character_recognition
 * https://github.com/saibot94/scala-ocr-parser
 * http://tess4j.sourceforge.net/
 * https://towardsdatascience.com/ocr-with-akka-tesseract-and-javacv-part-1-702781fc73ca
 * https://towardsdatascience.com/a-gentle-introduction-to-ocr-ee1469a201aa
 *
 * Scala MNIST :
 * https://github.com/alno/scalann/blob/master/examples/src/main/scala/org/scalann/examples/Mnist.scala
 * https://github.com/saurfang/spark-knn/blob/master/spark-knn-examples/src/main/scala/com/github/saurfang/spark/ml/knn/examples/MNIST.scala
 */

object Main extends App with OCR {
//  def main(args: Array[String]) {
//    println( "Hello world");
//  }
  println( "Hello world")
}
