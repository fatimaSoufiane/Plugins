package plugins;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConfigurableTimer implements ActionListener {

        protected final int maxIteration;
        protected int nbIteration;
        protected final ActionListener listener;

        public ConfigurableTimer(ActionListener listener, int maxIterator) {
                super();
                this.listener = listener;
                this.maxIteration = maxIterator;
        }

        public ConfigurableTimer(ActionListener a) {
                this(a, 0);
        }

        public void start(int millsecond) {
                nbIteration = 0;
                Timer timer = new Timer(millsecond, this);
                timer.start();
                while (maxIteration == 0 || nbIteration < maxIteration) {
                        System.out.println(" ");
                }
                timer.stop();
        }

        public void actionPerformed(ActionEvent e) {
                nbIteration = nbIteration + 1;
                listener.actionPerformed(e);
        }



}
