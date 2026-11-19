package controlador

import modelo.AlgoritmoOrdenacion

class `01_InsertionSort`() : AlgoritmoOrdenacion {

    override val nombre: String = "Insertion Sort" // INdicamos el nombre del algoritmo


    override fun ordenar(datos: IntArray) {
        val n = datos.size

        for (i in 1 until n) {
            val llave = datos[i]
            var j = i - 1

            while (j >= 0 && datos[j] > llave) {
                datos[j + 1] = datos[j]
                j--
            }
            datos[j + 1] = llave
        }
    }
}