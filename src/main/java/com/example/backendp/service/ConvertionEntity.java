package com.example.backendp.service;

import jakarta.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "convertions", schema = "public", catalog = "convertcurrencie")
public class ConvertionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
    @Basic
    @Column(name = "fromm")
	private String from;
    @Basic
    @Column(name = "too")
	private String to;
    @Basic
    @Column(name = "value")
	private Float value;
    @Basic
    @Column(name = "result")
	private Float result;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	public Float getResult() {
		return result;
	}
	public void setResult(Float result) {
		this.result = result;
	}
	@Override
	public int hashCode() {
		return Objects.hash(from, id, result, to, value);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConvertionEntity other = (ConvertionEntity) obj;
		return Objects.equals(from, other.from) && id == other.id && Objects.equals(result, other.result)
				&& Objects.equals(to, other.to) && Objects.equals(value, other.value);
	}
	@Override
	public String toString() {
		return "ConvertionEntity [id=" + id + ", from=" + from + ", to=" + to + ", value=" + value + ", result="
				+ result + "]";
	}
	
	
}
