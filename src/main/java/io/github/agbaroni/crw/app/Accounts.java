package io.github.agbaroni.crw.app;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/accounts")
public class Accounts implements Serializable {

    private static final long serialVersionUID = 193252300114012L;

    @Inject
    EntityManager entityManager;

    @GET
    public Set<Account> getAccounts() {
	var query = entityManager.createNamedQuery(Account.SELECT_ALL, Account.class);

	return query.getResultStream().collect(Collectors.toSet());
    }
}
