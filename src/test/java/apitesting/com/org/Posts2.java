package apitesting.com.org;

public class Posts2 {
	
	private String id;
	private String title;
	private String author;
	private Info[] info;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setInfo(Info[] info) {
		this.info = info;
	}
	public Info[] getInfo() {
		return info;
	}

}
