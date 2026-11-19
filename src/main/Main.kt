@file:Suppress("UNCHECKED_CAST")

package main

import controlador.`01_InsertionSort`
import controlador.`02_MergeSort`
import controlador.`03_PancakeSort`
import controlador.`04_QuickSort`
import controlador.`05_HeapSort`
import modelo.AlgoritmoOrdenacion
import modelo.Evaluador
import modelo.GenerarDatos

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
mostrarResultadoAlgoritmo()
}
/**Funcion para mostrar cada resultado de los diferentes algoritmos **/
private fun mostrarResultadoAlgoritmo(){
    val datosGenerados = GenerarDatos() // Guardamos los datos que se han generado
    val evaluador= Evaluador()



    val algoritmoLista: List<AlgoritmoOrdenacion> = listOf( // lista inmutable que contiene los diferentes algoritmos
        `04_QuickSort`(),
        `02_MergeSort`(),
        `03_PancakeSort`(),
        `01_InsertionSort`(),
        `05_HeapSort`()
    ) as List<AlgoritmoOrdenacion> // realizamo casteamos  de lita inmutable a lista



    val tamanio =5_000 //Tamaño fijo

    val listaGeneradaVehiculo=datosGenerados.obtenerListaVehiculos()
    val listaGeneradaNumerica=datosGenerados.obtenerListaNumerica()

    evaluador.comparativa("Lista Vehiculo: ",listaGeneradaVehiculo,algoritmoLista)
    evaluador.comparativa("Lista Numerica: ",listaGeneradaNumerica,algoritmoLista)
}