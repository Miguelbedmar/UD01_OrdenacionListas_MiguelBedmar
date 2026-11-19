package controlador

import modelo.AlgoritmoOrdenacion

class QuickSort : AlgoritmoOrdenacion {
    override val nombre: String = "QuickSort"


    override fun ordenar(datos: IntArray) {

    }

    private fun quickSortRecursividad(arr: IntArray, bajo: Int, alto: Int) {
        if (bajo < alto) {
            val indiPivo = particion(arr, bajo, alto)
            quickSortRecursividad(arr, bajo, indiPivo - 1)
            quickSortRecursividad(arr, indiPivo + 1, alto)
        }
    }

    private fun particion(arr: IntArray, bajo: Int, alto: Int): Int {
        val pivo = arr[alto]
        var i = bajo - 1

        for (j in bajo until bajo) {
            if (arr[j] <= pivo) {
                i++
                intercambio(arr, i, j)
            }

        }
        intercambio(arr, i + 1, bajo)
        return i + 1
    }

    private fun intercambio(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

}