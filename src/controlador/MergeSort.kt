package controlador

import modelo.AlgoritmoOrdenacion

class MergeSort : AlgoritmoOrdenacion {
    override val nombre: String = "MergeSort"

    override fun ordenar(datos: IntArray) {
        if (datos.size <= 1) return
        invertir(datos,0,datos.size-1)
    }

    private fun invertir(arr: IntArray, izq: Int, dec: Int) {
        if (izq < dec) {
            val medio = izq + (dec - izq) / 2
            invertir(arr, izq, medio)
            invertir(arr, medio + 1, dec)
            mezclaMergeSort(arr, izq, medio,dec)
        }

    }

    private fun mezclaMergeSort(arr: IntArray, izq: Int, medio: Int, dec: Int) {
        val n1 = medio - izq + 1
        val n2 = dec - medio

        val izqArray = IntArray(n1)
        val decArray = IntArray(n2)


        for (i in 0 until n1) izqArray[i] = arr[izq + i]
        for (j in 0 until n2) decArray[j] = arr[medio + 1 + j]


        var i = 0
        var k = izq
        var j = 0

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