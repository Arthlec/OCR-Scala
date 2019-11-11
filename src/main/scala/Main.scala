/***
 * Optical Character Recognition (OCR)
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
 * Other Datasets for future implementation :
 * https://lionbridge.ai/datasets/15-best-ocr-handwriting-datasets/
 *
 * *** Stanford Dataset (http://ai.stanford.edu/~btaskar/ocr/) ***
 * The tab delimited data file (letter.data.gz) contains a line for each letter, with its label, pixel values,
 * and several additional fields listed in letter.names file.
 * Columns : id, letter, next_id, word_id, position, fold, p_0_0, p_0_1, ...
 * Lettres en 16 x 8 pixels
 *
 *
 *
 *
 * Ressources :
 * https://docs.opencv.org/2.4/doc/tutorials/features2d/trackingmotion/harris_detector/harris_detector.html
 *
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

import os.RelPath
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.control.{Button, Label}
import scalafx.scene.image.Image
import scalafx.scene.layout.{AnchorPane, BorderPane, VBox}
import scalafx.scene.paint.Color._

object Main extends JFXApp with OCR {
  val windowHeight = 600
  val windowWidth = 400
  val canvas = new Canvas(400, 400)
  val wd = os.pwd/"src"
  System.out.println(wd)
  val datasetPath: RelPath = os.rel/"main"/"data"/"mnist_png"/"testing"
//  System.out.println(wd / datasetPath)
//  System.out.println(os.exists(wd / datasetPath))
//  System.out.println(os.isDir(wd / datasetPath))
//  System.out.println(os.list(wd / datasetPath))

  val image = new Image((datasetPath /"0"/"3.png").toString.replace("\\", "/"),
    canvas.getWidth, canvas.getHeight, false, false)
  val graphicsContext: GraphicsContext = canvas.graphicsContext2D

  stage = new PrimaryStage {
    title = "Scala OCR"
    width = windowWidth
    height = windowHeight
    scene = new Scene {
      fill = Black
      root = new VBox {
        val answerText: Label = new Label {text = "Answer : "}
        val outputText: Label = new Label {text = "Output : "}
        val previousButton: Button = new Button {text = "Previous"}
        val nextButton: Button = new Button {text = "Next"}
        AnchorPane.setTopAnchor(answerText, 0)
        AnchorPane.setLeftAnchor(answerText, canvas.getWidth/2 - 35)
        AnchorPane.setTopAnchor(outputText, 70)
        AnchorPane.setLeftAnchor(outputText, canvas.getWidth/2 - 35)
        AnchorPane.setLeftAnchor(previousButton, 20)
        AnchorPane.setTopAnchor(previousButton, 30)
        AnchorPane.setRightAnchor(nextButton, 20)
        AnchorPane.setTopAnchor(nextButton, 30)
        val pane = new AnchorPane {
          children = Seq(answerText, previousButton, nextButton, outputText)
        }

        spacing = 20.0
        children = List(canvas, pane)
      }
    }
  }
  graphicsContext.drawImage(image, 0, 0)
}
