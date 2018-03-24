# BlockingQueueWithVertxAndRedis
Just an example of how to use Redis as queue and publish and receive messages with Vertx.


## How to get it running?

First you'll need a Redis instance running. If you have Docker, just run:

```bash
docker run -it --rm -p 6379:6379  --name redis redis
```

After that, you just have to run *Listener*, *Listener2* and *Publisher*. 

*Listener* classes will continue to wait for messages all the time. *Publisher* will publish a message that will be received by the first *listener* that has been executed, and if you run *Publisher* one more time, this time the message will be received by the other *listener*, and so on.