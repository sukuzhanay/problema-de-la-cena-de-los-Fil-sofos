
public class main {

	public static void main(String[] args) {
		MonitorTenedores monitor = new MonitorTenedores();
		
		new Filosofo("Platón", monitor);
		new Filosofo("Confucio", monitor);
		new Filosofo("Sócrates", monitor);
		new Filosofo("Voltaire", monitor);
		new Filosofo("Descartes", monitor);
	}

}
