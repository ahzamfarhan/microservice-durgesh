
Jpa Repo methods
	https://www.baeldung.com/spring-data-jpa-deleteby

	
	4. Derived Deleted Methods vs @Query
		We may come across a scenario that makes the derived method’s name too big or that involves a SQL JOIN between unrelated entities.
		
		In this case, we can also use the @Query and @Modifying annotations to implement delete operations.
		
		Let’s see the equivalent code for our derived delete methods, using a custom query:
		
		@Modifying
		@Query("delete from Fruit f where f.name=:name or f.color=:color")
		List<int> deleteFruits(@Param("name") String name, @Param("color") String color);
		Copy
		Although the two solutions seem similar, and they do achieve the same result, they take a slightly different approach. The @Query method creates a single JPQL query against the database. By comparison, the deleteBy methods execute a read query, then delete each of the items one by one.
		
		Also, the deleteBy method can return the list of deleted records, while the custom query will return the number of deleted records.