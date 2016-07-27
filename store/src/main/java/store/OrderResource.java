package store;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("orders")
public class OrderResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> getAll() {
		return new ArrayList<Order>();
	}
	
}
