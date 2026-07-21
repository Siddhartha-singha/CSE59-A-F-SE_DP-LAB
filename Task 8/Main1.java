public class CreationalPatternsLab {
    public static void main(String[] args) {

        System.out.println("---Builder Pattern---");

        HttpRequest req= new HttpRequest.Builder("https://api.example.com/users")
                .setMethod("POST")
                .addHeader("Auth: Bearer 123")
                .setBody("{\"name\": \"Alice\"}")
                .build();
        req.send();
        System.out.println("\n--- Singleton Pattern ---");

        ConfigurationManager config1= ConfigurationManager.getInstance();
        config1.printSetting("java.version");
        ConfigurationManager config2= ConfigurationManager.getInstance();
        System.out.println("Same instance? " +(config1==config2));
    }
}
class HttpRequest {
    private final String url;
    private final String method;
    private final String headers;
    private final String body;

    private HttpRequest(Builder b) {
        this.url= b.url;
        this.method= b.method;
        this.headers= b.headers;
        this.body= b.body;
    }
    public void send() {
        System.out.println("Sending "+ method + " to " +url);
        System.out.println("Headers: "+ headers + " | Body: " +body);
    }
    public static class Builder {
        private String url;
        private String method= "GET";
        private String headers= "";
        private String body= "";

        public Builder(String url) {
            this.url= url;
        }

        public Builder setMethod(String m) {
            this.method= m;
            return this;
        }
        public Builder addHeader(String h) {
            this.headers += h + "; ";
            return this;
        }
        public Builder setBody(String b) {
            this.body= b;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}

class ConfigurationManager {
    private static final ConfigurationManager INSTANCE =
            new ConfigurationManager();
    private ConfigurationManager() {
        System.out.println("ConfigurationManager initialized.");
    }
    public static ConfigurationManager getInstance() {
        return INSTANCE;
    }
    public void printSetting(String key) {
        System.out.println("Setting " + key + " = " +
                System.getProperty(key));
    }
}
