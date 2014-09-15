package com.castlecodestein.data.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Custom base repository interface for all other repositories to extend. Must
 * be annotated by @NoRepositoryBean. Otherwise Spring will try to create a
 * concrete implementation of it and that will result in an error.
 * <br />
 * <br />
 * findAll method normally returns Iterable but I override the declaration as Collection is more useful.
 * 
 * @author Tomasz Krug
 *
 * @param <E>
 */
@NoRepositoryBean
public interface CriteriaRepository<E> extends
		PagingAndSortingRepository<E, Long>, JpaSpecificationExecutor<E> {

	public Collection<E> findAll();

}
