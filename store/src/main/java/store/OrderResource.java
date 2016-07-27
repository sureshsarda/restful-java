package store;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("orders")
public class OrderResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> getAll() {
		return new ArrayList<Order>();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{id}")
	public Order get(@PathParam("id") int id) {
		return new Order(id, "This is a dummy order");
	}
}
