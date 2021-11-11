package ru.sssproject.testex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sssproject.testex.utils.DataClass;
import ru.sssproject.testex.utils.Finder;

import java.util.Set;

@RestController
public class FindEldersController {

	@Autowired
	private Finder finder;
	@Autowired
	private DataClass dataClass;

	@GetMapping("/findElders")
	public Set findElders() {

		return finder.getFinderOldMan().findOldMembers(dataClass.getRandomData());
	}
}