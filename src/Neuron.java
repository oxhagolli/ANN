import java.util.Random;

/**
 * Created by Orens Xhagolli on 9/17/2016.
 */
public class Neuron {

    private boolean hidden; // Is this a hidden layer? (a.k.a. Can we back-propagate?)
    private Neuron[] prev_layer; // If this is a hidden layer, we need references to previous Neurons
    private double[] weights; // Input weights vector
    private double alpha; // The

    public Neuron(int size, double alpha) {
        this.hidden = false;
        this.prev_layer = null;
        this.alpha = alpha;
        this.weights = new double[size];
        for (int i = 0; i < size; i++) {
            this.weights[i] = new Random().nextDouble();
        }
    }

    public Neuron(Neuron[] prev_layer, int size, double alpha){
        this.hidden = true;
        this.prev_layer = prev_layer;
        this.alpha = alpha;
        this.weights = new double[size];
        for (int i = 0; i < size; i++) {
            this.weights[i] = new Random().nextDouble();
        }
    }
}
