package com.robertosancho.example_crud;

import com.robertosancho.example_crud.repositories.CustomerRepository;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  private CustomerRepository customerRepository;

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    Router router = Router.router(vertx);
    router.get("/customer").handler(this::getCustomer);

    HttpServer server = vertx.createHttpServer().requestHandler(router);

    server.listen(8080, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8080");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }

  private void getCustomer(io.vertx.ext.web.RoutingContext routingContext) {
    customerRepository = new CustomerRepository();
    customerRepository.findById("")
    .subscribe(customer -> {
      routingContext.response().end(customer.encodePrettily());
    },
    error -> {
      routingContext.response().end(error.getMessage());
    });
  }
}
