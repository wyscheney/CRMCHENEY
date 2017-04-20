package com.cheney.entity;

public class Rights {
    private Integer rid;

    private String rightName;

    private String url;

    private Integer pid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	@Override
	public String toString() {
		return "Rights [rid=" + rid + ", rightName=" + rightName + ", url=" + url + ", pid=" + pid + "]";
	}
    
}