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
import main.scala.Controller.ocr

object View {
  def refresh(windowWidth : Double, windowHeight : Double, canvasOriginal : Canvas, canvasProcessed : Canvas,
              imagesIterator: Iterator[Path]):
  PrimaryStage = {
    val graphicsContextOriginal: GraphicsContext = canvasOriginal.graphicsContext2D
    val graphicsContextProcessed: GraphicsContext = canvasProcessed.graphicsContext2D
    val imagePath: String = imagesIterator.next.toString.replace("\\", "/")
    val imageRelPath: String = imagePath.substring(imagePath.lastIndexOf("/main"), imagePath.length)
//    System.out.println(imagePath)
    System.out.println(imageRelPath)
    val image = new Image(imageRelPath, canvasOriginal.getWidth, canvasOriginal.getHeight, true, false)

    new PrimaryStage {
      title = "Scala OCR"
      resizable = false
      width = windowWidth
      height = windowHeight
      scene = new Scene {
        fill = Black
        root = new VBox {
          val outputText: Label = new Label {text = "Output : " + ocr(imageRelPath)}
          val previousButton: Button = new Button {
            text = "Previous"
            disable = true
          }
          val nextButton: Button = new Button {
            text = "Next"
            onMouseClicked = (_: input.MouseEvent) => {
              if (imagesIterator.hasNext)
                setStage(refresh(windowWidth, windowHeight, canvasOriginal, canvasProcessed, imagesIterator))
              else
                new Alert(AlertType.Error) {
                  title = "Error"
                  headerText = "No more images to show !"
                  contentText = "Please restart the program or choose more images in the Main file"
                }.showAndWait()
            }
          }
          AnchorPane.setTopAnchor(outputText, 50)
          AnchorPane.setLeftAnchor(outputText, canvasOriginal.getWidth/2 - 35)
          AnchorPane.setLeftAnchor(previousButton, 20)
          AnchorPane.setTopAnchor(previousButton, 30)
          AnchorPane.setRightAnchor(nextButton, 20)
          AnchorPane.setTopAnchor(nextButton, 30)
          val pane: AnchorPane = new AnchorPane {
            children = Seq(previousButton, nextButton, outputText)
          }

          spacing = 20.0
          children = List(canvasOriginal, canvasProcessed, pane)
        }
      }
      graphicsContextOriginal.clearRect(0,0, canvasOriginal.getWidth, canvasOriginal.getHeight)
      graphicsContextOriginal.drawImage(image, 0, 0)
      graphicsContextProcessed.clearRect(0,0, canvasProcessed.getWidth, canvasProcessed.getHeight)
      graphicsContextProcessed.drawImage(image, 0, 0)
    }
  }
}
