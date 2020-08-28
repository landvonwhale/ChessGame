package com.example.demo.view


import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import tornadofx.*
import kotlin.math.floor


class MainView : View() {
    val squares = mutableListOf<javafx.scene.shape.Rectangle>()
    var lastSelected = Rectangle()

    override val root = stackpane {
        group {
            //shapes will go here
            var isBlack = true


            for(row in 0..700 step 100)
            {
                for(col in 0..700 step 100)
                {
                    rectangle(width = 100, height = 100) {
                        x = col.toDouble()
                        y = row.toDouble()

                        if(isBlack)
                        {
                            fill = Color.color(0.93333333333333333333333333333333,0.93333333333333333333333333333333,0.82352941176470588235294117647059)
                            isBlack = false
                        }
                        else{
                            fill = Color.color(0.46274509803921568627450980392157,0.58823529411764705882352941176471,0.33725490196078431372549019607843)
                            isBlack = true
                        }
                        squares.add(this)
                    }




                }

                isBlack = isBlack != true

            }
        }
        addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, :: onPress)
    }

    fun onPress(evt : javafx.scene.input.MouseEvent){
        if (lastSelected != null)
        {
            if(lastSelected.fill == Color.color(0.72941176470588235294117647058824,0.7921568627450980392156862745098,0.26666666666666666666666666666667)){
                lastSelected.fill = Color.color(0.46274509803921568627450980392157,0.58823529411764705882352941176471,0.33725490196078431372549019607843)
            }
            else if(lastSelected.fill == Color.color(0.96470588235294117647058823529412,0.96470588235294117647058823529412,0.41176470588235294117647058823529)){
                lastSelected.fill = Color.color(0.93333333333333333333333333333333,0.93333333333333333333333333333333,0.82352941176470588235294117647059)
            }
        }

        val x = floor(evt.sceneX / 100.0) * 100
        val y = floor(evt.sceneY / 100.0) * 100

        val selectedSquare = squares.find {it.x == x && it.y == y}

        if (selectedSquare != null) {
            if(selectedSquare.fill == Color.color(0.46274509803921568627450980392157,0.58823529411764705882352941176471,0.33725490196078431372549019607843)){
                selectedSquare.fill = Color.color(0.72941176470588235294117647058824,0.7921568627450980392156862745098,0.26666666666666666666666666666667)
            }
            else if(selectedSquare.fill == Color.color(0.93333333333333333333333333333333,0.93333333333333333333333333333333,0.82352941176470588235294117647059)){
                selectedSquare.fill = Color.color(0.96470588235294117647058823529412,0.96470588235294117647058823529412,0.41176470588235294117647058823529)
            }
            lastSelected = selectedSquare
        }

    }

}

