package com.example;

import com.example.model.Item;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;

import java.util.List;


@Controller
public class DemoController
{

	private final DemoService demoService;


	public DemoController(final DemoService demoService)
	{
		this.demoService = demoService;
	}

	@Get
	public List<Item> getItems()
	{
		return demoService.getItems();
	}

	@Status(HttpStatus.CREATED)
	@Post
	public Long createItem()
	{
		return demoService.createItem();
	}

}
