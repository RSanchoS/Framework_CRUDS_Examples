package com.robertosancho.example_crud.repositories;

import com.robertosancho.example_crud.configs.MongoConfig;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import rx.Single;

public class CustomerRepository {

    private MongoConfig mongoConfig;

    
    public CustomerRepository() {
        this.mongoConfig = new MongoConfig();
    }

    public Single<JsonObject> findById(String id) {

        JsonObject query = new JsonObject()
            .put("id", "6312062991a4d974501458a4");

        Future<JsonObject> future = mongoConfig.mongoClient
        .findOne("customers", query, null);

        return Single.just(future.result());
    }
}