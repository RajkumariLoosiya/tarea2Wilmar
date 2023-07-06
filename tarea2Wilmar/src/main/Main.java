package main;

import logica_negocio.Logica_negocio;

public class Main {

	public static void main(String[] args) {
		
		Logica_negocio logicanegocio = new Logica_negocio(); 
		
//		logicanegocio.creacionFicheros();
		logicanegocio.lecturaFicheroDepartamento();
		logicanegocio.lecturaFicheroEmpleados();
//		logicanegocio.insercionDepartamento(logicanegocio.lecturaFicheroDepartamento());
		logicanegocio.insercionEmpleados(logicanegocio.lecturaFicheroEmpleados());
	}

}
