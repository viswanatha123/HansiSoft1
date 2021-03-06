package com.DIC.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.DIC.DAO.Impl.ConnectionDAOImpl;
import com.DIC.model.PlotsDataEntryModel;

import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;




import org.primefaces.util.EscapeUtils;

@ManagedBean(name="plotsDataEntryService")
@SessionScoped
public class PlotsDataEntryService implements Serializable{
	
	  private static final Logger log = Logger.getLogger(PlotsDataEntryService.class.getName());
	  
	  private String name;
	  private String location;
	  private int persqft;
	  private int plotarea;
	  private String contactOwner;
	  private String ownerName;
	  private String wonership;
	  private String transaction;
	  private String comment;
	  private int length;
	  private int width;
	  private String updateResult;
	  private String swimingPool;
	  private String playground;
	  private String park;
	  private String wall;
	  private String community;
	  private String facing;
      private String agentName;
  	  private UploadedFile file;

      
     

	  private final Map<String,Map<String,String>> data = new HashMap<>();
	  private String country;   
	  private String city;    
	  private Map<String,String> countries;  
	  private Map<String,String> cities; 



	   ConnectionDAOImpl dao;
	   
	      @PostConstruct 
	      public void init()
	      {
	          log.log(Level.INFO, "Loading PlotsDataEntryService init()");
	          countries  = new HashMap<>();  
	                      //countries.put("USA", "USA");  
	                      //countries.put("India", "India");  
	                      //countries.put("Russia", "Russia"); 
	                      countries.put("Anantapur", "Anantapur"); 
	                      countries.put("Kadapa", "Kadapa");
	                      countries.put("Kurnool", "Kurnool");
	                      countries.put("Tirupati", "Tirupati");
	                      countries.put("Chittoor", "Chittoor");
	                      countries.put("Bangalore", "Bangalore");
	                      countries.put("Ballari", "Ballari");
	                      
	                      Map<String,String> map = new HashMap<>();  
	                     
	                      //****Anantapur*****//
	                      map = new HashMap<>();  
	                      map.put("Kadiri", "Kadiri");  
	                      map.put("Kadiri Rural", "Kadiri Rural");
	                      map.put("Anantapur", "Anantapur");
	                      map.put("Anantapur Rural", "Anantapur Rural");
		                  map.put("Hindupur", "Hindupur");  
	                      map.put("Dharmavaram", "Dharmavaram"); 
	                      map.put("Tadipatri", "Tadipatri"); 
	                      map.put("Tadipatri Rural", "Tadipatri Rural");
	                      map.put("Gooty", "Gooty");
	                      map.put("Gooty Rural", "Gooty Rural");
	                      data.put("Anantapur", map);
	                      
	                      map = new HashMap<>();  
	                      map.put("Pulivendula", "Pulivendula");
	                      map.put("Pulivendula Rural", "Pulivendula Rural");
	                      map.put("Kadapa", "Kadapa");
	                      map.put("Kadapa Rural", "Kadapa Rural");
	                      map.put("Proddatur", "Proddatur");
		                  map.put("Proddatur Rural", "Proddatur Rural");
	                      data.put("Kadapa", map);
	                      
	                      map = new HashMap<>();  
		                  map.put("Kurnool", "Kurnool");
		                  map.put("Kurnool Rural", "Kurnool Rural");
		                  data.put("Kurnool", map);
		                  
		                  map = new HashMap<>();  
		                  map.put("Tirupati", "Tirupati");
		                  map.put("Tirupati Rural", "Tirupati Rural");
		                  data.put("Tirupati", map);
		                  
		                  
		                  map = new HashMap<>();  
		                  map.put("Chittoor", "Chittoor");
		                  map.put("Chittoor Rural", "Chittoor Rural");
		                  data.put("Chittoor", map);
	                      
	                      //****Bangalore*****
	                      map = new HashMap<>();  
	                      map.put("Hoskote", "Hoskote");  
	                      map.put("TinFactory", "TinFactory");  
	                      map.put("K R Puram", "K R Puram"); 
	                      map.put("Maratha Halli", "Maratha Halli");
	                      map.put("Belathuru", "Belathuru");
	                      map.put("Whitefield", "Whitefield");
	                      map.put("H Cross", "H Cross");
	                      data.put("Bangalore", map);
	                      
	                      
	                    //****Ballari*****
	                      map = new HashMap<>();  
	                      map.put("Ballari", "Ballari");  
	                      map.put("Ballari Rural", "Ballari Rural");  
	                      data.put("Ballari", map);
	          
	          
	      }
	      
	public void upload() {
	           if (file != null) {
	            try {
	               
	                
	                log.log(Level.INFO, "Selected county and city ---------->:"+country+"     "+city);
	  	          
	  	     
	  	          dao=new ConnectionDAOImpl();
	  	          
	  	          PlotsDataEntryModel plotsDataEntryModel=new PlotsDataEntryModel();
	  	          plotsDataEntryModel.setName(name);
	  	          plotsDataEntryModel.setLocation(location);
	  	          plotsDataEntryModel.setPersqft(persqft);
	  	          plotsDataEntryModel.setContactOwner(contactOwner);
	  	          plotsDataEntryModel.setOwnerName(ownerName);
	  	          plotsDataEntryModel.setWonership(wonership);
	  	          plotsDataEntryModel.setTransaction(transaction);
	  	          plotsDataEntryModel.setComment(comment);
	  	          plotsDataEntryModel.setLength(length);
	  	          plotsDataEntryModel.setWidth(width);
	  	       
	  	          plotsDataEntryModel.setPrimLocation(country);
	  	          plotsDataEntryModel.setSecoLocation(city);
	  	          plotsDataEntryModel.setSwimingPool(swimingPool);
	  	          plotsDataEntryModel.setPlayground(playground);
	  	          plotsDataEntryModel.setPark(park);
	  	          plotsDataEntryModel.setWall(wall);
	  	          plotsDataEntryModel.setCommunity(community);
	  	          plotsDataEntryModel.setFacing(facing);
	  	          plotsDataEntryModel.setAgentName(agentName);
	  	          plotsDataEntryModel.setInputStream(file.getInputStream());
	  	          plotsDataEntryModel.setFile(file);
	  	          
	  	          updateResult=dao.updatePlotDataEntry(plotsDataEntryModel);
	  	              
	  	         
	  	          this.name="";
	  	          this.location="";
	  	          this.persqft=0;
	  	          this.plotarea=0;
	  	          this.contactOwner="";
	  	          this.ownerName="";
	  	          this.wonership="";
	  	          this.transaction="";
	  	          this.comment="";
	  	          this.length=0;
	  	          this.width=0;
	  	          this.agentName="";
	  	  
	                
	 
	            } catch (Exception e) {
	                System.out.println("Exception-File Upload." + e.getMessage());
	            }
	        }
	        else{
	        FacesMessage msg = new FacesMessage("Please select image!!");
	                FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }
		
	    
	    
	     public void onCountryChange() {  
	          if(country !=null && !country.equals(""))  
	          cities = data.get(country);  
	          else  
	          cities = new HashMap<>();  
	          }  	

	    
	      
	      public void clear()
	      {
	          this.name="";
	          this.location="";
	          this.persqft=0;
	          this.plotarea=0;
	          this.contactOwner="";
	          this.ownerName="";
	          this.wonership="";
	          this.transaction="";
	          this.comment="";
	          this.length=0;
	          this.width=0;
	          this.agentName="";
	          
	          this.updateResult="";
	          System.out.println("****** Clicked on Clear button*****");
	      }
	      
	      
	      
	      
	      public UploadedFile getFile() {
		  		return file;
		  	}

		  	public void setFile(UploadedFile file) {
		  		this.file = file;
		  	}
		  	
		
		    public String getCountry() {
		          return country;
		    }

		      public void setCountry(String country) {
		          this.country = country;
		      }

		      public String getCity() {
		          return city;
		      }

		      public void setCity(String city) {
		          this.city = city;
		      }

		      public Map<String, String> getCountries() {
		          return countries;
		      }

		      public void setCountries(Map<String, String> countries) {
		          this.countries = countries;
		      }

		      public Map<String, String> getCities() {
		          return cities;
		      }

		      public void setCities(Map<String, String> cities) {
		          this.cities = cities;
		      }
		      
		   
		   
		      public String getLocation() {
		          return location;
		      }

		      public void setLocation(String location) {
		          this.location = location;
		      }

		      public int getPersqft() {
		          return persqft;
		      }

		      public void setPersqft(int persqft) {
		          this.persqft = persqft;
		      }

		   
		      public int getPlotarea() {
		          return plotarea;
		      }

		      public void setPlotarea(int plotarea) {
		          this.plotarea = plotarea;
		      }

		      public String getContactOwner() {
		          return contactOwner;
		      }

		      public void setContactOwner(String contactOwner) {
		          this.contactOwner = contactOwner;
		      }

		      public String getOwnerName() {
		          return ownerName;
		      }

		      public void setOwnerName(String ownerName) {
		          this.ownerName = ownerName;
		      }

		      public String getWonership() {
		          return wonership;
		      }

		      public void setWonership(String wonership) {
		          this.wonership = wonership;
		      }


		      public String getTransaction() {
		          return transaction;
		      }

		      public void setTransaction(String transaction) {
		          this.transaction = transaction;
		      }

		      public String getComment() {
		          return comment;
		      }

		      public void setComment(String comment) {
		          this.comment = comment;
		      }

		      public int getLength() {
		          return length;
		      }

		      public void setLength(int length) {
		          this.length = length;
		      }

		      public int getWidth() {
		          return width;
		      }

		      public void setWidth(int width) {
		          this.width = width;
		      }
	  
		      public PlotsDataEntryService() {
		      }
		      
		      public String getName() {
		          return name;
		      }

		 
		      public void setName(String name) {
		          this.name = name;
		      }
		      
		          public String getUpdateResult() {
		          return updateResult;
		      }

		      public void setUpdateResult(String updateResult) {
		          this.updateResult = updateResult;
		      }
		      
		      public String getSwimingPool() {
		          return swimingPool;
		      }

		      public void setSwimingPool(String swimingPool) {
		          this.swimingPool = swimingPool;
		      }
		      
		        public String getPlayground() {
		          return playground;
		      }

		      public void setPlayground(String playground) {
		          this.playground = playground;
		      }
		      
		         public String getPark() {
		          return park;
		      }

		      public void setPark(String park) {
		          this.park = park;
		      }
		      
		         public String getWall() {
		          return wall;
		      }

		      public void setWall(String wall) {
		          this.wall = wall;
		      }
		      
		        public String getCommunity() {
		          return community;
		      }

		      public void setCommunity(String community) {
		          this.community = community;
		      }
		      
		     public String getFacing() {
		  		return facing;
		  	}

		  	public void setFacing(String facing) {
		  		this.facing = facing;
		  	}
		  	
		  	public String getAgentName() {
				return agentName;
			}

			public void setAgentName(String agentName) {
				this.agentName = agentName;
			}
	      

}
