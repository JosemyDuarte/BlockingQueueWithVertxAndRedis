import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.redis.RedisClient;
import io.vertx.redis.RedisOptions;

public class Publisher extends AbstractVerticle {
    public static void main(String[] args) {
        Launcher.executeCommand("run", Publisher.class.getName());
    }

    @Override
    public void start() {
        RedisOptions config = new RedisOptions()
                .setHost("127.0.0.1");

        RedisClient client = RedisClient.create(vertx, config);

        client.lpush("reddit", "Josemy", r -> {
            if (r.succeeded()) {
                System.out.println("key stored");
            } else {
                System.out.println("Connection or Operation Failed " + r.cause());
            }

        });

    }

}
