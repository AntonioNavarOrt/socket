package server;

public class Tarea {
//Creamos la clase tarea para crear los objetos "descripcion" y "estado"
	private String descripcion;
	private String estado;

	public Tarea(String descripcion, String estado) {
		// TODO Auto-generated constructor stub
		
		
		this.descripcion = descripcion;
		this.estado = estado;
		//Realizariamos getters y setters
	}
		
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		
		}
			
		public String getEstado() {
				return estado;
			}
		public void setEstado(String estado) {
				this.estado = estado;
			
	}
		//Con el toString marcariamos como se verian las respuestas de las tareas.
		public String toString() {
			return "Tarea =====>" + " Descripcion: " + descripcion + 
					", estado: " + estado;
		}

}
