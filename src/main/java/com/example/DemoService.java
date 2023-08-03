package com.example;

import com.example.dao.ItemsDao;
import com.example.model.Item;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.UUID;
import java.util.random.RandomGenerator;


@Singleton
public class DemoService
{

	private final Jdbi jdbi;


	@Inject
	public DemoService(final Jdbi jdbi)
	{
		this.jdbi = jdbi;
	}

	@Transactional
	public List<Item> getItems()
	{
		return jdbi.withExtension(ItemsDao.class, ItemsDao::findAll);
	}

	@Transactional
	public Long createItem()
	{
		return jdbi.withExtension(ItemsDao.class, dao -> dao.insert(createRandomItem()));
	}

	private Item createRandomItem()
	{
		return new Item(null, UUID.randomUUID().toString(), RandomGenerator.getDefault().nextLong());
	}

}
