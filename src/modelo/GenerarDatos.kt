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
    fun ordenar(datos: IntArray)
}

class GenerarDatos{ // 
    fun crearListaAleatoria(tamanio: Int, valorMaximo:Int=100_000): IntArray{
        return IntArray(tamanio){ Random.nextInt(0,valorMaximo) }
    }

    fun invertirListaCreada (tamanio: Int): IntArray{
        return IntArray(tamanio){tamanio-it}
    }

}
class EvaluadorAlgoritmos{

    fun comparativa(nombreLista:String,
                    dato: IntArray,
                    algoritmo:List<AlgoritmoOrdenacion>){

        println("Resultados  de $nombreLista (${dato.size} elementos)")

        for (algoritmoOrdenacion in algoritmo){
            val copiaDato=dato.copyOf()

            val tiempoNanoSegundo=measureNanoTime {
                algoritmoOrdenacion.ordenar(copiaDato)

            }

            val tiempoMs = tiempoNanoSegundo/1_000_000
            val listaOrdenada = isOrdenado(copiaDato)

            println("$-20 |Tiempo: %10.4ms  | ListaOrdenada:  %b".format(algoritmoOrdenacion.nombre, tiempoMs, listaOrdenada))
        }
    }

    private fun  isOrdenado (arr:IntArray): Boolean{
        for( i in 0 until arr.size-1){
            if(arr[i]>arr[i+1]) return false

        }
        return true
    }
}
