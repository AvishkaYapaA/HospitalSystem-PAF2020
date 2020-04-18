
package Service;

import com.google.gson.JsonObject;

import com.google.gson.JsonParser;

import Beans.HospitalBean;
import Model.Hospital;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Hospital")
public class HospitalService {
	
	Hospital hospital =  new Hospital();
	
	
	 //Read Doctor List
  	@GET
  	@Path("/")
  	@Produces(MediaType.TEXT_HTML)
  	public String readHospital() {
  		return hospital.readHospital();
  	}
  	
  	@POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertHospital(String hospitalData) {

        HospitalBean hospitalObject = new HospitalBean(hospitalData);

        String output = hospital.insertHospital(hospitalObject);
        return output;

    }
  	
  	@PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateHospital(String Hospital) {

        HospitalBean hos = new HospitalBean(Hospital);

        String output = hospital.updateHospital(hos);
        return output;

    }
  	
  	@DELETE
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String removeHospital(String hospitalData) {

  
		JsonObject HospitalObject = new JsonParser().parse(hospitalData).getAsJsonObject();

	    String hospitalID = HospitalObject.get("HospitalID").getAsString();
        String output = hospital.removeHospital(hospitalID);

        return output;

    }

}

