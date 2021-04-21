package 시험;

public class Notice {
	
	private int id;
	private String title;
	private String writerId;
	private int hit;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int id, String title, String writerId, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.hit = hit;
	}
	
	@Override
	public String toString() {
		return String.format("id:%d, title:%s, writerId:%s, hit:%d", id, title, writerId, hit);
	}
	
	
//	private int id;
//	private int hit;
//	private String title;
//	private String writerId;
//	
//	public Notice(){
////		id = 1;
////		hit = 12;
////		title = "Hello Java";
////		writerId = "newlec";
//		
//		this(1,12,"Hello Java","newlec");
//		
//		
//		
//	}
//	
//	public Notice(int id, int hit, String title, String writerId) {
//		this.id = id;
//		this.hit = hit;
//		this.title = title;
//		this.writerId = writerId;
//	}
//	
//	public String toString() {
//		return this.id+hit+title+writerId;
//
//		
//		
//	}
}



