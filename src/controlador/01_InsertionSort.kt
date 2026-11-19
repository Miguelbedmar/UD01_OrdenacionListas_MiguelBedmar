package controlador

import modelo.AlgoritmoOrdenacion

/** Se encarga de recorrer una lista y coger elemento por elemento  insertandolo
 * en su posicion correspondiente por ejemplo  si tenemos una lista númerica que contiene
 * 3,4,5,2,1
 * Devolvera 1,2,3,4,5 ya que ordenara en sentido menor a mayor .
 * **/
class `01_InsertionSort`() : AlgoritmoOrdenacion {

    override val nombre: String = "Insertion Sort" // INdicamos el nombre del algoritmo

    /***El metodo primero obtiene el tamaño de la lista  para evitar perder los datos lo guardamos
     * dentro de una constante   , posteriormente recorremos la lista hasta el tamaño de la misma
     * lo que iremos haciendo sera comprobar cada elemento y quienes sean menor  se colocaran en un orden
     *  hasta llegar al maximo valor de la lista.
     * */
    override fun <T : Comparable<T>> ordenar(lista: MutableList<T>) {
        val n = lista.size

        for (i in 1 until n) {
            val llave = lista[i]
            var j = i - 1

            while (j >= 0 && lista[j] > llave) {
                lista[j + 1] = lista[j]
                j--
            }
            lista[j + 1] = llave
        }
    }


}