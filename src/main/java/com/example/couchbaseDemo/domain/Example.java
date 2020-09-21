package com.example.couchbaseDemo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    public String id;

    @Field
    public String data;

    public Example(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
