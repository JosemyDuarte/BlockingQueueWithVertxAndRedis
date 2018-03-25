import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.redis.RedisClient;
import io.vertx.redis.RedisOptions;

public class Listener extends AbstractVerticle {
    public static void main(String[] args) {
        Launcher.executeCommand("run", Listener.class.getName());
    }

    @Override
    public void start() {
        RedisOptions config = new RedisOptions()
                .setHost("127.0.0.1");

        RedisClient redis = RedisClient.create(vertx, config);

        vertx.setPeriodic(1000, t ->
                redis.blpop("myKey", 3500, message -> {
                    System.out.println("[FirstListener] -> " + message);
                })
        );

        vertx.setPeriodic(1000, t ->
                redis.blpop("myKey", 3500, message -> {
                    System.out.println("[SecondListener] -> " + message);
                })
        );


    }

}
