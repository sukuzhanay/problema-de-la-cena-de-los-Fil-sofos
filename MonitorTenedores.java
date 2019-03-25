
public class MonitorTenedores {
	private boolean[] tenedores = new boolean[5];
	
	public MonitorTenedores() {
		for(int i = 0; i< 5; i++) {
			tenedores[i] = true;
		}
	}
	
	public synchronized void obtenerTenedores(int i) {
		while(!tenedores[i] || !tenedores[(i+1)%4]) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		tenedores[i] = false;
		tenedores[(i+1)%4] = false;
	}
	
	public synchronized void liberarTenedores(int i) {
		tenedores[i] = true;
		tenedores[(i+1)%4] = true;
		
		notify();
	}
}
