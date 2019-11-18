package editorial;


public class autores {
	int id;
	String name;
	int idsecundario;
	String nameSecundario;
	
	public void newAutor(int idI, String nameI) {
		id = idI;
		name = nameI;
		System.out.println("Nuevo autor: "+ name);
		System.out.println("id: "+ id);
	}
	
	public String getId() {
		System.out.println("id: "+ id);
		return String.valueOf(id);
	}
	
	public void getName() {
		System.out.println("nombre: "+ name);
	}
}

class Alias extends autores{
	public void newAlias(int id, String name,int idI, String nameI) {
	
	//Se guardan los datos reales del Author
	super.newAutor(id, name);	
	
	idsecundario = idI;
	nameSecundario = nameI;
	System.out.println("Nuevo autor: "+ name);
	System.out.println("id: "+ name);
	}
	
	public String getId() {
		System.out.println("id: "+ id);
		return String.valueOf(id);
	}
	
	public void getIdOriginal() {
		System.out.println("id: "+ id);
	}
	
	public void getName() {
		System.out.println("nombre: "+ nameSecundario);
	}
	
	public void getNameOriginal() {
		System.out.println("nombre: "+ name);
	}
}