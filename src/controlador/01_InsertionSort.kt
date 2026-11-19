package controlador

import modelo.AlgoritmoOrdenacion

class `01_InsertionSort`() : AlgoritmoOrdenacion {

    override val nombre: String = "Insertion Sort" // INdicamos el nombre del algoritmo
    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        val n = lista.size

        for (i in 1 until n) {
            val llave = lista[i]
            var j = i - 1

            while (j >= 0 && lista[j] > llave) {
                lista[j + 1] = lista[j]
                j--
            }
            lista[j + 1] = llave
        }
    }


}