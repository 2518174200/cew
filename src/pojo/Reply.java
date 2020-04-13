package pojo;
import java.io.Serializable;
import java.util.Date;
public class Reply implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5527228147900300987L;
	private int id;
	private int invid;
	private String content;
	private String author;
	private Date createdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInvid() {
		return invid;
	}
	public void setInvid(int invid) {
		this.invid = invid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Reply(int invid, String content, String author, Date createdate) {
		super();
		this.invid = invid;
		this.content = content;
		this.author = author;
		this.createdate = createdate;
	}
	public Reply() {
		super();
	}
}
