package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Establishment implements Serializable {
	
	private int id ;
	private String name ;
	private String address ;
	private String city;
	private ServiceProvider seProvider;
	private List<Product> products;
	private List<EstablishmentPicture> establishmentPictures;
	private double lat;
	private double lng;
	private int level;
	private double moyrating;
	
	private List<Table> tables ;
	private List<EvalutionEstablishment> establishmentEvalution;
	
	public Establishment() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Establishment(int id, String name, String address, String city,
			double lat, double lng,int level,double moyrating) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.lat = lat;
		this.lng=lng;
		this.level=level;
		this.moyrating=moyrating;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public ServiceProvider getSeProvider() {
		return seProvider;
	}

	public void setSeProvider(ServiceProvider seProvider) {
		this.seProvider = seProvider;
	}
	
	@OneToMany(mappedBy="establishment")
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@OneToMany(mappedBy="establishmentpic")
	public List<EstablishmentPicture> getEstablishmentPictures() {
		return establishmentPictures;
	}

	public void setEstablishmentPictures(List<EstablishmentPicture> establishmentPictures) {
		this.establishmentPictures = establishmentPictures;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLng() {
		return lng;
	}


	public void setLng(double lng) {
		this.lng = lng;
	}


	@OneToMany(mappedBy="establishment")
	public List<EvalutionEstablishment> getEstablishmentEvalution() {
		return establishmentEvalution;
	}


	public void setEstablishmentEvalution(List<EvalutionEstablishment> establishmentEvalution) {
		this.establishmentEvalution = establishmentEvalution;
	}


	@OneToMany(mappedBy="establishment")
	public List<Table> getTables() {
		return tables;
	}


	public void setTables(List<Table> tables) {
		this.tables = tables;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public double getMoyrating() {
		return moyrating;
	}


	public void setMoyrating(double moyrating) {
		this.moyrating = moyrating;
	}

	
	
	
	

}
