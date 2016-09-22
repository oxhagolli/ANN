import java.util.Random;

/**
 * Created by Orens Xhagolli on 9/17/2016.
 */
public class Driver {
    public static void main(String[] args) {
        // Neuron/Perceptron instantiation.
        Neuron above = new Neuron(3, 0.01);
        Neuron below = new Neuron(3, 0.01);

        // Training
        for(int i = 0; i < 10000; i++){
            //Random number generation
            Random gen = new Random();
            double x = gen.nextInt();
            double y = gen.nextInt();

            // input vector
            double[] input = {x, y, 1.0};

            // train based on input and calculate desired output
            above.train(input, y >= -x ? 1 : 0);
            below.train(input, y <= -x ? 1 : 0);
        }

        // Validation data
        for(int i = -100; i <= 100; i++){
            double[] input = {i, 0, 1.0};
            System.out.println(i + " : " + above.feedForward(input) + ", " + below.feedForward(input));
        }
    }
}
