package main.scala

import javafx.scene.input
import main.scala.Main.setStage
import os.Path
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.{Alert, Button, Label}
import scalafx.scene.image.Image
import scalafx.scene.layout.{AnchorPane, VBox}
import scalafx.scene.paint.Color.Black

object View {
  def refresh(windowWidth : Double, windowHeight : Double, canvas: Canvas, imagesIterator: Iterator[Path]):
  PrimaryStage = {
    val graphicsContext: GraphicsContext = canvas.graphicsContext2D
    val imagePath: String = imagesIterator.next.toString.replace("\\", "/")
    val imageRelPath: String = imagePath.substring(imagePath.lastIndexOf("/main"), imagePath.length)
    System.out.println(imagePath)
    System.out.println(imageRelPath)
    val image = new Image(imageRelPath, canvas.getWidth, canvas.getHeight, false, false)

    val pattern = "\\d".r
    val folderIdx = pattern.findFirstIn(imageRelPath).head
    System.out.println(folderIdx)

    new PrimaryStage {
      title = "Scala OCR"
      resizable = false
      width = windowWidth
      height = windowHeight
      scene = new Scene {
        fill = Black
        root = new VBox {
          val answerText: Label = new Label {text = "Label : " + folderIdx}
          val outputText: Label = new Label {text = "Output : "}
          val previousButton: Button = new Button {
            text = "Previous"
            disable = true
          }
          val nextButton: Button = new Button {
            text = "Next"
            onMouseClicked = (_: input.MouseEvent) => {
              if (imagesIterator.hasNext)
                setStage(refresh(windowWidth, windowHeight, canvas, imagesIterator))
              else
                new Alert(AlertType.Error) {
                  title = "Error"
                  headerText = "No more images to show !"
                  contentText = "Please restart the program or choose more images in the Main file"
                }.showAndWait()
            }
          }
          AnchorPane.setTopAnchor(answerText, 0)
          AnchorPane.setLeftAnchor(answerText, canvas.getWidth/2 - 35)
          AnchorPane.setTopAnchor(outputText, 70)
          AnchorPane.setLeftAnchor(outputText, canvas.getWidth/2 - 35)
          AnchorPane.setLeftAnchor(previousButton, 20)
          AnchorPane.setTopAnchor(previousButton, 30)
          AnchorPane.setRightAnchor(nextButton, 20)
          AnchorPane.setTopAnchor(nextButton, 30)
          val pane: AnchorPane = new AnchorPane {
            children = Seq(answerText, previousButton, nextButton, outputText)
          }

          spacing = 20.0
          children = List(canvas, pane)
        }
      }
      graphicsContext.drawImage(image, 0, 0)
    }
  }
}
