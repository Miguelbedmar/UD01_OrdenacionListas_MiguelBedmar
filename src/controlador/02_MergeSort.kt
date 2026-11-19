package controlador

import modelo.AlgoritmoOrdenacion

/**Es un algoritmo que utiliza Divide y Venceras en su base que dice que cualquier problema si se desloga en pequeños
 * bloques  poco a poco podrás vencer al problem . En otras palabras  divide la lista  de dos en dos, la primera division sera
 * dos bloques la siguiente cuatro  así sucesivamente  hasta  volver a construir la lista**/
class `02_MergeSort` : AlgoritmoOrdenacion {
    override val nombre: String = "MergeSort"
    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        if (lista.size <= 1) return // Comprobamos el tamnio de la lista
        invertir(lista,0,lista.size-1) // Llamamos a invertir para ordenar de menor a mayor

    }

    private fun <T: Comparable<T>> invertir(arr: MutableList<T>, izq: Int, dec: Int) {
        if (izq < dec) { // Comprobamos que la lista tenga dos segmentos
            val medio = izq + (dec - izq) / 2 // Obtenemos el indice central de la lista
            invertir(arr, izq, medio) //Dividimos el segmento de la  izquierda  con recursividad
            invertir(arr, medio + 1, dec) // Realizamos el mismo proceso con el segmento de la derecha
            mezclaMergeSort(arr, izq, medio,dec) // Llamamos a mezclaMergeSort para volver a unir los segmentos
        }

    }
    private fun <T: Comparable<T>> mezclaMergeSort(arr: MutableList<T>, izq: Int, medio: Int, dec: Int) {
        val n1 = medio - izq + 1
        val n2 = dec - medio
        /**Creamos dos listas  auxiliares  **/
        val izqArray = arr.subList(izq,izq +n1).toMutableList()
        val decArray =arr.subList(medio+1,medio+1+n2).toMutableList()

        var i = 0
        var k = izq
        var j = 0
        // Recoremos ambas listas auxiliares
        while (i < n1 &&j<n2) {
            if(izqArray[i]<=decArray[j]){
                arr[k]= izqArray[i]
                i++
            }else{
                arr[k] = decArray[j]
                j++
            }
            k++

        }
        //Copiamos y verificamos de cualquier elemento sobrante
        while(i<n1){
            arr[k]= izqArray[i]
            i++
            k++
        }
        while(j<n2){
            arr[k]= decArray[j]
            j++
            k++
        }
    }
}