/*
 * Class Name:    Carrier
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 09 2019, 17:42 
 * Last Modified: Tuesday, May 14 2019, 18:29
 * 
 * Class Description:
 *
 * This is Carrier.java. This is the main driver class for 
 * OOF Progress Check Test Assignment, Sem 1 2019
 *
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Carrier
{
  private final int MAX_AIRCRAFT = 90;
  private int currentPlanes=0;
  private Aircraft [ ] planes;
  
  private final int ADD_AIRCRAFT = 1;
  private final int DISPLAY = 2;
  private final int ADD_AIRCREW = 3;
  private final int LAUNCH = 4;
  private final int LANDING = 5;
  private final int SAVE_TO_FILE = 6;
  private final int EXIT = 7;
  
  private final int DISPLAY_ALL = 11;
  private final int DISPLAY_ALL_AIRCRAFT = 12;
  private final int DISPLAY_ALL_AIRCREW = 13;
  private final int DISPLAY_SINGLE_AIRCRAFT = 14;
  private final int DISPLAY_SINGLE_AIRCREW = 15;
  private final int DISPLAY_AIRCRAFT_ON_DECK = 16;
  private final int DISPLAY_AIRCRAFT_AIRBORNE = 17;
  private final int DISPLAY_EXIT = 18;
  
  private Scanner kb;
  
  public static void main( String [ ] args ) throws IOException
  {
    Carrier c = new Carrier( );
    c.load( );
    c.run( );
  }
  
  public Carrier( )
  {
    kb = new Scanner( System.in );
    planes = new Aircraft[MAX_AIRCRAFT];
  }
  
  /*
   * This method asks the user for an input text file name.
   * The format of the file is detailed in the Assignment.
   * You may assume that the format is always correct.
   *
   * Open the text file and go the file, populating the
   * array of Aircraft with the information in the file
   * you have just opened.
   *
   * Then close the file.
   *
   * This method runs before the user sees the menu for the first 
   * time.
   *
   * If you have any trouble with this method, leave it blank
   * and get things working from the keyboard. You can always
   * come back to this method
   *
   */
  public void load( ) throws IOException
  {
    // pass the path to the file as a parameter 
    String dir = "a.dat";
    File file = new File(dir); 
    Scanner sc = new Scanner(file); 
    
    while (sc.hasNextLine()) {
      String tc = sc.nextLine(); 
      String sts = sc.nextLine();
      int cp = Integer.parseInt(sc.nextLine());
      int num = Integer.parseInt(sc.nextLine());
      if(num>0)
      {
        Aircraft a =  new Aircraft(tc,sts,cp);
        for(int i=0;i<num;i++)
        {
          String n = sc.nextLine();
          String cs = sc.nextLine();
          int m = Integer.parseInt(sc.nextLine());
          a.loadAircrew(n,cs,m);
        }
        planes[currentPlanes] = a;
        currentPlanes++;
      }
      else
      {
        Aircraft a =  new Aircraft(tc,sts,cp);
        planes[currentPlanes] = a;
        currentPlanes++;
      }
    } 
  }
  
  
  
  public void run( ) throws IOException
  {
    int choice = -1;
    while( choice != EXIT )
    {
      displayMainMenu( );
      System.out.print( "Enter choice >> " );
      choice = kb.nextInt( );
      kb.nextLine( );
      processMain( choice );
    }
  }
  
  public void displayMainMenu( )
  {
    System.out.println( "\nOps Main Menu\n" );
    System.out.println( "\t" + ADD_AIRCRAFT + ". Add aircraft");
    System.out.println( "\t" + DISPLAY + ". Display Menu" ); 
    System.out.println( "\t" + ADD_AIRCREW + ". Add air crew" );
    System.out.println( "\t" + LAUNCH + ". Launch Aircraft" );
    System.out.println( "\t" + LANDING + ". Land Aircraft" );
    System.out.println( "\t" + SAVE_TO_FILE + ". Save to file");
    System.out.println( "\t" + EXIT + ". Shut down ops");
  }
  
  public void processMain( int choice  ) throws IOException
  {
    switch( choice )
    {
      case ADD_AIRCRAFT :
        addAircraft( );
        break;
        
      case ADD_AIRCREW :
        addAircrew( );
        break;
        
      case DISPLAY :
        display( );
        break;
        
      case SAVE_TO_FILE :
        save( );
        break;
        
      case LAUNCH :
        launch( );
        break;
        
      case LANDING :
        land( );
        break;
        
      case EXIT :
        // just trap this choice so that it doesn't show as
        // an error
        break;
        
      default:
        System.out.println("That is not a valid choice " +
                           "\nPlease re-enter");
        break;
    }
    
  }
  
  /*
   * This method adds an Aircraft, using the keyboard, very much
   * like Assignment C, except that the address of the new Aircraft
   * is stored in the array, not a stand alone Aircraft object
   * reference.
   *
   * As in Assignment C, you must check that the tail code entered
   * by the user is not already in use.
   *
   */
  private void addAircraft( )
  {
    System.out.print("Enter tail code>> ");
    String tc = kb.nextLine();
    System.out.println();
    System.out.print("Enter capacity>> ");
    int cp = kb.nextInt();
    System.out.println("");
    Aircraft a =  new Aircraft(tc,cp);
    planes[currentPlanes] = a;
    currentPlanes++;
  }
  
  /*
   * This method adds an Aircrew to an Aircraft.
   * The user is first asked for the tail code of an Aircraft.
   * If that Aircraft is found in the array and that Aircraft
   * has not reached its maximum number of Aircrew, then the 
   * user is asked to enter the call sign of the new Aircrew.
   *
   * The code has to go through all the call signs of all the
   * Aircrew in all the Aircraft. If the user entered call sign is
   * not found, then you can ask for the new Aircrew name and 
   * add the Aircrew to the Aircraft. You already know the index
   * of the Aircraft because this is what you looked up at the 
   * start of this method to see if there was an Aircraft with
   * the user entered tail code
   *
   */
  private void addAircrew( )
  {
    System.out.print("Enter tail code >>");
    String tc = kb.nextLine();
    System.out.println();
    int flag = 0;
    int flag2 = 0;
    int index = -1;
    for(int i = 0;i<currentPlanes;i++)
    {
      String info = planes[i].toString();
      String part[] = info.split("\n");
      if(part[0].equalsIgnoreCase(tc)){
        flag = 1;
        index = i;
        int cp = Integer.parseInt(part[2]);
        if(cp==planes[i].getAirCrewNumbers())
          flag2 = 1;
      }      
    }
    if(flag==0)
      System.out.println("Aircraft not found");
    else if(flag2==1)
      System.out.println("This aircraft is already at max aircrew, cannot add");
    else 
    {
      System.out.print("Enter call sign >>");
      String cr = kb.nextLine();
      System.out.println();
      int flag3 = 0;
      for(int i = 0;i<currentPlanes;i++)
      {      
        int m = planes[i].getAirCrewNumbers();
        if(m!=0)
        {
          Aircrew [] crew = planes[i].getCrew();
          for(int j = 0; j<m;j++){
            String infoc = crew[j].toString();
            String partc[] = infoc.split("\n");
            if(partc[1].equalsIgnoreCase(cr)){
              flag3 = 1;
            }
          }
        }
      }
      if(flag3==1)
        System.out.println("Aircrew call signs must be unique, that callSign is already in use");
      else{
        System.out.print("Enter name >>");
        String n = kb.nextLine();
        planes[index].addAircrew(n,cr);
      }
    }
  }
  /*
   * This now becomes the top of the Display menu
   *
   */
  
  private void display( )
  {
    int choice = -1;
    while( choice != DISPLAY_EXIT )
    {
      displayDisplayMenu( );
      System.out.print( "Enter choice >> " );
      choice = kb.nextInt( ) + 10;
      kb.nextLine( );
      processDisplay( choice );
    }
    
  }
  
  /*
   * This method writes the contents of the array back to a 
   * text file. The text file does not have to have the same
   * name as the input file.
   *
   * Remeber to use the format shown in the Assignment, pages 11 - 12
   * The output file must be able to be used as an input file the
   * next time that the program is run.
   *
   * Remember to close the file at the end of this method.
   * If everything seems to be working but there is nothing in
   * the output file, one reason is that you have not closed the
   * output file. Java only finishes writing all the information
   * into the file when you close the file
   *
   */
  private void save( ) throws IOException
  {
    System.out.print( "Enter output file name >> " );
    File myFile = new File(kb.nextLine()); 
    System.out.println();
    PrintWriter fout = new PrintWriter(myFile); 
    for(int i = 0;i<currentPlanes;i++)
    {
      fout.println(planes[i]);
      
      int m = planes[i].getAirCrewNumbers();
      if(m!=0)
      {
        Aircrew [] crew = planes[i].getCrew();
        for(int j = 0; j<m;j++){
          fout.println(crew[j]);
        }
      }
    }
    fout.close();  
  }
  
  /*
   * This method launches Aircraft, that is, starts them on a 
   * mission.
   *
   * The user first enters the tail code of an Aircraft. If that
   * Aircraft is found in the array, then the method checks
   * if the Aircraft is already on a mission.
   * If the Aircraft exists and is not on a mission, then the 
   * methods checks that the Aircraft has at least one Aircrew.
   *
   * If all of the above conditions are true, then and only then
   * is the user asked to enter the required status of the mission.
   *
   * If the overall status level of all the Aircrew of that Aircraft
   * is greater than or equal to the required mission status level,
   * then the Aircraft is launched.
   *
   * This is explained in much more detail in the Assignment document
   *
   */
  private void launch( )
  {
    if(planes[0]!=null){
      System.out.print("Enter tail code >>");
      String tc = kb.nextLine();
      System.out.println();
      int flag = 0;
      
      for(int i = 0;i<currentPlanes;i++)
      {
        String info = planes[i].toString();
        String part[] = info.split("\n");
        //System.out.println(part[0]+" "+tc);
        if(part[0].equalsIgnoreCase(tc)){
          flag = 1;
          if(part[1].equalsIgnoreCase("on deck"))
          {
            if(planes[i].aircrewAvailable())
            {
              System.out.print("Enter required status >>");
              String requiredStatus = kb.nextLine();
              
              if(planes[i].checkOverallStatus(requiredStatus)){
                planes[i].setStatus("airborne");
                planes[i].increaseMissions();
                System.out.println("Aircraft Successfully Launched");
              }
              else
                System.out.print("The Aircrew of this Aircraft does NOT have the required status for this mission.");
            }
            else
              System.out.println("Aircraft does not have any Aircrew");
          }
          else
            System.out.println("Aircraft is already on a mission"); 
        }
        
      }
      if(flag==0)
          System.out.println("Aircraft not found");
    }
    else
      System.out.println("There is no Aircraft available"); 
  }
  
  /*
   * This method is called to end a mission. The user enters
   * the tail code of an Aircraft. If that Aircraft is found
   * in the array and that Aircraft is actaully on a mission,
   * then that Aircraft ends its mission.
   *
   * All this does is set the Aircraft status to "on deck"
   *
   */
  private void land( )
  {
    int flagA = 0;
    for(int i = 0;i<currentPlanes;i++)
    {
      String info = planes[i].toString();
      String part[] = info.split("\n");
      if(part[1].equalsIgnoreCase("airborne"))
      {
        flagA = 1;
      }
    }                                  
    if(flagA==1){
      System.out.print("Enter tail code >>");
      String tc = kb.nextLine();
      System.out.println();
      int flag = 0;
      
      for(int i = 0;i<currentPlanes;i++)
      {
        String info = planes[i].toString();
        String part[] = info.split("\n");
        if(part[0].equalsIgnoreCase(tc)){
          flag = 1;
          if(part[1].equalsIgnoreCase("airborne"))
          {
            planes[i].setStatus("on deck");
            //System.out.println(")
          }
          else
            System.out.println("Aircraft is not airborne"); 
        }
        
      }
      if(flag==0)
          System.out.println("Aircraft not found");
    }
    else
      System.out.println("There is no Aircraft on mission"); 
  }
  
  
  private void displayDisplayMenu( )
  {
    System.out.println("\nDisplay Menu" );
    System.out.println( "\t" + ( DISPLAY_ALL - 10 ) + ". Display All" );
    System.out.println( "\t" + ( DISPLAY_ALL_AIRCRAFT - 10 ) + 
                       ". Display Aircraft only - no aircrew" );
    System.out.println( "\t" + ( DISPLAY_ALL_AIRCREW - 10 ) +
                       ". Display Aircrew only - no Aircraft" );
    System.out.println( "\t" + ( DISPLAY_SINGLE_AIRCRAFT - 10 ) +
                       ". Display single aircraft " );
    System.out.println( "\t" + ( DISPLAY_SINGLE_AIRCREW - 10 ) +
                       ". Display single aircrew" );
    System.out.println( "\t" + ( DISPLAY_AIRCRAFT_ON_DECK - 10 ) +
                       ". Display aircraft on deck" );
    System.out.println( "\t" + ( DISPLAY_AIRCRAFT_AIRBORNE - 10 ) +
                       ". Display airborne aircraft" );
    System.out.println( "\t" + ( DISPLAY_EXIT - 10 ) +
                       ". Return to main menu" );
    
  }
  
  private void processDisplay( int choice )
  {
    switch( choice )
    {
      case DISPLAY_ALL :
        displayAll( );
        break;
        
      case DISPLAY_ALL_AIRCRAFT :
        displayAircraftOnly( );
        break;
        
      case DISPLAY_ALL_AIRCREW :
        displayAircrewOnly( );
        break;
        
      case DISPLAY_SINGLE_AIRCRAFT :
        displaySingleAircraft( );
        break;
        
      case DISPLAY_SINGLE_AIRCREW :
        displaySingleAircrew( );
        break;
        
      case DISPLAY_AIRCRAFT_ON_DECK :
        displayAircraftOnDeck( );
        break;
        
      case DISPLAY_AIRCRAFT_AIRBORNE :
        displayAirborne( );
        break;
        
      case DISPLAY_EXIT :
        // just trap this choice, so that it doesn't appear
        // as an error
        break;
        
      default :
        System.out.println("\nError, that is not a valid choice" +
                           " re enter your choice" ); 
    }
    
  }
  
  /*
   * This methods displays to the screen all the information in 
   * the array, both Aircraft and the the Aircrew associated with
   * each Aircraft.
   *
   * If the Aircraft class has a properly written toString( )
   * method, then this method is small and easy to code.
   *
   * See Lecture / Workshop 10 for more information
   *
   */
  private void displayAll( )
  {
    System.out.println("Here is the list of Aircraft");
    for(int i = 0;i<currentPlanes;i++)
    {
      String info = planes[i].toString();
      String part[] = info.split("\n");
      System.out.println("Aircraft\n\t[\n"+"\tTail Code "+part[0]);
      System.out.println("\tStatus : "+part[1]);
      System.out.println("\tMax Capacity "+part[2]);
      String acn = "\nNo aircrew present";
      if(Integer.parseInt(part[3])!=0)
        acn = "\nList of Air crew";
      System.out.println("\t"+acn);
      
      int m = planes[i].getAirCrewNumbers();
      if(m!=0)
      {
        Aircrew [] crew = planes[i].getCrew();
        for(int j = 0; j<m;j++){
          String infoc = crew[j].toString();
          String partc[] = infoc.split("\n");
          System.out.println("\tAircrew\n\t[\n");
          System.out.println("\t  Name: "+partc[0]);
          System.out.println("\t  Call Sign: "+partc[1]);
          System.out.println("\t  Missions: "+partc[2]);
          System.out.println("\t  Status: "+crew[j].getStatus());
          System.out.println("\n\t]");
        }
      }
      System.out.println("]");
    }
  }
  
  /*
   * This method display all the Aircraft in the array, without
   * their Aircrew information, which makes it different to 
   * dsplayAll.
   *
   * One way of doing this is write a separate method in the
   * Aircrew class that just displays the Aircraft details,
   * this will be different to the toString( ) method which
   * displays everything
   *
   */
  private void displayAircraftOnly( )
  {
    System.out.println("Here is the list of Aircraft (no aircrew)");
    for(int i = 0;i<currentPlanes;i++)
    {
      String info = planes[i].toString();
      String part[] = info.split("\n");
      System.out.println("Aircraft\n\t[\n"+"\tTail Code "+part[0]);
      System.out.println("\tStatus : "+part[1]);
      System.out.println("\tMax Capacity "+part[2]);
      String acn = "\n\tThis aircraft has no aircrew";
        if(Integer.parseInt(part[3])!=0)
          acn = "\n\tThis aircraft has "+Integer.parseInt(part[3])+" aircrew";
        System.out.println("\t"+acn);
      System.out.println("]");
    }
  }
  
  /*
   * This method displays information about each Aircrew, without
   * displaying the Aircraft, so, once again, the toString( )
   * method cannot be called.
   *
   * One way to do this is to return a privacy leak free copy
   * of the Aircres array of each Aircraft, one Aircraft at a 
   * time, and display that array.
   *
   * There are other ways of doing it.
   *
   */
  private void displayAircrewOnly( )
  {
    System.out.println("Here is the list of Aircrew only (no aircraft)");
    for(int i = 0;i<currentPlanes;i++)
    {
      int m = planes[i].getAirCrewNumbers();
      if(m!=0)
      {
        Aircrew [] crew = planes[i].getCrew();
        for(int j = 0; j<m;j++){
          String infoc = crew[j].toString();
          String partc[] = infoc.split("\n");
          System.out.println("\tAircrew\n\t[\n");
          System.out.println("\t  Name: "+partc[0]);
          System.out.println("\t  Call Sign: "+partc[1]);
          System.out.println("\t  Missions: "+partc[2]);
          System.out.println("\t  Status: "+crew[j].getStatus());
          System.out.println("\n\t]");
        }
      }
    }
  }
  
  /*
   * This method displays information about a single Aircraft,
   * including any Aircrew attached to this Aircraft.
   *
   * The user enters the tail code of an Aircraft and if the 
   * Aircraft with this tail code is found in the array, then you
   * already know the index, so just display the Aircraft at
   * this index.
   *
   * If you have written the seach method, then you pass the user
   * entered tail code to the search function. If the search
   * function returns an index that is not -1, then it is one line
   * of code to display the Aircraft.
   *
   */
  private void displaySingleAircraft( )
  {
    System.out.print("Enter tail code >>");
    String tc = kb.nextLine();
    System.out.println();
    int flag = 0;
    
    System.out.println("Here is the requested Aircraft");
    for(int i = 0;i<currentPlanes;i++)
    {
      String info = planes[i].toString();
      String part[] = info.split("\n");
      if(part[0].equalsIgnoreCase(tc)){
        System.out.println("Aircraft\n\t[\n"+"\tTail Code "+part[0]);
        System.out.println("\tStatus : "+part[1]);
        System.out.println("\tMax Capacity "+part[2]);
        String acn = "\nNo aircrew present";
        if(Integer.parseInt(part[3])!=0)
          acn = "\nList of Air crew";
        System.out.println("\t"+acn);
        
        int m = planes[i].getAirCrewNumbers();
        if(m!=0)
        {
          Aircrew [] crew = planes[i].getCrew();
          for(int j = 0; j<m;j++){
            String infoc = crew[j].toString();
            String partc[] = infoc.split("\n");
            System.out.println("\tAircrew\n\t[\n");
            System.out.println("\t  Name: "+partc[0]);
            System.out.println("\t  Call Sign: "+partc[1]);
            System.out.println("\t  Missions: "+partc[2]);
            System.out.println("\t  Status: "+crew[j].getStatus());
            System.out.println("\n\t]");
          }
        }
        System.out.println("]");
        flag = 1;
      }
      if(flag==0)
        System.out.println("Aircraft not found");
    }
    
  }
  
  /*
   * This method displays the information about a single 
   * Aircrew, without the Aircraft that the Aircrew is part of.
   *
   * The user enters a call sign and the program displays the
   * Aircrew with this call sign, if they are found in the array
   * of Aircraft.
   *
   * Hint: This is a bit like adding an aircrew, you need to go 
   * through the Aircrew array of each Aircraft until you find
   * the Aircrew with that call sign, or search all the Aircrew
   * crews and not find the requested call sign
   *
   *
   */
  private void displaySingleAircrew( )
  {
    System.out.print("Enter call sign >>");
    String cr = kb.nextLine();
    System.out.println();
    int flag = 0;
    
    System.out.println("Here is the requested Aircrew");
    for(int i = 0;i<currentPlanes;i++)
    {      
      int m = planes[i].getAirCrewNumbers();
      if(m!=0)
      {
        Aircrew [] crew = planes[i].getCrew();
        for(int j = 0; j<m;j++){
          String infoc = crew[j].toString();
          String partc[] = infoc.split("\n");
          if(partc[1].equalsIgnoreCase(cr)){
            System.out.println("\tAircrew\n\t[\n");
            System.out.println("\t  Name: "+partc[0]);
            System.out.println("\t  Call Sign: "+partc[1]);
            System.out.println("\t  Missions: "+partc[2]);
            System.out.println("\t  Status: "+crew[j].getStatus());
            System.out.println("\n\t]");
            flag = 1;
          }
        }
      }
    }
    if(flag==0)
      System.out.println("Aircrew not found");
  }
  
  /*
   * This method displays all the Aircraft, without Aircrew information,
   * that have status "on deck"
   *
   */
  private void displayAircraftOnDeck( )
  {
    System.out.println("Here is the list of aircraft on deck");
    for(int i = 0;i<currentPlanes;i++)
    {
      String info = planes[i].toString();
      String part[] = info.split("\n");
      if(part[1].equalsIgnoreCase("on deck")){
        System.out.println("Aircraft\n\t[\n"+"\tTail Code "+part[0]);
        System.out.println("\tStatus : "+part[1]);
        System.out.println("\tMax Capacity "+part[2]);
        String acn = "\n\tThis aircraft has no aircrew";
        if(Integer.parseInt(part[3])!=0)
          acn = "\n\tThis aircraft has "+Integer.parseInt(part[3])+" aircrew";
        System.out.println("\t"+acn);
        System.out.println("]");
      }
    }
  }
  
  
  
  /*
   * This method displays all the Aircraft, without Aircrew information,
   * that have status "airborne"
   *
   */
  
  private void displayAirborne( )
  {
    System.out.println("Here is the list of aircraft airborne");
    for(int i = 0;i<currentPlanes;i++)
    {
      String info = planes[i].toString();
      String part[] = info.split("\n");
      if(part[1].equalsIgnoreCase("airborne")){
        System.out.println("Aircraft\n\t[\n"+"\tTail Code "+part[0]);
        System.out.println("\tStatus : "+part[1]);
        System.out.println("\tMax Capacity "+part[2]);
        String acn = "\n\tThis aircraft has no aircrew";
        if(Integer.parseInt(part[3])!=0)
          acn = "\n\tThis aircraft has "+Integer.parseInt(part[3])+" aircrew";
        System.out.println("\t"+acn);
        System.out.println("]");
      }
    }
  }
}
