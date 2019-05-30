/*
 * Class Name:    Aircraft
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 09 2019, 18:16 
 * Last Modified: Tuesday, May 14 2019, 17:40
 * 
 * Class Description:
 *  This is the Aircraft class, Aircraft now have an array of Crew
 *  This is to be used in the Progress Check Test OOF Sem 1
 *  2019 Assignment.
 *
 *  This is empty, copy your Assignment C code across to get started.
 *
 */
import java.io.PrintWriter;
import java.io.IOException;

public class Aircraft
{
  private String tailCode;
  private String status;
  private Aircrew [] crew;
  private int capacity;
  private int airCrewNumbers;
  
  public String getTailCode(){
    return tailCode;
  }
  public void setTailCode(String tc){
    tailCode =tc;
  }
  public String getStatus(){
    return status;
  }
  public void setStatus(String s){
    status=s;
  }
  public Aircrew[] getCrew(){
    return crew;
  }
//  public void setCrew(Aircrew[] c){
//    crew=c;
//  }
  public int getCapacity(){
    return capacity;
  }
  public void setCapacity(int cap){
    capacity=cap;
  }
  public int getAirCrewNumbers(){
    return airCrewNumbers;
  }
  
  public void addAircrew(String n,String cs){
    Aircrew a = new Aircrew(n,cs);
    crew[airCrewNumbers] = a;
    airCrewNumbers++;
  }
  public void loadAircrew(String n,String cs,int m){
    Aircrew a = new Aircrew(n,cs,m);
    crew[airCrewNumbers] = a;
    airCrewNumbers++;
  }
  
  public void increaseMissions()
  {
    
    for(int i=0;i<capacity;i++)
    {
      if(crew[i]!=null){
      crew[i].addMission();
      }
    }
  }
  
  public boolean checkOverallStatus(String s)
  {
    int var = 0;
    boolean b = true;
    if(s.equalsIgnoreCase("Ace Pilot"))
    {
      for(int i=0;i<capacity;i++)
      {
        if(crew[i]!=null){
        String sts = crew[i].getStatus();
        if(sts.equalsIgnoreCase("Rookie"))
          var = var - 3;
        else if(sts.equalsIgnoreCase("Trained"))
          var = var - 2;
        else if(sts.equalsIgnoreCase("Veteran"))
          var = var - 1;
        else
          var = var - 0;
        }
      }
    }
    else if(s.equalsIgnoreCase("Veteran"))
    {
      for(int i=0;i<capacity;i++)
      {
        if(crew[i]!=null){
        String sts = crew[i].getStatus();
        if(sts.equalsIgnoreCase("Rookie"))
          var = var - 2;
        else if(sts.equalsIgnoreCase("Trained"))
          var = var - 1;
        else if(sts.equalsIgnoreCase("Ace Pilot"))
          var = var + 1;
        else
          var = var - 0;
        }
      }
    }
    else if(s.equalsIgnoreCase("Trained"))
    {
      for(int i=0;i<capacity;i++)
      {
        if(crew[i]!=null){
        String sts = crew[i].getStatus();
        if(sts.equalsIgnoreCase("Rookie"))
          var = var - 1;
        else if(sts.equalsIgnoreCase("Veteran"))
          var = var + 1;
        else if(sts.equalsIgnoreCase("Ace Pilot"))
          var = var + 2;
        else
          var = var - 0;
        }
      }
    }
    else if(s.equalsIgnoreCase("Rookie"))
    {
      for(int i=0;i<capacity;i++)
      {
        if(crew[i]!=null){
        String sts = crew[i].getStatus();
        if(sts.equalsIgnoreCase("Trained"))
          var = var + 1;
        else if(sts.equalsIgnoreCase("Veteran"))
          var = var + 2;
        else if(sts.equalsIgnoreCase("Ace Pilot"))
          var = var + 3;
        else
          var = var - 0;
        }
      }
    }
    if(var<0)
      b = false;
    
    return b;
  }
  
  public boolean aircrewAvailable()
  {
    if(crew[0]==null)
      return false;
    return true;
  }
  
  public Aircraft(){
    
  }
  public Aircraft(String tc, int cp){
    tailCode = tc;
    capacity = cp;
    crew = new Aircrew[cp];
    status= "on deck";
    airCrewNumbers=0;
  }
  public Aircraft(String tc, String st,int cp){
    tailCode = tc;
    capacity = cp;
    crew = new Aircrew[cp];
    status= st;
    airCrewNumbers=0;
  }
  public String toString()
  {  
    return tailCode+"\n"+status+"\n"+capacity+"\n"+airCrewNumbers;
  }
}

