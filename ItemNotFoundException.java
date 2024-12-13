package TheLibrary;

public class ItemNotFoundException  extends Exception{
	
	private  String msg;
	
	
	public ItemNotFoundException () {
		this.setMsg("this item not found");
	}
	public ItemNotFoundException (String msg) {
		this.setMsg(msg);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
	
	
	
	
	
	
	

}
