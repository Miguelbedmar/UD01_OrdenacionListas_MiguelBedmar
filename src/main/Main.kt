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

private fun mostrarResultadoAlgoritmo(){
    val datosGenerados = GenerarDatos()
    val evaluador= EvaluadorAlgoritmos()



    val algoritmoLista: List<AlgoritmoOrdenacion> = listOf(
        QuickSort(),
        MergeSort(),
        PancakeSort(),
        InsertionSort(),
        RadixSort()
    ) as List<AlgoritmoOrdenacion>



    val tamanio =5_000

    val listaGeneradaOriginal=datosGenerados.crearListaAleatoria(tamanio)
    val listaGeneradaInversa=datosGenerados.invertirListaCreada(tamanio)

    evaluador.comparativa("Lista Aleatoria: ",listaGeneradaOriginal,algoritmoLista)
    evaluador.comparativa("Lista Aleatoria: ",listaGeneradaInversa,algoritmoLista)
}