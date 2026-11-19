package controlador

import modelo.AlgoritmoOrdenacion

class `05_HeapSort` : AlgoritmoOrdenacion {
    override val nombre: String ="05_HeapSort"

    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
    }



    private fun <T: Comparable<T>> organizarArbol(arr: MutableList<T>,n:Int,raiz: Int) {
        var padreMayor =raiz

        val izq = 2* raiz +1
        val dec =2*raiz +2

        if( izq<n&& arr[izq]> arr[padreMayor]) padreMayor = izq
        if (dec <n && arr[dec]> arr[padreMayor]) padreMayor = dec

        if( padreMayor != raiz){
        intercambiar(arr, raiz, padreMayor)
        organizarArbol(arr, n, padreMayor)
        }
    }

    private fun <T> intercambiar ( arr: MutableList<T>, i:Int, j: Int) {
        val temp = arr[i]
        arr[i]= arr[j]
        arr[j] = temp
    }

}