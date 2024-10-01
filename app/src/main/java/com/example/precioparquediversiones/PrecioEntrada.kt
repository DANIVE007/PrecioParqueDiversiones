package com.example.precioparquediversiones
fun main() {
    var continuar = true

    while (continuar) {
        println("Bienvenido al sistema de entradas del parque de diversiones.")

        // Pedimos la edad
        print("Por favor, ingrese su edad: ")
        val edad = readLine()?.toIntOrNull()

        // Verificamos si la edad es válida
        if (edad == null || edad <= 0 || edad > 100) {
            println("Error: Edad no válida. Por favor ingrese una edad entre 1 y 100.")

            // Preguntamos si desea intentar con otra edad
            print("¿Desea intentar con otra edad? (S/N): ")
            val respuesta = readLine()?.uppercase()

            if (respuesta == "N") {
                println("Saliendo del sistema. ¡Gracias!")
                continuar = false // Termina el bucle
            }

            continue // Si no, vuelve al inicio del bucle para pedir la edad de nuevo
        }

        // Si la persona tiene menos de 4 años, no paga entrada
        if (edad!! < 4) {
            println("Los niños menores de 4 años no pagan entrada.")
            return
        }

        // Pedimos el día de la semana
        println("Por favor, ingrese el día de la semana (Lunes, Martes, Miércoles, etc.): ")
        val diaSemana = readLine()?.replaceFirstChar { it.uppercase() }

        // Definimos el precio según la edad y el día de la semana
        val precio = when {
            // Niños entre 4 y 15 años
            edad in 4..15 -> 15000
            // Adultos entre 16 y 60 años con descuento lunes y martes
            edad in 16..60 -> {
                if (diaSemana == "Lunes" || diaSemana == "Martes") {
                    25000 // Descuento de 5000
                } else {
                    30000
                }
            }
            // Adultos mayores de 60 años
            edad > 60 -> 20000
            else -> 0
        }

        // Mostrar el resultado
        println("El precio de su entrada es: $precio CLP.")

        // Finalizamos el bucle ya que la entrada fue calculada correctamente
        continuar = false
    }
}
