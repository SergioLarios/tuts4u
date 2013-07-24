package org.tuts4u.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.tuts4u.model.Entry;

public interface EntryRepository extends CrudRepository<Entry, Long> {

	public List<Entry> findByUserId(long userId);
	
}
