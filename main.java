
public class main {

	public static void main(String[] args) {
		MonitorTenedores monitor = new MonitorTenedores();
		
		new Filosofo("Plat�n", monitor);
		new Filosofo("Confucio", monitor);
		new Filosofo("S�crates", monitor);
		new Filosofo("Voltaire", monitor);
		new Filosofo("Descartes", monitor);
	}

}
