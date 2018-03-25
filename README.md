# BlockingQueueWithVertxAndRedis
Just an example of how to use Redis as queue and publish and receive messages with Vertx.


## How to get it running?

First you'll need a Redis instance running. If you have Docker, just run:

```bash
docker run -it --rm -p 6379:6379  --name redis redis
```

After that, you just have to run *Listener* and *Publisher*. 

*Listener* class will register 2 listeners that will wait for messages all the time. *Publisher* will publish a message that will be received by the *first listener*, and if you run *Publisher* one more time, this time the message will be received by the *second listener*, and so on, like a Round Robin.