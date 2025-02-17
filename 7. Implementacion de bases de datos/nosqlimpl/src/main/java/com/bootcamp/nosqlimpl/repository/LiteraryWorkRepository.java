package com.bootcamp.nosqlimpl.repository;

import com.bootcamp.nosqlimpl.entity.LiteraryWork;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface LiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {

    @Query("""
              {
                  "match": {
                    "author": "?0"
                  }
              }
            """)
    List<LiteraryWork> findByAuthorContaining(String author);

    List<LiteraryWork> findByNameContaining(String name);

    List<LiteraryWork> findTop5ByOrderByPageCountDesc();

    List<LiteraryWork> findByPublicationYearBefore(Integer publicationYearBefore);

    List<LiteraryWork> findByPublisher(String publisher);
}
