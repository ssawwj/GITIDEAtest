package com.ss.ssm.entity;

public class Dept {
    private Integer deid;

    private String dename;

    public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(Integer deid, String dename) {
		super();
		this.deid = deid;
		this.dename = dename;
	}

	public String getDename() {
		return dename;
	}

	public void setDename(String dename) {
		this.dename = dename;
	}

    public Integer getDeid() {
		return deid;
	}

	public void setDeid(Integer deid) {
		this.deid = deid;
	}

	public void setId(Integer deid) {
        this.deid = deid;
    }

  
}