package controlador

import modelo.AlgoritmoOrdenacion

/**El algoritmo pancakeSort fue bautizado como  pancake porque realiza el mismo proceso de preparacion
 * Imaginemos por un momento que estamos realizando unos pancakes  llega un momento del proceso
 * que tenemos que voltearla  pues este algoritmo  voltea los primeros elementos de la lista  por cada
 * paso que da , hasta llegar al ultimo elemento  , al llegar lo elevara hasta la primera posicion
 * y lo voltea**/
class `03_PancakeSort` : AlgoritmoOrdenacion {
    override val nombre: String = "PancakeSort"

    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        var tamanioActual = lista.size // Obtenemos el tamaño actual de la lista

        while (tamanioActual > 1) { //Bucle principal y encargado de reducir el tamaño hasta llegar  a dos
            val indiceMaximo = encontrarIndiceMaximo(lista,tamanioActual)

            if(indiceMaximo != tamanioActual-1) {
                if(indiceMaximo!=0) voltear(lista,indiceMaximo)
                voltear(lista,tamanioActual -1)

            }
            tamanioActual-- // Reducimos el tamaño de la lista
        }

    }

    private fun <T: Comparable<T>> voltear(arr:MutableList<T>, k:Int) {
        // Inicializamos dos punteros uno que indique el inicio y final
        var comienzo=0
        var final =k

        /** Recorrera la lista intercambiando elementos hasta conseguir dar la vuelta
         * desde el comienzo  hasta  final **/
        while(comienzo < final){
            val temp = arr[comienzo]
            arr[comienzo] = arr[final]
            arr[final] = temp
            comienzo++
            final--
        }

    }


    private fun <T: Comparable<T>> encontrarIndiceMaximo(arr: MutableList<T>, n: Int): Int {
        var maximoIndice=0 // Inicializamos

        for(i in 1 until n){  // Recorremos la lista hasta encontrar el indice de mayor tamaño
            if(arr[i]> arr[maximoIndice]) maximoIndice=i

        }
        return maximoIndice // Devolvemos el indice
    }


}