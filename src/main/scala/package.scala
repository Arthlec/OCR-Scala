package main

import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.control.{Button, Label}
import scalafx.scene.image.Image
import scalafx.scene.layout.{AnchorPane, VBox}
import scalafx.scene.paint.Color.Black

package object view {
  def refresh(windowWidth : Double, windowHeight : Double, canvas: Canvas, graphicsContext: GraphicsContext,
              image: Image): PrimaryStage = {
    new PrimaryStage {
      title = "Scala OCR"
      resizable = false
      width = windowWidth
      height = windowHeight
      scene = new Scene {
        fill = Black
        root = new VBox {
          val answerText: Label = new Label {text = "Answer : "}
          val outputText: Label = new Label {text = "Output : "}
          val previousButton: Button = new Button {
            text = "Previous"
            disable = true
          }
          val nextButton: Button = new Button {text = "Next"}
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
