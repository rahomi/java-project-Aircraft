/*
 * Class Name:    Aircrew
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 09 2019, 17:36 
 * Last Modified: Tuesday, May 14 2019, 17:37
 * 
 * Class Description:
 *
 *  Aircrew class for the CSE1OOF Progress Check Test assignment
 *  Semester 1 2019
 *
 */
import java.io.PrintWriter;
import java.io.IOException;

public class Aircrew
{
  private String name;
  private String callSign;
  private int missions;
  private String status;
  
  public Aircrew()
  {}
  public Aircrew(String n,String cs){
    name = n;
    callSign = cs;
    missions = 0;
    setStatus();
  }
  public Aircrew(String n,String cs,int m){
    name = n;
    callSign = cs;
    missions = m;
    setStatus();
  }
  public void setName(String n){
    name = n;
  }
  public String getName(){
    return name;
  }
  public void setCallSign(String cs){
    callSign = cs;
  }
  public String getCallSign(){
    return callSign;
  }
  public void setMissions(int m){
    missions = m;
  }
  public int getMissions(){
    return missions;
  }
  public void addMission(){
    missions++;
    setStatus();
  }
  public void setStatus()
  {
    if(missions >= 0 && missions <= 5)
      status = "Rookie";
    else if(missions >= 6 && missions <= 10)
      status = "Trained";
    else if(missions >= 11 && missions <= 16)
      status = "Veteran";
    else
      status = "Ace pilot";
  }
  public String getStatus()
  {
    return status;
  }
  public String toString()
  {
    return name+"\n"+callSign+"\n"+missions;
  }
}

