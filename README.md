# couchbase-demo

A Spring Boot Couchbase demo.


## Deploy a Single-Node Couchbase Cluster (Docker)

1. Download & install Docker (https://www.docker.com/)

2. Download Couchbase Docker image (https://hub.docker.com/_/couchbase/)

    ```bash
    $ docker pull couchbase:latest
    ```

3. Start Couchbase server

    ```bash
    $ docker run -d --name db -p 8091-8096:8091-8096 -p 11210-11211:11210-11211 couchbase:latest
    $ docker logs db
    ```

    _Starting Couchbase Server -- Web UI available at http://<ip>:8091_

4. From your browser, navigate to `127.0.0.1:8091` and setup a new Couchbase cluster

    **Note:** In case of insufficient memory error, disable the analytics service and try creating the cluster again

5. Create a bucket and name it _"example"_


## Create an Index for Query Operations

We must create an index if we intent to support query operations such as:
* count
* findAll
* deleteAll

To create an index, execute the following command from the query editor:

```sql
CREATE PRIMARY INDEX `example-primary-index` ON `example` USING GSI
```

For more info about Couchbase indexes, please [consult the documentation](https://docs.couchbase.com/server/current/n1ql/n1ql-language-reference/createprimaryindex.html).
