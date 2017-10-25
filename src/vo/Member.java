package vo;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String gender;
	private String nickname;
	private String email;
	private String phone;
	private int point;
	private int lv;
	
///////////////////////////////////////////////////////////////////////////

public Member(String id, String pw, String name, String birth, String gender, String nickname, String email,
		String phone, int point, int lv) {
	this.id = id;
	this.pw = pw;
	this.name = name;
	this.birth = birth;
	this.gender = gender;
	this.nickname = nickname;
	this.email = email;
	this.phone = phone;
	this.point = point;
	this.lv = lv;
}

public Member() {}
//////////////////////////////////////////////////////////////////////////
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
///////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", gender=" + gender
				+ ", nickname=" + nickname + ", email=" + email + ", phone=" + phone + ", point=" + point + ", lv=" + lv
				+ "]";
	}	
}
