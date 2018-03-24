import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.redis.RedisClient;
import io.vertx.redis.RedisOptions;

public class Listener extends AbstractVerticle {
    public static void main(String[] args) {
        Launcher.executeCommand("run", Listener.class.getName());
    }

    @Override
    public void start(){
        RedisOptions config = new RedisOptions()
                .setHost("127.0.0.1");

        RedisClient redis = RedisClient.create(vertx, config);
        redis.blpop("reddit",3600, System.out::println);

    }

}
