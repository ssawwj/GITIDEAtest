package com.ss.ssm.entity;

public class Emp {
    private Integer id;

    private String name;

    private String gender;

    private String email;

    private Integer dId;
    
    private Dept dept;

    public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer id, String name, String gender, String email, Integer dId, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.dId = dId;
		this.dept = dept;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}