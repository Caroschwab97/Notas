package com.Note.app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.Note.app.model.Tag;
@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
}
