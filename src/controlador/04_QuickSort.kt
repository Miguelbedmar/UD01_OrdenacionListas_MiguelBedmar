package controlador

import modelo.AlgoritmoOrdenacion

/**Es un algoritmo basado en divide y venceras que divide la lista y la ordena de menor a mayor
 * donde los elementos menores  se quedaran hacia la izquierda y los mayores a la derecha **/
class `04_QuickSort` : AlgoritmoOrdenacion {
    override val nombre: String = "QuickSort"

    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        if(lista.size <=1) return // Comprobamos que la lista contenga al menos 1 elemento en el caso de que cumpla finaliza porque  ya estaria ordenada
        quickSortRecursividad(lista, 0, lista.size - 1)

    }



    private fun <T : Comparable<T>> quickSortRecursividad(arr: MutableList<T>, bajo: Int, alto: Int) {
        if (bajo < alto) {
            val indiPivo = particion(arr, bajo, alto)
            quickSortRecursividad(arr, bajo, indiPivo - 1)
            quickSortRecursividad(arr, indiPivo + 1, alto)
        }
    }

    private fun <T : Comparable<T>> particion(arr: MutableList<T>, bajo: Int, alto: Int): Int {
        val pivo = arr[alto]
        var i = bajo - 1

        for (j in bajo until alto) {
            if (arr[j] <= pivo) {
                i++
                intercambio(arr, i, j)
            }

        }
        intercambio(arr, i + 1, alto)
        return i + 1
    }

    private fun  <T : Comparable<T>> intercambio(arr: MutableList<T>, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

}