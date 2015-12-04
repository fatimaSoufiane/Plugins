import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Timer;
public class test {
	



		public static void main(String[] args) {
			System.out.println("abc");
			Timer timer =new Timer(1000, new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("a "+Calendar.getInstance().getTime());
					
				}
			});
			timer.start();
			Timer timer2 = new Timer(1000, ((ActionEvent e) -> System.out.println("b "+Calendar.getInstance().getTime())));
			timer2.start();
			while (true){}
		}


}
