package editorial;

import java.lang.reflect.Array;
import java.util.Scanner;

public class main {
	static autores[] creadores = new autores[200];
	static Alias[] Alias = new Alias[200];
	static books[] libros = new books[200];
	static int nLibros = 0;
	static int nAlias = 0;
	static int nAutores = 0;

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		System.out.println("Bienvenido al sistema de revision de libros Writter's Digest. \n\n");
		Scanner myObj = new Scanner(System.in);
		System.out.println("¿Que desea hacer?");
		System.out.println("1.- Revisar libros");
		System.out.println("2.- Agragar libro");
		System.out.println("3.- Revisar Autores");
		System.out.println("4.- Agregar Autor\n");
		System.out.println("5.- Pagar por libro\n");
		System.out.println("6.- Salir");
		String respuesta = myObj.nextLine();
		
		if(respuesta.equals("1")) {
			ShowLibros();
		}else if(respuesta.equals("2")) {
			addLibros();
		}else if(respuesta.equals("3")) {
			ShowAutores();
		}else if(respuesta.equals("4")) {
			addcreadores();
		}else if(respuesta.equals("5")) {
			CalcularPago();
		}else if(respuesta.equals("6")) {
			myObj.close();
			System.exit(0);
		}else {
			System.out.println("Opcion no valida\n");
		}
		
	}
	
	private static void CalcularPago() {
		try {
			autores[] autorLi = libros[nLibros].getAutores();
			
			int total = 0;
			String respuesta;
			
			int e = Array.getLength(autorLi);
			for (int i = 0;i<e;i++ ) {
				Scanner myObj = new Scanner(System.in);
				System.out.println("¿Cuanto se le pagara a :?");
				autorLi[i].getName();
				respuesta = myObj.nextLine();
				
				total =+ Integer.parseInt(respuesta);
			}
			
			System.out.println("El total a pagar es: "+total);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("\n\nNo se encontaron datos\n\n");
		}
		menu();
	}

	public static void ShowLibros() {
		System.out.println("Los libros dispoibles son: ");
		int e = Array.getLength(libros);
		for (int i = 0;i<e;i++ ) {
			libros[i].getName();
		}
	}
	
	public static void addLibros() {
		try {
			
			Scanner myObj = new Scanner(System.in);
			System.out.println("¿Cual es el nombre del libro? \n");
			String respuesta = myObj.nextLine();
			
			libros[nLibros] = new books();
			libros[nLibros].newBook(respuesta);
			
			System.out.println("¿Cuantos Autores crearon el libro? \n");
			respuesta = myObj.nextLine();
			
			int autoresInt = Integer.parseInt(respuesta);
			
			String autores;
			autores[] autoresTemp = new autores[200];
			
			for(int t = 0;autoresInt>t; t++ ) {
				System.out.println("¿Cual es el id del autor"+(t+1)+"? \n");
				autores = myObj.nextLine();
				
				for(int y = 0;creadores.length<y; y++ ) {
					if(creadores[y].getId().equals(autores)) {
						autoresTemp[t] = creadores[y];
					}
				}
			}		
			
			libros[nLibros].definirAutores(autoresInt, autoresTemp);
			
			nLibros++;
			
			menu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ShowAutores() {
		System.out.println("Los Autores son: ");
		int e = Array.getLength(creadores);
		for (int i = 0;i<e;i++ ) {
			libros[i].getName();
		}
	}
	
	public static void addcreadores() {
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("¿Es un nuevo autor o un alias? ");
		System.out.println("1 .- Autor ");
		System.out.println("2 .- Alias ");
		String respuesta = myObj.nextLine();
		
		if(respuesta.equals("1")) {
			creadores[nAutores] = new autores();
			
			System.out.println("¿Que id tendra?\n");
			String id = myObj.nextLine();
			System.out.println("¿Cua es el nombre?");
			String nombre = myObj.nextLine();
			creadores[nAutores].newAutor(Integer.parseInt(id),nombre);
			nAutores++;
			
		}else {
			Alias[nAlias] = new Alias();
			
			System.out.println("¿Cual es el id original?\n");
			String idOriginal = myObj.nextLine();
			System.out.println("¿Cual es el id nuevo?\n");
			String id = myObj.nextLine();
			System.out.println("¿Cua es el nombre Original?");
			String nombreOriginal = myObj.nextLine();
			System.out.println("¿Cua es el nombre nuvo?");
			String nombre = myObj.nextLine();
			Alias[nAlias].newAlias(Integer.parseInt(idOriginal),nombreOriginal,Integer.parseInt(id),nombre);
			nAlias++;
		}
		
		menu();
	}

}
