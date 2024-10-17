package com.example.srodenas.simulacioncrud.Views

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.srodenas.simulacioncrud.Logic.Client
import com.example.srodenas.simulacioncrud.Logic.Controller
import com.example.srodenas.simulacioncrud.Logic.interfaces.OperationsInterface
import com.example.srodenas.simulacioncrud.R

class MainActivity : AppCompatActivity(), OperationsInterface, OnClickListener {
    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView
    private lateinit var myDialog : Dialog
    private lateinit var button : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private val controller= Controller()

    companion object {
        const val TAG = "---SALIDA---"
    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button3 = findViewById(R.id.myButton3)
        button4 = findViewById(R.id.myButton4)
        button5 = findViewById(R.id.myButton5)
        button5.setOnClickListener { Toast.makeText(this, "Saludos desdel el botón 5", Toast.LENGTH_LONG).show()}
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
  //      enableEdgeToEdge()  //barra superior transparente. App de borde a borde (toaaaa)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        Log. d(TAG, "Esto es un ejemplo de log")
        start()
    }




    //Aquí comienza todo. Como si fuera nuestro main
    private fun start() {
        myButtonAdd = findViewById(R.id.myButtonAdd)   //Recuperamos la referencia en memoria del botón de la interfaz.
        myButtonUpdate = findViewById(R.id.myButtomEdit)
        myButtonDel = findViewById(R.id.myButtomDel)
        button = findViewById(R.id.myButton)

        myDialog = Dialog(controller)

        myDialog.setListener(this) //Le paso mi referencia como objeto que estoy obligado a implementar los tres métodos.

        myButtonAdd.setOnClickListener{
            //acepta una lambda, por tanto es una referencia a una función anónima.
            myDialog.show(0)  //mostramos el dialogo que me permite la inserción de datos en los campos de edición.
        }

        myButtonUpdate.setOnClickListener{
            myDialog.show(1)  //mostramos el dialogo que me permite la edición de datos en los campos de edición.
        }

        myButtonDel.setOnClickListener( {
            myDialog.show(2)  //mostramos el dialogo que me permite la eliminación de datos en los campos de edición.
        })


    }


    override fun ClientAdd(id: Int, name: String){
        val newClient = Client (id, name)
        controller.ClientAddController(newClient)
        var msg =  "El cliente con id = $id, ha sido insertado correctamente"

        Log.d(TAG, msg)
        showConsoleData(msg)
    }

    override fun ClientDel(id: Int) {
        var msg = ""
        val delete = controller.ClientDelController(id)  //borramos

        if (delete)
             msg =  "El cliente con id = $id, ha sido eliminado correctamente"
        else
            msg = "El cliente con id = $id, no ha sido encontrado para eliminar"

        Log. d(TAG, msg)
        showConsoleData(msg)

    }

    override fun ClientUpdate(id: Int, name: String) {
        var msg = ""
        val update = controller.ClientUpdateController(id, name)  //borramos el 2.

        if (update)
            msg =  "El cliente con id = $id, ha sido eliminado correctamente"
        else
            msg = "El cliente con id = $id, no ha sido encontrado para eliminar"

        Log. d(TAG, msg)
        showConsoleData(msg)

    }

    fun showConsoleData(msg:String){
        val msg = controller.showData()
        Thread.sleep(2000)
        Log. d(TAG, msg)
    }

    fun saludarASanti(view : View){
        if (view.id == R.id.myButton)
            Toast.makeText(this, "Eyyy muy buenas a todos", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, "Eyyy muy buenas a todos desde el boton dos", Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?){
        if (v?.id == R.id.myButton3)
            Toast.makeText(this, "Os saludo Desde el boton 3", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, "Os saludo Desde el boton 4", Toast.LENGTH_LONG).show()

    }


}