package controlador

import modelo.AlgoritmoOrdenacion
import kotlin.rem

class RadixSort : AlgoritmoOrdenacion {
    override val nombre: String ="RadixSort"


    override fun ordenar(datos: IntArray) {
       if(datos.isEmpty()) return

        val maximo =maximo(datos)
        var exp=1

        while(maximo/exp>0){
            contarPorDigito(datos,exp)
            exp*=10
        }
    }

    private fun maximo (arr:IntArray):Int{
     var max = arr[0]
     for ( i in 1 until arr.size){
         if(arr[i]>max )max = arr[i]
     }
        return max
    }

    private fun contarPorDigito(arr:IntArray,exp:Int){
        val n = arr.size

        val salida = IntArray(n)
        val digitoConteo = IntArray(10)

        for(i in 1 until 10){
            val digito =(arr[i]/exp)%10
            digitoConteo[digito]++
        }
        for ( i in 1 until 10){
            digitoConteo[i]+=digitoConteo[i-1]
        }

        for(i in n -1 downTo 0){
            val digito = (arr[i]/exp)%10
            salida[digitoConteo[digito]]--
        }

        for ( i in 0 until n ){
            arr[i]= salida[i]
        }
    }
}