# Node app "hello world"

This is a simple HTTP server that listens on port 80 and returns "Hello World".

```bash
docker build -t node-hello-world:0.1 .
```

Tag and push to docker.io

```bash
docker tag node-hello-world:0.1 papanito/node-hello-world:0.1
docker push papanito/node-hello-world:0.1
```