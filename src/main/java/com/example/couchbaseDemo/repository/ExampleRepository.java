package com.example.couchbaseDemo.repository;

import com.example.couchbaseDemo.domain.Example;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExampleRepository extends PagingAndSortingRepository<Example,String> {
}
