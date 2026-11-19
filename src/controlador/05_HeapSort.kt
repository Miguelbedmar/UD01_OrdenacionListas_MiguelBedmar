package controlador

import modelo.AlgoritmoOrdenacion

/**HeapSort recibe una lista  y la convierte en un arbol binario pero tiene un detalle importante  y es que
 * el padre siempre será mayor que los hijos  es decir si el padre es  A  y los hijos B y C  A siempre sera mayor
 * que sus hijos */
class `05_HeapSort` : AlgoritmoOrdenacion {
    override val nombre: String ="HeapSort"

    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        val n =lista.size

        for(i in n /2-1 downTo 0) { //Recorremos la lista desde la primera mitad hacia atras
            organizarArbol(lista,n,i) // Llamamos a organizarArbol
        }

        for(i in n-1 downTo 1) { //Intercambiamos el primer elemento   con el último elemento de la lista
            intercambiar(lista,0,i)
            organizarArbol(lista,i,0)
        }
    }

    }



    private fun <T: Comparable<T>> organizarArbol(arr: MutableList<T>,n:Int,raiz: Int) {
        var padreMayor =raiz

        val izq = 2* raiz +1 // Comparamos el nodo padre  con el hijo izquierdo
        val dec =2*raiz +2 // Misma comapracion con el hijo derecho

        /**Comprobamos si alguno de los hijos es mayor  en el caso de que sea correcto  el metodo se llama a si misma
         * para que el arbol tenga la jerarquia correcta **/
        if( izq<n&& arr[izq]> arr[padreMayor]) padreMayor = izq
        if (dec <n && arr[dec]> arr[padreMayor]) padreMayor = dec

        if( padreMayor != raiz){
        intercambiar(arr, raiz, padreMayor) // Intercambiamos el hijo mayor con el padre para mantener la jerarquia
        organizarArbol(arr, n, padreMayor) // Llamada recursiva
        }
    }
    //Funcion auxiliar que permite permutar los datos  de dos posiciones de la lista con una constante  temporal.
    private fun <T> intercambiar ( arr: MutableList<T>, i:Int, j: Int) {
        val temp = arr[i]
        arr[i]= arr[j]
        arr[j] = temp
    }

