package editorial;

import java.util.Calendar;
import java.util.Date;

public class books {
	String name;
	String Fecha;
	autores[] autores;
	
	public void newBook(String nameI) {
		Date fecha = new Date();
		Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.MONTH, 5);
        Date nuevaFecha = cal.getTime();
        
        name = nameI;
        
        System.out.println("Libro: "+name);
        System.out.println("Creado el : "+(cal.get(Calendar.MONTH) + 1) + 
        		" del " +cal.get(Calendar.YEAR));

	}
	
	public void definirAutores(int numeroAutores,autores[] autoresI) {
		autores = autoresI.clone();
		
		System.out.println("Libro: "+name);
		
		System.out.println("Creado por: ");
		
		for(int i = 0;numeroAutores<i;i++) {
			autores[numeroAutores].getName();
		}
	}
	
	public autores[] getAutores() {
		return autores;
	}
	
	public void getName() {
		System.out.println("nombre: "+ name);
	}
}
