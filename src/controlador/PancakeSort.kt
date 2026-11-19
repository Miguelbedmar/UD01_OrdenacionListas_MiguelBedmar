package controlador

import modelo.AlgoritmoOrdenacion

class PancakeSort : AlgoritmoOrdenacion {
    override val nombre: String = "PancakeSort"

    override fun ordenar(datos: IntArray) {
        var tamanioActual = datos.size

        while (tamanioActual > 1) {
            val indiceMaximo = encontrarIndiceMaximo(datos,tamanioActual)

            if(indiceMaximo != tamanioActual-1) {
                if(indiceMaximo!=0) voltear(datos,tamanioActual)


                voltear(datos,tamanioActual -1)

            }
            tamanioActual--
        }
    }

    private fun voltear(arr:IntArray,k:Int) {
        var comienzo=0
        var final =0

        while(comienzo < final){
            val temp = arr[comienzo]
            arr[comienzo] = arr[final]
            arr[final] = temp
            comienzo++
            final--
        }

    }


    private fun encontrarIndiceMaximo(arr: IntArray, n: Int): Int {
        var maximoIndice=0

        for(i in 1 until n){
            if(arr[i]> arr[maximoIndice]) maximoIndice=i

        }
        return maximoIndice
    }


}