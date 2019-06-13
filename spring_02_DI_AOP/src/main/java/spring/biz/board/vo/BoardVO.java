package spring.biz.board.vo;

public class BoardVO {
	private int seq;
	private String title;
	private String content;
	private String regdate;
	private int cnt;
	private String id;
	
	public BoardVO() {
		super();
	}

	public BoardVO(int seq, String title, String content, String regdate, int cnt) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.cnt = cnt;
	}

	public BoardVO(int seq, String title, String content, String regdate, int cnt, String id) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.cnt = cnt;
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", cnt="
				+ cnt + ", id=" + id + "]";
	}
	
	
}
