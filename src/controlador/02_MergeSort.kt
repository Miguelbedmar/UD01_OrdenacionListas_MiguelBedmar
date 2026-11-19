package controlador

import modelo.AlgoritmoOrdenacion

class `02_MergeSort` : AlgoritmoOrdenacion {
    override val nombre: String = "MergeSort"
    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        if (lista.size <= 1) return
        invertir(lista,0,lista.size-1)


    }




    private fun <T: Comparable<T>> invertir(arr: MutableList<T>, izq: Int, dec: Int) {
        if (izq < dec) {
            val medio = izq + (dec - izq) / 2
            invertir(arr, izq, medio)
            invertir(arr, medio + 1, dec)
            mezclaMergeSort(arr, izq, medio,dec)
        }

    }

    private fun <T: Comparable<T>> mezclaMergeSort(arr: MutableList<T>, izq: Int, medio: Int, dec: Int) {
        val n1 = medio - izq + 1
        val n2 = dec - medio

        val izqArray = arr.subList(izq,izq +n1).toMutableList()
        val decArray =arr.subList(medio+1,medio+1+n2).toMutableList()

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