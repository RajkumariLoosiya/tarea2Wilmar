package logica_negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;
import beans.Departamento;
import beans.Empleado;
import dbrelated.ConexionBD;

public class Logica_negocio extends ConexionBD{

	public void creacionFicheros() {

		try {

			String ficheroDepartamentos = "C:\\Users\\migue\\Desktop\\Testeo\\departamentos.txt";
			String ficheroEmpleados = "C:\\Users\\migue\\Desktop\\Testeo\\empleados.txt";

			if (new File(ficheroDepartamentos).exists() || new File(ficheroEmpleados).exists()) {

				JOptionPane.showMessageDialog(null,
						"Ha habido un problema con la creación de ficheros, alguno de los dos ya existe");

			} else {

				FileWriter writer = new FileWriter(ficheroDepartamentos);
				writer.close();
				FileWriter writer2 = new FileWriter(ficheroEmpleados);
				writer2.close();

//			if (new File(ficheroEmpleados).exists()) {
//
//					JOptionPane.showMessageDialog(null,
//							"Ha habido un problema con la creación de ficheros, este ya existe");
//
//			} else {
//
//				FileWriter writer2 = new FileWriter(ficheroEmpleados);
//				writer2.close();
//				JOptionPane.showMessageDialog(null, "Se ha creado con éxito el fichero de empleados");
//
//			}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public List<Departamento> lecturaFicheroDepartamento() {

		String direccion = "C:\\Users\\migue\\Desktop\\Testeo\\departamentos.txt";
		List<Departamento> listaResultadoDep = new ArrayList<>();
		Path pt = Paths.get(direccion); 
		
		try {
			
			Stream<String> st = Files.lines(pt);
			listaResultadoDep = st.map(i->i.split(","))
			.map(i-> new Departamento(Integer.parseInt(i[0]), i[1]))
			.collect(Collectors.toList());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		for(Departamento i: listaResultadoDep) {
//			System.out.println("El id es : " + i.getId());
//			System.out.println("El nombre es : " + i.getNombre());
//		}
		 
		return listaResultadoDep; 
	}

	public List<Empleado> lecturaFicheroEmpleados() {

		String direccion = "C:\\Users\\migue\\Desktop\\Testeo\\empleados.txt";
		List<Empleado> listaResultadoEmpleados = new ArrayList<>();
		
		try {
			
			Path pt = Paths.get(direccion);
			Stream<String> st = Files.lines(pt);
			listaResultadoEmpleados = st.map(i->i.split(","))
										.map(i->new Empleado(Integer.parseInt(i[0]), i[1], Integer.parseInt(i[2]), Integer.parseInt(i[3])))
										.collect(Collectors.toList());
										
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return listaResultadoEmpleados; 
	}
	
	public void insercionDepartamento(List<Departamento>listaEntradaDep) {
		
//		String queryCreacionTabla = "CREATE TABLE IF NOT EXISTS DEPARTAMENTOS (ID INT, NOMBRE VARCHAR(50))";
		String queryInsercionDep = "INSERT INTO DEPARTAMENTOS(ID,NOMBRE) VALUES (?,?)";
		
		try {
			PreparedStatement pst = getConx().prepareStatement(queryInsercionDep);
			for(Departamento i: listaEntradaDep) {
				pst.setInt(1, i.getId());
				pst.setString(2, i.getNombre());
				pst.executeUpdate();

			}
			
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void insercionEmpleados(List<Empleado>listaEntradaEmp) {
		
//		String query = "CREATE TABLE IF NOT EXISTS EMPLEADOS(ID INT, NOMBRE VARCHAR(50), EDAD INT, DEPARTAMENTO_ID INT)";
		String queryInsercionEmp = "INSERT INTO EMPLEADOS(ID,NOMBRE,EDAD,DEPARTAMENTO_ID) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pst = getConx().prepareStatement(queryInsercionEmp);
			for(Empleado i: listaEntradaEmp) {
				pst.setInt(1, i.getId());
				pst.setString(2, i.getNombre());
				pst.setInt(3, i.getEdad());
				pst.setInt(4, i.getDepartamento_id());
				pst.executeUpdate();
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
