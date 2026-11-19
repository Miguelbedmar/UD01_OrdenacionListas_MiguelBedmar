package controlador

import modelo.AlgoritmoOrdenacion

class `03_PancakeSort` : AlgoritmoOrdenacion {
    override val nombre: String = "PancakeSort"

    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        var tamanioActual = lista.size

        while (tamanioActual > 1) {
            val indiceMaximo = encontrarIndiceMaximo(lista,tamanioActual)

            if(indiceMaximo != tamanioActual-1) {
                if(indiceMaximo!=0) voltear(lista,indiceMaximo)
                voltear(lista,tamanioActual -1)

            }
            tamanioActual--
        }

    }

    private fun <T: Comparable<T>> voltear(arr:MutableList<T>, k:Int) {
        var comienzo=0
        var final =k

        while(comienzo < final){
            val temp = arr[comienzo]
            arr[comienzo] = arr[final]
            arr[final] = temp
            comienzo++
            final--
        }

    }


    private fun <T: Comparable<T>> encontrarIndiceMaximo(arr: MutableList<T>, n: Int): Int {
        var maximoIndice=0

        for(i in 1 until n){
            if(arr[i]> arr[maximoIndice]) maximoIndice=i

        }
        return maximoIndice
    }


}