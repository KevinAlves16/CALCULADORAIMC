package com.example.calcularimc

import android.R
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity


public class MainActivity() : ComponentActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }


}
class CalculadoraIMCActivity : AppCompatActivity() {
    var editPeso: EditText? = null
    var editAltura: EditText? = null
    private var textViewResultado: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)
        editPeso = findViewById<EditText>(R.id.edit)
        editAltura = findViewById<EditText>(R.id.edit)
        textViewResultado = findViewById<TextView>(R.id.text1)

        // Botão para calcular o IMC
        findViewById<View>(R.id.button1).setOnClickListener { view: View? -> calcularIMC() }
    }

    private fun calcularIMC() {
        val peso = editPeso!!.text.toString().toDouble()
        val altura = editAltura!!.text.toString().toDouble()

        // Fórmula do IMC: peso (kg) / (altura (m))^2
        val resultado = peso / (altura * altura)
        textViewResultado!!.text = String.format("Seu IMC é %.2f", resultado)
    }
}



