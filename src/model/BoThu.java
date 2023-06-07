package model;


public class BoThu {
	private int ID;
    private String ImgSrc;
    private String Pinyin;
    private String HanViet;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

   

    public String getPinyin() {
        return Pinyin;
    }

    public void setPinyin(String Pinyin) {
        this.Pinyin = Pinyin;
    }

    public String getImgSrc() {
		return ImgSrc;
	}

	public void setImgSrc(String imgSrc) {
		ImgSrc = imgSrc;
	}

	public String getHanViet() {
        return HanViet;
    }

    public void setHanViet(String HanViet) {
        this.HanViet = HanViet;
    }

    public int getLineNum() {
        return LineNum;
    }

    public void setLineNum(int LineNum) {
        this.LineNum = LineNum;
    }

    public String getYNghia() {
        return YNghia;
    }

    public void setYNghia(String YNghia) {
        this.YNghia = YNghia;
    }
    private int LineNum;
    private String YNghia;
  
}
