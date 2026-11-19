# UD01_OrdenacionListas_MiguelBedmar
Proyecto creado por el alumno Miguel Bedmar Diaz de la Serna  de segundo de Desarrollo de Aplicaciones Multimedia

# 📋 Decripcion.
En este proyecto se trabajara cinco algoritmos tres obligatorios  QuickSort,PancakeSort,MergeSort  y dos opcionales RadixSort y InsertionSort.
de cada algoritmo se ha investigado su funcionamiento y donde sacan mas rendimientos

# 🎯Objetivo.
El objetivo del proyecto en saber identificar que algoritmo es mejor para un caso  u otra ademas de poder comparar los tiempos  entre ellos

# 🏗️ Estructura del proyecto
```text
UD01_OrdenacionListas/
└── src/
    ├── controlador/
    │   ├── 01_InsertionSort.kt
    │   ├── 02_MergeSort.kt
    │   ├── 03_PancakeSort.kt
    │   ├── 04_QuickSort.kt
    │   └── 05_HeapSort.kt
    ├── main/
    │   └── Main.kt
    └── modelo/
        └── GenerarDatos.kt
```

# 🧮 Tabla Comparativa Resultados
## Algoritmos implementados y complejidad

| Algoritmo | Mejor caso | Caso promedio | Peor caso | Espacio auxiliar |
| :--- | :---: | :---: | :---: | :---: |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) |
| **Merge Sort** | \(O(n \log n)\) | \(O(n \log n)\) | \(O(n \log n)\) | O(n) |
| **Pancake Sort** | O(n) | O(n²) | O(n²) | O(1) |
| **Quick Sort** | \(O(n \log n)\) | \(O(n \log n)\) | O(n²) | \(O(\log n)\) |
| **Heap Sort** | \(O(n \log n)\) | \(O(n \log n)\) | \(O(n \log n)\) | O(1) |

## Resultados de ejecución

Pruebas realizadas verificando en todos los casos que el resultado final esté correctamente ordenado (`ListaOrdenada: true`).

### 1. Lista Vehículo (40 elementos)

| Algoritmo | Tiempo (ns) | Tiempo (ms) | Lista ordenada |
| :--- | :---: | :---: | :---: |
| **Insertion Sort** | 63200 ns | 0,0632 ms | `true` |
| **QuickSort** | 110900 ns | 0,1109 ms | `true` |
| **MergeSort** | 222500 ns | 0,2225 ms | `true` |
| **PancakeSort** | 234000 ns | 0,2340 ms | `true` |
| **HeapSort** | 783400 ns | 0,7834 ms | `true` |

### 2. Lista Numérica (100 elementos)

| Algoritmo | Tiempo (ns) | Tiempo (ms) | Lista ordenada |
| :--- | :---: | :---: | :---: |
| **QuickSort** | 167800 ns | 0,1678 ms | `true` |
| **HeapSort** | 196600 ns | 0,1966 ms | `true` |
| **Insertion Sort** | 282100 ns | 0,2821 ms | `true` |
| **MergeSort** | 384500 ns | 0,3845 ms | `true` |
| **PancakeSort** | 720300 ns | 0,7203 ms | `true` |

### Conclusiones de rendimiento
* **Listas pequeñas (40 elementos):** **Insertion Sort** obtiene el mejor tiempo (`0,0632 ms`) debido a su baja sobrecarga en colecciones reducidas.
* **Listas medianas (100 elementos):** **QuickSort** (`0,1678 ms`) y **HeapSort** (`0,1966 ms`) lideran el rendimiento al escalar el número de elementos.
* **PancakeSort:** Presenta el tiempo más alto en la lista de 100 elementos (`0,7203 ms`) por la cantidad de inversiones de prefijos necesarias.


Conclusiones de rendimiento
* **Los más rápidos:** **MergeSort** y **RadixSort** mantienen tiempos muy bajos y estables por debajo de `1,3 ms` en ambas ejecuciones.
* **Variabilidad en QuickSort:** Pasa de ser el más rápido en la primera ejecución (`0,9434 ms`) a tardar `7,0492 ms` en la segunda según la distribución inicial y la elección del pivote.
* **Algoritmos cuadráticos ($O(n^2)$):** **Insertion Sort** y **PancakeSort** presentan los tiempos más elevados al escalar a 5000 elementos.
# 🧑‍💻 Tecnologias
- Kotlin.
- Git
- Github
# 🆔  IDES.
- Intellij IDEA.

