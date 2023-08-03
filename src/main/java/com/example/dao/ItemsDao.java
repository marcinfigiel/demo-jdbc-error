package com.example.dao;

import com.example.model.Item;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;


@RegisterConstructorMapper(Item.class)
public interface ItemsDao
{

	@SqlQuery("SELECT * FROM items")
	List<Item> findAll();

	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO items (name, value) VALUES (:name, :value)")
	Long insert(@BindMethods Item item);

}
