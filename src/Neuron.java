import java.util.Random;

/**
 * Created by Orens Xhagolli on 9/17/2016.
 * Unbiased Neuron Model
 */
public class Neuron {

    private double[] weights; // Input weights vector
    private double alpha; // The

    /**
     * Neuron constructor
     * @param size  int - how many inputs does this neuron accept?
     * @param alpha double - what is the learning constant you'd like to use?
     */
    public Neuron(int size, double alpha) {
        this.alpha = alpha;
        this.weights = new double[size];
        for (int i = 0; i < size; i++) {
            this.weights[i] = new Random().nextDouble();
        }
    }

    /**
     * sum (inputVector x weightVector) then feeds to the activate function
     * @param inputVector What are the input values.
     * @return value from the activate function
     */
    public double feedForward(double[] inputVector) {
        double sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * inputVector[i];
        }
        return activate(sum);
    }

    /**
     * Sigmoid function activation
     * @param sum double - sum of inputs*weights
     * @return 1/(1+e^(-t)) - evaluation of sigmoid
     */
    public double activate(double sum){
        return 1 / (1 + Math.pow(Math.E, sum));
    }

    /**
     * Provides input vectors and adjusts weights accordingly
     * @param inputVector double[] - inputVector (size has to be equal to weights array)
     * @param desired   what should the output be for the given input?
     */
    public void train(double[] inputVector, double desired) {
        double output = feedForward(inputVector);
        double error = desired - output;
        for(int i = 0; i < weights.length; i++){
            weights[i] += alpha * error * inputVector[i];
        }
    }
}
