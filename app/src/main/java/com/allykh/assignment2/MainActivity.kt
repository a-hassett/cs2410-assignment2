package com.allykh.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

import android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout.LayoutParams.MATCH_PARENT

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var history = DoublyLinkedList()
        super.onCreate(savedInstanceState)

        val mainLayout = LinearLayout(this).apply{
            orientation = LinearLayout.VERTICAL
        }
        val buttonLayout = LinearLayout(this).apply{
            orientation = LinearLayout.HORIZONTAL
        }
        val webView = WebView(this).apply{
            webViewClient = WebViewClient()
        }

        val searchBar = EditText(this).apply{
            layoutParams = LinearLayout.LayoutParams(675, WRAP_CONTENT)
        }
        val backButton = Button(this).apply{
            text = "<<"
            layoutParams = LinearLayout.LayoutParams(100, WRAP_CONTENT)

            setOnClickListener{
                val backLink : String = history.goBack()
                if(backLink != ""){
                    searchBar.setText(backLink)
                    webView.loadUrl(backLink)
                }
            }
        }
        val forwardButton = Button(this).apply{
            text = ">>"
            layoutParams = LinearLayout.LayoutParams(100, WRAP_CONTENT)

            setOnClickListener{
                val forwardLink : String = history.goForward()
                if(forwardLink != ""){
                    searchBar.setText(forwardLink)
                    webView.loadUrl(forwardLink)
                }
            }
        }
        val goButton = Button(this).apply{
            text = "GO"
            layoutParams = LinearLayout.LayoutParams(200, WRAP_CONTENT)

            setOnClickListener{
                history.addNew(searchBar.text.toString())
                webView.loadUrl(searchBar.text.toString())
            }
        }

        buttonLayout.addView(backButton)
        buttonLayout.addView(forwardButton)
        buttonLayout.addView(searchBar)
        buttonLayout.addView(goButton)

        mainLayout.addView(buttonLayout)
        mainLayout.addView(webView)
        setContentView(mainLayout)
    }
}
