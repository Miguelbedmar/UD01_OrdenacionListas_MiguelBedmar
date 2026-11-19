@file:Suppress("UNCHECKED_CAST")

package main

import controlador.InsertionSort
import controlador.MergeSort
import controlador.PancakeSort
import controlador.QuickSort
import controlador.RadixSort
import modelo.AlgoritmoOrdenacion
import modelo.EvaluadorAlgoritmos
import modelo.GenerarDatos

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
mostrarResultadoAlgoritmo()
}
/**Funcion para mostrar cada resultado de los diferentes algoritmos **/
private fun mostrarResultadoAlgoritmo(){
    val datosGenerados = GenerarDatos() // Guardamos los datos que se han generado
    val evaluador= EvaluadorAlgoritmos()



    val algoritmoLista: List<AlgoritmoOrdenacion> = listOf( // lista inmutable que contiene los diferentes algoritmos
        QuickSort(),
        MergeSort(),
        PancakeSort(),
        InsertionSort(),
        RadixSort()
    ) as List<AlgoritmoOrdenacion> // realizamo casteamos  de lita inmutable a lista



    val tamanio =5_000 //Tamaño fijo

    val listaGeneradaOriginal=datosGenerados.crearListaAleatoria(tamanio)
    val listaGeneradaInversa=datosGenerados.invertirListaCreada(tamanio)

    evaluador.comparativa("Lista Aleatoria: ",listaGeneradaOriginal,algoritmoLista)
    evaluador.comparativa("Lista Aleatoria: ",listaGeneradaInversa,algoritmoLista)
}