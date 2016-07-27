package store;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

	private int id;
	private String content;

	public Order() {}
	
	public Order(int id, String content) {
		this.content = content;
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Order: [id: " + id + " Content: " + content + "]";
	}
}
