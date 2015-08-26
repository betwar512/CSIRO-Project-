package com.mycompany.app;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import org.cdisc.ns.odm.v1.ODMcomplexTypeDefinitionItemDef;
import org.cdisc.ns.odm.v1.ODMcomplexTypeDefinitionMetaDataVersion;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
/**
 * @author Abbas.h.Safaie
 * 
 * */
public class App 
{


    public static void main( String[] args )
    {
    	
    //	JaxBinder jax=new JaxBinder();
    	
    	ODMcomplexTypeDefinitionMetaDataVersion meta =JaxBinder.catchMetaData("src/main/java/odm1.3_clinical_ext_Full_study_extract_2015-05-22-162457368.xml");
    	
    	HashMap<String,ODMcomplexTypeDefinitionItemDef> itemDef=JaxBinder.catchItemDef(meta);
    	ODMcomplexTypeDefinitionItemDef value=itemDef.get("I_MEDIC_MEDICATIONROUTE");
    	
    	
    	
    	//I_MEDIC_MEDICATIONROUTE
    	
 
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    	
    	
    	Date date = new Date();
    	String time=dateFormat.format(date); //2014/08/06 15:59:48

 
  	RDFModelHelper modelHelper=new RDFModelHelper();
  	
  	//HashMap<String,Model> models=modelHelper.sliceModels();
  	
  	
  OntModel model=	modelHelper.ontoModelTest();
	

	try{

String syntax = "TURTLE"; // also try "N-TRIPLE" 
StringWriter out = new StringWriter();
model.write(out, syntax);
String result = out.toString();

//String fileName = "rdfOnto_test.rdf";
//File file =new File(fileName);
//FileWriter output = new FileWriter( file );

//model.write( output, "TURTLE" );
//output.close();
// RDFDataMgr.write(System.out, model, "N-Triples") ;
System.out.println(result);
  
  	} catch (Exception e) { 
  		System.out.println("Failed: " + e); 
  		} 
	

  
  
  
  
  	
//	for (Entry<String, Model> entry : models.entrySet()) {
//	try{
//  Model model=entry.getValue();
//  String syntax = "TURTLE"; // also try "N-TRIPLE" 
//  StringWriter out = new StringWriter();
//  model.write(out, syntax);
//  String result = out.toString();
//
//  String fileName = "\\RDF_Slice_files\\"+time+"_RDF_Slice_subjectKey_"+entry.getKey()+".rdf";
//  File file =new File(fileName);
//  FileWriter output = new FileWriter( file );
// 
//  model.write( output, "TURTLE" );
//  output.close();
// // RDFDataMgr.write(System.out, model, "N-Triples") ;
//System.out.println(result);
//    
//    	} catch (Exception e) { 
//    		System.out.println("Failed: " + e); 
//    		} 
//	
//		}
    
    }
}
