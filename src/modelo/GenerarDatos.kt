package modelo
import kotlin.random.Random
import kotlin.system.measureNanoTime

/**Creacion de interfaces y clases
 * Kotlin permite que en un solo fichero se pueden crear
 * multiples clases y interfaces sin necesidad de crear
 * individuales esto permite crear un ficheroque abarque
 * clases e interfaces que tengan relacion entre ellas.*/


interface AlgoritmoOrdenacion{  // Creamos la interfaz que   define el nombre del algoritmo y la funcion ordenar
    val nombre: String
    fun <T : Comparable<T>> ordenar(lista: MutableList<T>)}

class GenerarDatos {

    fun obtenerListaVehiculos(): MutableList<String> = mutableListOf(
        "Toyota Corolla", "Ford Mustang", "Seat Ibiza", "Volkswagen Golf", "Renault Clio",
        "Peugeot 208", "BMW Serie 3", "Audi A4", "Mercedes Clase C", "Hyundai Tucson",
        "Kia Sportage", "Nissan Qashqai", "Mazda CX-5", "Honda Civic", "Subaru Impreza",
        "Volvo XC60", "Fiat 500", "Alfa Romeo Giulia", "Citroën C4", "Opel Corsa",
        "Skoda Octavia", "Dacia Sandero", "Tesla Model 3", "Porsche 911", "Ferrari Roma",
        "Lamborghini Huracán", "Jeep Wrangler", "Land Rover Defender", "Mini Cooper", "Lexus NX",
        "Suzuki Swift", "Mitsubishi Outlander", "Cupra Formentor", "Jaguar F-Pace", "Maserati Ghibli",
        "Aston Martin Vantage", "Chevrolet Camaro", "Dodge Charger", "Lotus Elise", "Bentley Continental"
    )


    fun obtenerListaNumerica(): MutableList<Int> {
        return (1..10000).shuffled().take(100).toMutableList()
    }
}
fun <T : Comparable<T>> comparativa ( algoritmo : AlgoritmoOrdenacion, listaTitulo:String,original: MutableList<T> ) {
    val copiaDato = original.toMutableList()

    println("${algoritmo.nombre} | $listaTitulo")
    println("Lista Original : $original")
    val inicio = System.nanoTime()
    algoritmo.ordenar(copiaDato)
    val final = System.nanoTime()

    println("Lista ordenada : $copiaDato")
    println(" Tiempo : ${final - inicio} ns (${(final - inicio) / 1_000_000.0} ms)\n")
}




class Evaluador{

    fun <T : Comparable<T>> comparativa(nombreLista:String,
                                     dato: MutableList<T>,
                                     algoritmo:List<AlgoritmoOrdenacion>){

        println("Resultados  de $nombreLista (${dato.size} elementos)")

        for (algoritmoOrdenacion in algoritmo){
            val copiaDato=dato.toMutableList()

            val tiempoNanoSegundo=System.nanoTime()
            algoritmoOrdenacion.ordenar(copiaDato)
            val finTiempo = System.nanoTime()

            val tiempoNs = tiempoNanoSegundo - finTiempo
            val tiempoMs = tiempoNs/1_000_000.0
            val listaOrdenada = isOrdenado(copiaDato)

            println("%-18s | Tiempo: %10d ns  (%8.4f ms ) | ListaOrdenada:  %b".format(algoritmoOrdenacion.nombre,tiempoNs ,tiempoMs, listaOrdenada))
        }
    }

    private fun <T: Comparable<T>> isOrdenado (list: MutableList<T>): Boolean{
        for( i in 0 until list.size-1){
            if(list[i]>list[i+1]) return false

        }
        return true
    }
}
