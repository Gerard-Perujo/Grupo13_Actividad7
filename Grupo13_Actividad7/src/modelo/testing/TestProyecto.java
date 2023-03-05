package modelo.testing;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestProyecto {

	public static void main(String[] args) {
		//Se crea un nuevo objeto de la clase Proyecto.
		ProyectoDao podao = new ProyectoDaoImplMy8();
		
		//Vamos a añadir un nuevo proyecto.
		System.out.println("Creamos nuevo proyecto");
		Proyecto proyecto = new Proyecto("FOR2022003", "Formacion de auxiliares de proyecto",null , null
				,null, 50000.00, 30000.00, 315000.00, "Activo", 114, "A22222222");
		System.out.println(podao.altaProyecto(proyecto));
		System.out.println(" ");
		
		//Se va a modificar el proyecto.
		System.out.println(podao.modificarProyecto(proyecto));
		System.out.println(" ");		
		
		//Ahora se elimina ese mismo proyecto.
		System.out.println(podao.eliminarProyecto("FOR2022003"));
		System.out.println(" ");
		
		//Buscamos uno de los proyectos existentes.
		Proyecto p22 = podao.buscarUno("FOR2021002");
		System.out.println("Buscamos uno");
		System.out.println(p22);
		System.out.println(" ");
		
		//Buscamos todos.
		System.out.println("Buscamos todos los proyectos");
		for (Proyecto ele: podao.buscarTodos())
			System.out.println(ele);
		System.out.println(" ");
		
		//Buscamos proyectos por estado.
		System.out.println("Proyectos por estado");
		for (Proyecto ele: podao.proyectosByEstado("ter"))
			System.out.println(ele);
		System.out.println(" ");
		
		//Buscamos proyecto por cliente.
		System.out.println("Proyectos por cliente");
		for (Proyecto ele: podao.proyectosByCliente("A22222222"))
			System.out.println(ele);
		System.out.println(" ");
		
		//Buscamos proyecto por jefe y estado.
		System.out.println("Proyectos por jefe y estado");
		for (Proyecto ele: podao.proyectosByJefeProyectoAndByEstado(114, "ter"))
			System.out.println(ele);
		System.out.println(" ");
				
		//Sumamos los importes de las ventas.
		System.out.println("Sumamos importes");
		System.out.println(podao.importesVentaProyectosTerminados());
		System.out.println(" ");
		
		//Ahora encontramos el margen bruto.
		System.out.println("Margen bruto");
		System.out.println(podao.margenBrutoProyectosTerminados());
		System.out.println(" ");
		
		//Finalmente, vamos a ver la diferencia de dias entre la fecha prevista y el dia de hoy.
		System.out.println("Diferencia de dias"); 	
		System.out.println(podao.diasATerminoProyectoActivo("FOR2021002"));
				
		
				

	}

}
