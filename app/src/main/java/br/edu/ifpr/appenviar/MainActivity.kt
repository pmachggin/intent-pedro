package br.edu.ifpr.appenviar

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btEnviar.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            with(shareIntent) {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Conteúdo!")
                putExtra(Intent.EXTRA_TEXT, ptText.text.toString())
            }
            startActivity(shareIntent)
        }

        img.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 125)

            
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val shareIntent : Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, data?.data)
            type = "image/*"
        }
        startActivity(shareIntent)
    }

}

