# GoF Definition
Snow falls, soft and still,  
Blanket wraps the quiet earth,  
Stars gleam, cold and bright.  

So basically we have a *Client* and a *Service*. The service is
usually some database or something that provides an *API* to its
clients. The *Proxy* acts as an intermediate between the *Client*
and the *Service*, which can enhance functionality or allow more
flexibility by providing an uniform interface to the clients
regardless of *Service* realization

For example, it can be used for logging clients requests or for
caching most frequent queries. Usually the proxy holds an instance
to the concrete service and passes requests to it on behalf of the
client, but it might be that, say the database is split into two
separate servers one holding a-m records the other n-z records, by
letting a proxy to handle the request one can achieve smooth 
scalability in the service management so to speak

```go
    +----------------+
    | <<interface>>  |
    |   Database     |
    +----------------+
    | +query(String) |<< - - - - - - + 
    +----------------+               | 
      ^                           
      ^                              | 
    +---------------+                
    | Cache(Proxy)  |                |
    +---------------+       1..* +-------+ 
    | -mysql: MySQL |<>----------| MySQL |
    +---------------+            +-------+

```

Here both Cache and MySQL implement Database interface, also
Cache has one or more SQL objects for forwarding the requests,
by the way, we have covered so far only *creational* patterns, 
like *Builder*, *Abstract Factory*, etc., ***Proxy*** is
the first of the so called *structural* patterns
