package modelo
import kotlin.random.Random
import kotlin.system.measureNanoTime
interface AlgoritmoOrdenacion{
    val nombre: String
    fun ordenar(datos: IntArray)
}

class GenerarDatos{
    fun crearListaAleatoria(tamanio: Int, valorMaximo:Int=100_000): IntArray{
        return IntArray(tamanio){ Random.nextInt(0,valorMaximo) }
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

            println()

        }
    }

    private fun  isOrdenado (arr:IntArray): Boolean{
        for( i in 0 until arr.size-1){
            if(arr[i]>arr[i+1]) return false

        }
        return true
    }
}
