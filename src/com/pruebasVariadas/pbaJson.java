package com.pruebasVariadas;

import com.google.gson.JsonObject;

public class pbaJson {
    public static void main(String[] args) {
        JsonObject jobj = new JsonObject();
        jobj.addProperty("puerto",111);
        jobj.addProperty("mensaje","online");
        jobj.addProperty("nombre","nombre");
        System.out.println("Accediendo a fill valor: " + jobj.get("mensaje").getAsString());
        System.out.println(jobj.toString());
    }
}

// Le parece hacer llamada, es que creo que por aquí no sirvió

/* Pendientes:
    com.interfaz.Interfaz con LinkedList
    Implementar y probar bien el queue con los puertos nuevos
    game over (reiniciar)
    ganador

    *En proceso:
    Gson en sockets (listo)

    *Propuesta:
    Mover todas las matrices a la vez, actualizar solo las líneas y actualizar toda la matriz cuando haya cambio en cajas.
    //Select por tipo de clase
 */