public class NeuralNetLab {
    public static void main(String[] args) {
        NeuralNetConfig config= new NeuralNetConfig.Builder()
                .setHiddenLayers(5)
                .setOptimizer("Adam")
                .setLearningRate(0.001)
                .build();
        config.printSummary();
    }
}

class NeuralNetConfig {
    private final int hiddenLayers;
    private final double learningRate;
    private final String optimizer;
    private final int epochs;
    private NeuralNetConfig(Builder b) {
        this.hiddenLayers= b.hiddenLayers;
        this.learningRate= b.learningRate;
        this.optimizer= b.optimizer;
        this.epochs=b.epochs;
    }

    public void printSummary() {
        System.out.println("Model: " + hiddenLayers+ " layers, "+ optimizer+", LR: "+learningRate+", Epochs: "+epochs);
    }

    public static class Builder {
        private int hiddenLayers= 1;
        private double learningRate= 0.01;
        private String optimizer= "SGD";
        private int epochs= 10;

         public Builder setHiddenLayers(int h) { this.hiddenLayers = h; return this; }
        public Builder setLearningRate(double lr) { this.learningRate = lr; return this; }
         public Builder setOptimizer(String o) { this.optimizer = o; return this; }
        public Builder setEpochs(int e) { this.epochs = e; return this; }
        public NeuralNetConfig build() {
            if (learningRate<= 0) {
                throw new IllegalStateException("Learning rate must be greater than 0");
            }
            return new NeuralNetConfig(this);
        }
    }
}
