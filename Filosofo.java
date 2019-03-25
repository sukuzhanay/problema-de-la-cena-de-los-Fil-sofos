import java.util.Random;

public class Filosofo extends Thread{
	private enum STATE{HUNGRY,EATING,THINKING};
	private STATE state;
	private String nombre;
	private int id;
	private static int totalFilosofos;
	private MonitorTenedores monitor;
	private int vecesComido = 0;
	
	Filosofo(String n, MonitorTenedores m) {
		id = totalFilosofos++;
		nombre = n;
		state = STATE.THINKING;
		monitor = m;
		start();
	}
	
	private void think() {
		System.out.println(nombre + " empieza a pensar. ID: " + id);
		
		Random rnd = new Random();
		int thinkingTime = rnd.nextInt(250 - 50 + 1) + 50;
		try {
			sleep(thinkingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre + " deja de pensar. ID: " + id);
		
		state = STATE.HUNGRY;
	}
	
	private void hungry() {
		System.out.println(nombre + " tiene hambre y ca a la mesa a ver si hay sitio. ID " + id);
		monitor.obtenerTenedores(id);
		
		state = STATE.EATING;
	}
	
	private void eat() {
		System.out.println(nombre + " empieza a comer. ID " + id);
		
		Random rnd = new Random();
		int eatingTime = rnd.nextInt(250 - 50 + 1) + 50;
		
		try {
			sleep(eatingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vecesComido++;
		state = STATE.THINKING;
		monitor.liberarTenedores(id);
		System.out.println(nombre + " termina de comer. (Veces comidas: " + vecesComido + " ID: " + id);
	}
	
	@Override
	public void run() {
		while(true) {
			switch(state) {
			case EATING:
				eat();
				break;
				
			case HUNGRY:
				hungry();
				break;
				
			case THINKING:
				think();
				break;
			}
		}
	}
}

