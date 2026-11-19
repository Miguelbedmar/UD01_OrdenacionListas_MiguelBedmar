package controlador

import modelo.AlgoritmoOrdenacion

/**Es un algoritmo basado en divide y venceras que divide la lista y la ordena de menor a mayor
 * donde los elementos menores  se quedaran hacia la izquierda y los mayores a la derecha **/
class `04_QuickSort` : AlgoritmoOrdenacion {
    override val nombre: String = "QuickSort"

    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        if(lista.size <=1) return // Comprobamos que la lista contenga al menos 1 elemento en el caso de que cumpla finaliza porque  ya estaria ordenada
        quickSortRecursividad(lista, 0, lista.size - 1) // Iniciamos un proceso recursivo en caso de  no estar ordenada

    }



    private fun <T : Comparable<T>> quickSortRecursividad(arr: MutableList<T>, bajo: Int, alto: Int) {
        if (bajo < alto) {  // Siempre y cuando existan dos elementos en la tienda se llamara a particion
            val indiPivo = particion(arr, bajo, alto)
            quickSortRecursividad(arr, bajo, indiPivo - 1) // Ordenamos  de forma independiente  de la particion de la izquierda
            quickSortRecursividad(arr, indiPivo + 1, alto) //Mismo proceso para la particion de la derecha
        }
    }

    private fun <T : Comparable<T>> particion(arr: MutableList<T>, bajo: Int, alto: Int): Int {
        val pivo = arr[alto]  // Referencia pivote o del ultimo elemento de la lista
        var i = bajo - 1
        //Recoremos los segmentos menores  o iguales  a la referencia  desplazando  hacia la izquierda todos los elementos menores
        for (j in bajo until alto) {
            if (arr[j] <= pivo) {
                i++
                intercambio(arr, i, j)
            }

        }
        intercambio(arr, i + 1, alto)
        return i + 1 // Devolvemos la posicion exacta 
    }

    //Funcion auxiliar  que intercambia  la posicion de dos elemento de una lista dentro de una constante temporal
    private fun  <T : Comparable<T>> intercambio(arr: MutableList<T>, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

}