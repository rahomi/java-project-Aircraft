# java-project-Aircraft
Assessment Objectives:  to design programs that conform to given specifications  to practise combining multiple classes and methods into a whole program  to implement programs in Java.  to practice using arrays of objects.

stored in the text file.
When an Aircrew member first joins the carrier, they have not been part of any missions, their status is rookie. The status is exactly the same as Assignment C.
As an Aircrew member carries out more missions, their status increases.
If the (individual) Aircrew has been on between 0 and 5 missions (inclusive),
then their status is Rookie
If the (individual) Aircrew has been on between 6 and 10 missions (inclusive),
then their status is Trained
If the (individual) Aircrew has been on between 11 and 16 missions (inclusive),
then their status is Veteran
If the (individual) Aircrew has been on more than 16 missions,
then their status is Ace pilot
To be assigned a mission, that is, to be launched, firstly, the user enters the tail code of the requested Aircraft. Provided that that Aircraft is found in the array, then that Aircraft must have at least one Aircrew and not be on a mission. That is, the Aircraft status must be "on deck".
Secondly, the status required for the mission must be within the status of the overall Aircrew for that Aircraft. An Aircrew group with a higher overall status can undertake a mission that requires a lesser overall status, but an Aircrew group with an overall lesser status cannot undertake a mission that requires a higher status.
The Aircrew (all of them together) must have the required overall status before being assigned the mission.
Each time an Aircraft is assigned a mission, the number of missions that the Aircrew (each individual Aircrew member) is incremented by one. The program must then check if the (individual) Aircrew has accumulated enough missions to move to the next status. This applies to all the individual Aircrew members.
When the Aircraft is on a mission, all the Aircrew of that Aircraft are involved in the mission.
To end a mission, (recover an Aircraft), the Aircraft must actually be on a mission.
Further changes from Assignment C
As stated above, the user must identify which Aircraft they want to attempt to assign a mission to, using the tail code. An Aircraft can only take a Mission (be launched) if the overall status of the whole Aircrew group of that Aircraft has a greater than, or equal to, overall status compared to the user entered status.
How is this overall status calculated?
One way of doing it is to assign 0 to a local int variable. This will be the final, overall, status of the group. This local variable will accumulate a total as you go through the array of Aircrew.
Then go through the array of Aircrews, one by one. (This is, of course, after you have selected
and found, the relevant Aircraft)
If the status of an individual Aircrew is the same as the user entered status, add 0 to an accumulating total, that is, that local int variable that you just declared.
If the status of an individual Aircrew is one above the user entered status, then add 1, if it is 2 levels above the user entered status, then add 2 and so on.
If the status of an individual Aircrew is 1 level below the user entered status, then subtract 1, if the status of the particular Aircrew is 2 levels below, subtract 2 and so on.
As before, if the user entered status of the Mission is rookie, then every Aircraft,
with at least one (individual) Aircrew, can undertake that Mission, provided, of course, that the Aircraft is not already on a Mission.
In a bit more detail
It is slightly more complicated if the user entered status is above rookie. One way
to do this is to assign a local int variable for the required overall status, with the starting value of 0.
Then go through the whole array of Aircrew (one by one) in that Aircraft.
If the required status (the one entered by the user) is "Ace pilot"
If the status of an individual Aircrew is "Rookie", then subtract 3 from
the local required overall status int variable.
(You could stop here and return false, just one Aircrew below
"Ace pilot" means there is no way this overall Aircrew can do the Mission)
If the status of an individual Aircrew is "Trained", then subtract 2 from
the local required overall status int variable.
If the status of an individual Aircrew is "Veteran", then subtract 1
from the local required overall status int variable
If the status of an individual Crew is "Ace pilot", then subtract 0
from the local required overall level status int variable.
If the required status (the one entered by the user) is "Veteran"
If the status of an individual Aircrew is "Rookie", then subtract 2 from
the local required overall level status int variable.
If the status of an individual Aircrew is "Trained", then subtract 1 from
the local required overall level status int variable.
If the status of an individual Aircrew is "Veteran", then subtract 0
from the local required overall level status int variable
If the status of an individual Aircrew is "Ace pilot", then add 1 to the
local required overall level status int variable.
If the required status (the one entered by the user) is "Trained"
If the status of an individual Aircrew is "Rookie", then subtract 1 from
the local required overall status int variable.
If the status of an individual Aircrew is "Trained", then subtract 0 from
the local required overall status int variable.
If the status of an individual Aircrew is "Veteran", then add 1
to the local required overall status int variable
If the status of an individual Crew is "Ace pilot", then add 2 to
the local required overall level status int variable.
After doing this for all the Aircrew(s) in the selected Aircraft, if the final overall required
status local int variable is greater than or equal to 0, then the Aircrew(s) in that
Aircraft have an overall status that is equal to or better than the required
status, as entered by the user, and so can take the mission.
As always, provided an Aircraft with the user entered tail code exists and has at least
one Aircrew and the Aircraft is not already on a Mission.
To end a mission, (recover) the Aircraft identified by the user entered tail code must actually exist in the array of Aircraft and be on a mission.
Program Requirements
You have been asked to write an interactive program, in Java, to aid in monitoring and maintaining all aspects of Carrier Operations.
This program expands on the earlier work done in Assignment Part C and now needs to
handle 90 Aircraft. Each Aircraft can now have more than one Aircrew associated with it.
To aid in the rapid development of this program, 3 Java files and 1 sample input file are provided for you:
Aircrew.java, Aircraft.java, Carrier.java and a sample input file a.dat
Copy them from the unit library area into your current directory using:
cp /home/1st/csilib/cse1oof/prog/* . Don't forget the .
WARNING
You can re-use large parts of your Assignment Part C Aircrew.java and Aircraft.java files and some parts of Carrier.java.
Before you copy the start-up files for this assignment from the directory listed below, MAKE SURE THAT YOU CREATE A SEPARATE DIRECTORY FOR THIS ASSIGNMENT! Change into this new directory first, then enter the copy command listed below.
If you do not create a separate directory and run the copy command, you will overwrite your Assignment Part C Aircraft.java and Aircrew.java and we cannot recover these files. You will have to start all over again.
After you have copied the start-up files, compile them and run the program to see how the expanded menu structure fits together. The Aircraft.java and Aircrew.java files from the library area are empty, just to get the driver class, Carrier.java, to compile.
After you compile and run the program, begin by reading the changes that are required in Aircrew.java (not many) and Aircraft.java (quite a few) then copy your Assignment Part C Aircrew.java and Aircraft.java into your new directory and re-compile the program, it should still compile, but won't do anything yet, but show the menus.
In order to further speed up the development of this program, some of the files listed above have been partially implemented for you, read the comments in the files and in this document.
Aircrew.java
(almost the same as Assignment Part C)
(this is still for one individual Aircrew)
All Aircrew objects have the following object attributes:
 name This is a String (text) and is the name of the Aircrew, may be more
than one word
 call sign This is a String (text) and is the unique call sign of the Aircrew, may be
more than one word
 missions This is an integer and is the number of missions that the Aircrew
has participated in.(See the explanation below)
 status This is a String and is one of the four status levels, as described above. The
status level is always based on the number of missions that the Aircrew
has participated in, and must be set by the program.
The user must NEVER be able to enter the status level, nor is it ever
read from, or stored in a file.
The Aircrew class requires the following functionality:
A constructor that takes name, call sign, and missions as parameters. This is the constructor that is called when a new Aircrew is added from the text file. From the file, all three of these parameters have values.
The format of the input text file is shown on pages 11 - 12
Recall that it is the number of missions that determines the status, so there has to be a way for the constructor to set the status. If this constructor is also used for keyboard input, then the number of missions must be set to 0 as the Aircrew has just been created.
Alternatively, you could write an overloaded constructor, just for use with the keyboard, this just takes the first two values (name and call sign) as parameters and assigns 0 to the number of missions.
Either way, the status must be set by the constructor, not the user.
This is where you write a private helper method in the Aircrew class, similar to the setCategory method in lab 7. Call it setStatus( ) for example.
The Aircrew class also requires accessor methods as you deem appropriate.
The Aircrew class also requires a method to increment the number of missions. Calling this method adds one to the number of missions for that Aircrew in the Aircraft. This method should then check whether that moves that Aircrew to the next status.
It is suggested that you add a method to the Aircrew class that takes a PrintWriter object as a parameter. This will be useful when you write the contents of the whole Aircraft array
back to a text file. There are other ways of doing this, for example, calling all the public get methods of Aircrew in Aircraft (or even Carrier). There is no "right answer".
Finally the Aircrew class requires a toString method which returns a String with information about the Aircrew object.
Please note that this time you are free to format the screen output in any way, provided only that the user of the program can easily understand the information being displayed.
This is Carrier operations after all, the users need to be able to take in the information at a glance, not spend time trying to decipher poorly formatted output.
Carrier operations don't stop while the user tries to read information.
Aircraft.java
(some major changes)
The Aircraft class now has the following attributes:
 tail code This is a String (text) and may consist of more than one word
The tail code is the unique identifier for an Aircraft
 status This is a String variable, the value "on deck" indicates that the
Aircraft is NOT on a Mission. The value "airborne" indicates that the
Aircraft is on a Mission
 crew This is now an array of Aircrew class object references for the
Aircrew objects associated with this Aircraft.
(when the Aircrew objects are added and instantiated)
 capacity This is the maximum number of Aircrew(s) that can be in this Aircraft.
This is set by the user when the Aircraft object is created, or read from
the input text file.
 aircrewNumbers
This is the current number of Aircrew(s) actually in the Aircraft,
starts at 0 when the Aircraft is instantiated, both from the keyboard and
the file.
The Aircraft class still requires at least 2 overloaded constructors.
An overloaded constructor, for keyboard input for an Aircraft. This constructor would take just the tail code and the capacity attributes as parameters. Since we have just created the Aircraft object the value of status must be "on deck" (it cannot be on a Mission) and as there are no Aircrew(s) associated with this Aircraft, the aircrewNumbers is 0.
A second, overloaded, constructor would be used when reading from a text file. When reading from a text file, the tail code is in the file as is the capacity. In addition there is a value for status. The number of Aircrew will also be in the file and will be read out but not stored in the Aircraft object
For both constructors, only Aircraft information is passed in, no Aircrew information.
In both constructors, do not forget to correctly deal with the array of Aircrew.
The Aircraft class will require accessor methods as you deem appropriate.
One of those accessor methods may be a method to return a copy of the Aircrew array. If you decide to write this accessor, remember to take privacy leaks into consideration.
The Aircraft class also requires a toString method that returns a String with information about the state of that Aircraft object, including any Aircrew and mission status. As with the Aircrew screen output, this time you are free to format the output anyway you want. (Provided that it is easy to read, output all on one line is NOT acceptable)
The Aircraft class requires at least one method to add an Aircrew to an Aircraft.
This method takes all of the relevant parameters for instantiating an Aircrew object from the keyboard, that is, call sign and name. Using the information (which comes from Carrier) in these parameters, instantiate an Aircrew object which is stored in the Aircrew array, (of the Aircraft that the user has selected and checked that it exists) provided that there is a free space. As before, the program first needs to check that the Aircrew call sign entered by the user is indeed unique. (Across all Aircrew's in all Aircraft, this has to be done in Carrier).
A second, overloaded method to add an Aircrew should be considered. This method will take all the information for adding an Aircrew from the text file. The difference is that, from the file, in addition to the call sign and name, the number of missions is included, whereas when reading the information from the keyboard, the number of missions is, of course, 0.
There will be a number of mutator methods that you will find you need to write, amongst them a method to increase the number of missions (add 1) for all the Aircrew(s), in that Aircraft, every time the Aircraft starts a new mission. This should be just one method.
As with the Aircrew class, you may want to consider writing a method that writes the details of the Aircraft object, including all the associated Aircrew, to a text file. Remember to write the actual number of Aircrews figure (aircrewNumbers) into the text file. This is required so that when we use that output file as an input file, the program knows how many Aircrew records it needs to read before the next Aircraft record starts.
As discussed above, the overall status of all the Aircrew, in an Aircraft, must be greater than or equal to the status of the Mission as entered by the user. You may want to consider writing a method that takes the user entered status as a parameter and returns true or false whether, or not, the overall status of the Aircrew is sufficient for the Aircraft to be assigned the mission (provided, first, that all the other conditions are met). This could make use of the algorithm that was described above on page 6.
The Aircrew and Aircraft classes do NOT ask the user for any input, either keyboard or file. There must not be any input objects in these classes such as Scanner or BufferedReader but not limited to these 2. Another way of saying this is that these classes are not interactive.
loading the array of Aircraft from a text file
The program now starts by asking the user for the name of a text file, see pages 11 - 12 for the format. This file will contain a number of Aircraft/Aircrew records. The file name will always exist, and this time will not be empty.
The contents of this file is used to populate the array of Aircraft, in Carrier. Once the contents of this file have been read into the array of Aircraft, the file is closed. The only time that a file is opened again is if the user selects it in the save option. Save can use an entirely different file name than the input file name.
Where the Aircraft has at least one Aircrew (meaning any number of Aircrew(s) greater than 0) then you want to call your overloaded addAircrew method from the Aircraft class, the one that takes all the Aircrew attributes, for one Aircrew at a time. Use this method to add a Aircrew to the correct Aircraft, one at a time.
There is a slightly different menu.
The program must work with any file name entered by the user (of the correct format), that is, the file name must not be hard coded.
An example of the information, in the text file, on each Aircraft consists of 4 lines. (3 lines for the Aircraft object and one additional line to indicate the number of Aircrew records that follow). There may be any number of 3 line Aircrew records after the Aircraft information. The Aircraft and Aircrew information is collectively known as a record:
An example of an input file:
94 A 001 unique tail code of the Aircraft
On deck
indicates the Aircraft is not on a Mission (status)
4
the maximum number (capacity) of Aircrew(s) for this Aircraft
0
the actual number of Aircrew in this Aircraft
94 A 002 unique tail code of the Aircraft
on deck
indicates the Aircraft is not on a Mission (status)
1
the maximum number (capacity) of Aircrew(s) for this Aircraft
1
the actual number of Aircrew in this Aircraft
Nav 01 Aviator
name of the Aircrew
panda bear
unique call sign of the Aircrew (unique across all Aircrew in all Aircraft)
10
number of missions this Aircrew has undertaken
ZZ 056 unique tail code of the Aircraft
On deck
indicates the Aircraft is not on a Mission (status)
3
the maximum number (capacity) of Aircrew(s) for this Aircraft
2
the actual number of Aircrew in this Aircraft
Pete Mitchell
name of the Aircrew
Maverick
unique call sign of the Aircrew (unique across all Aircrew in all Aircraft)
5
number of missions this Aircrew has undertaken
Nick Bradshaw
name of the Aircrew
Goose
unique call sign of the Aircrew (unique across all Aircrew in all Aircraft)
5
number of missions this Aircrew has undertaken
In the example above, the first 3 lines are required to instantiate the Aircraft object reference, (which is added to the array of Aircraft in Carrier, if there is space) the fourth line indicates the number of Aircrew objects to read, followed by this number of groups of 3 lines, which are required to instantiate the Aircrew object references in that Aircraft object.
The file may contain any number of records.
Given that this method is called before the user gets to see the main menu, there is now no need to worry about unique Aircrew call signs and Aircraft tail code's conflicting with anything that the user may enter.
The driver program, Carrier.java then presents the user with a menu, as follows:
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >>
Implement the functionality of each menu choice as follows (assume user input is always an integer):
1. Add Aircraft (very much the same as Assignment C)
This menu option is chosen when the user attempts to add an Aircraft object from the keyboard.
This time the difference is the program must first check if there is a free space in the Aircraft array.
Provided there is space, the first thing that the user will enter is the tail code of the Aircraft to add. The program must check that this tail code is not already assigned to any Aircraft in the array of Aircraft.
(Hint: write a search method, in Carrier.java, that searches through the array of Aircraft and returns the index of the requested Aircraft (using the tail code as the parameter)
or -1 if the Aircraft with the requested tail code is not found. See Lecture/Workshop 10)
If there is space in the array and the tail code is unique, the user is asked for all the relevant Aircraft information (which is the maximum number (capacity) of Aircrew this Aircraft can accommodate) and the resultant Aircraft object is added to the next free space in the array of Aircraft. If there is no free space in the array, the program returns to the main menu without asking the user for any information.
Note: Carrier class must NOT have Aircrew object attribute(s) or Aircrew object references. All interactions involving Aircrew will still be through the relevant Aircraft object.
If the tail code is already assigned to an Aircraft, the user is informed via a message to the screen and the program returns to the main menu.
Still NO Crew information is entered in this menu choice.
2. Display Menu
This menu choice displays the contents of the non-null Aircraft object references to the screen. The format is shown in the sample run of the program on page 18. This time you are free to format the output any way you see fit, with a reminder that the output must be easy for the user of the program to quickly understand. Calling any of these menu choices must not result in the program crashing (for example, NullPointerException)
This is now the top level menu for display. When the user selects this top level option, another sub menu will be presented.
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >>
1. Display All
Choosing this menu option, all of the Aircraft, with all their Aircrews, are
displayed to the screen.
2. Display Aircraft only - no aircrew
Choosing this menu option, all of the Aircraft, this time without any
Aircrew information, are displayed to the screen.
3. Display Aircrew only, no Aircraft
Choosing this menu option, all of the Aircrews, this time without any
Aircraft information, are displayed to the screen.
4. Display single aircraft
Choosing this menu option, the user is prompted (asked) for the
tail code of an Aircraft. If the Aircraft with that tail code is found in
the array, then all the information about that Aircraft, including its
Aircrew(s), are displayed to the screen. If the Aircraft with that tail code
is not found in the array, then an appropriate message is displayed to the screen.
5. Display single aircrew
Choosing this menu option, the user is prompted (asked) for the call sign of
an Aircrew. If the Aircrew with that call sign is found, then the information
for that one Aircrew is displayed to the screen. (Only Aircrew information,
no Aircraft information).If the Aircrew with the requested call sign
is not found, then an appropriate message is displayed to the screen.
6. Display Aircraft on deck
Choosing this menu option, all the Aircraft that are NOT on a Mission
are displayed to the screen. Just the Aircraft information is shown,
no Aircrew information.
7. Display airborne Aircraft
Choosing this menu option, all the Aircraft that ARE on a Mission
are displayed to the screen. Just the Aircraft information is shown,
no Aircrew information.
8. Return to main menu
3. Add Crew (basically the same as Assignment C, except it uses an array)
This menu choice adds an Aircrew to an Aircraft, using information from the keyboard. First, of course, the program must check that there is actually at least one Aircraft in the array. If there are no Aircraft (that is, the array of Aircraft is empty), then the user is informed with a message to the screen and the program returns to the main menu. The user is not asked for any further information.
If there is at least one Aircraft object in the array, then the user is asked for the tail code of an Aircraft. The program tries to find the Aircraft with this tail code. (Hint: use your search method again)
If the Aircraft with the user entered tail code is found, then there is one further check. This is to check that that Aircraft does not already have its maximum number (capacity) of Aircrews. If the Aircraft already has its maximum number of Aircrew, then the user is informed via a message to the screen, no further information is asked from the user, and the program returns to the main menu.
If the Aircraft with the user entered tail code is found and is not at its capacity of Aircrews, then the user is asked to enter the call sign of an Aircrew. There is one final check. The program must check that this user entered Aircrew call sign is not already in use. If the user entered call sign is already in use, then the user is informed, via a message to the screen, no further information is requested from the user, and the program returns to the main menu.
This is a more complex problem than in Assignment C, although it is still the same condition. As each Aircraft now has an array of Aircrew, the program has to go through all the Aircraft objects in the array of Aircraft and check through the array of Aircrew(s) in each Aircraft. Only when this has been done and the call sign for that Aircrew (the one entered by the user) has not been found, in any of the Aircraft, do we know that the call sign entered by the user is indeed unique.
There are 2 basic strategies for doing this, the first is to return a (privacy leak free) copy of the Aircrew array for an individual Aircraft to the main driver program (Carrier). The program can then go through this array comparing the call sign's in that array with the call sign entered by the user. If the call sign is not found and there is another Aircraft in the array of Aircraft, the program moves to the next Aircraft, gets a copy of the Aircrew array for that Aircraft and searches through that array.
The alternative is to write a method in the Aircraft class that takes the user entered call sign as a parameter. The method in the Aircraft class searches through the Aircrew array and returns true or false as to whether the call sign passed in as a parameter was found.
Either method is acceptable, write the one that you feel most comfortable with.
If the program gets to this point, then there is an Aircraft object with the user entered tail code and the user entered call sign is unique. The user is then asked to enter the name of the Aircrew (you already know the call sign) and the Aircrew object is added to the crew array for that Aircraft object. (The number of missions must be 0, as we have just instantiated the Aircrew and the status is worked out by the Aircrew constructor, based on the number of missions).
If there is not an Aircraft with the user entered tail code, then a message is displayed to the screen and the program returns to the main menu, without asking for any more information.
4. Launch Aircraft
This menu choice first checks that there is at least one Aircraft in the array. If not, then an appropriate message is displayed to the screen and the program returns to the main menu. If there is at least one Aircraft in the array, then the user is prompted (asked) for the tail code of an Aircraft.
The program must then find the Aircraft with this tail code, again, you could use the search method. The Aircraft we are looking for could be anywhere in the array. If the Aircraft with that tail code is not found, then an appropriate message is displayed to the screen and the program returns to the main menu.
If the Aircraft with that tail code is found, then the program must check that this Aircraft is available for a mission.
To be available for a mission, the Aircraft must not be on a mission and the Aircraft must have at least one Aircrew. If this is true, the user enters the required status of the mission. The Aircrew(s) (the whole group of Aircrew in this Aircraft) must have an overall status greater than or equal to the status entered by the user. This is explained in detail above.
If the Aircraft is not available for a mission, then an appropriate message is displayed to the screen and the program returns to the main menu.
If the Aircraft can be launched, that is, assigned a mission, then the appropriate changes are made to the Aircraft object. This includes changing the status of the Aircraft to "airborne" and incrementing the number of missions, by one, for all the Aircrew, of that Aircraft. Do not forget to check whether the increased number of missions crosses one of the boundaries of the Aircrew status, resulting in a change in Aircrew status.
The program always returns to the main menu at the end of the menu choice, regardless of the action taken or not taken.
5. Land Aircraft
This menu choice prompts (asks) the user for the tail code of an Aircraft, after making the same checks as in Launch Aircraft, that is, there is actually at least one Aircraft. As with Launch Aircraft appropriate messages should be displayed to the screen if the Aircraft with the user entered tail code is not found, the array of Aircraft is empty, or if the tail code is found but that Aircraft is not already on a mission. (You can't end a mission unless the Aircraft is currently on a mission.)
If any of the above are true, then the program returns to the main menu.
If the Aircraft with the user entered tail code exists and the Aircraft is on a mission, then the status attribute is set to "on deck", indicating that the Aircraft is not on a mission.
After the conclusion of any and all actions in this menu choice, the program returns to the main menu.
6. Save to file (see page 32 for how to do this)
Choosing this menu option, the user is prompted (asked) for the name of an output text file
and all the information in the array of Aircraft (including all Aircrews) is written to this text file.
File names must NOT be hard coded.
Also recall that this output file must be able to be used as input file the next time that
the program is run, so the output file needs to be written to the file in the format as shown on pages 11 - 12. (Do not forget to write the number of Aircrew associated with an Aircraft to the text file)
7. Shut down ops
This menu choice closes the program, without asking the user if they would like to save their
changes.
Example run of the program (NOTE not all functionality and error checks/messages are shown)

> java Carrier
Enter input file name >> a.dat
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 1
Here is the list of Aircraft
How the assignment is marked
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
No aircrew present
]
Aircraft
[
Tail Code 94 A 002
Status : on deck
Max capacity 1
List of Air Crew
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 10
Status : Trained
]
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
]
Aircraft
[
Tail Code 2019 T Y
Status : On deck
Max capacity 5
List of Air Crew
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 20
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 10
Status : Trained
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 0
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 4
Enter tail code >> 2019 t y
Enter required status >> veteran
The Aircrew of this Aircraft does NOT have the required status for this mission.
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 4
Enter tail code >> ZZ Top
No Aircraft with the tail code ZZ Top was found
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 4
Enter tail code >> 2019 t y
Enter required status >> trained
Aircraft successfully launched
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 1
Here is the list of Aircraft
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
No aircrew present
]
Aircraft
[
Tail Code 94 A 002
Status : on deck
Max capacity 1
List of Air Crew
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 10
Status : Trained
]
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
]
Aircraft
[
Tail Code 2019 T Y
Status : airborne
Max capacity 5
List of Air Crew
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 21
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 1
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 2
Here is the list of Aircraft (no aircrew)
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
This aircraft has no aircrew
]
Aircraft
[
Tail Code 94 A 002
Status : on deck
Max capacity 1
This aircraft has 1 aircrew
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
This aircraft has 2 aircrew
]
Aircraft
[
Tail Code 2019 T Y
Status : airborne
Max capacity 5
This aircraft has 3 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 3
Here is the list of Aircrew only (no aircraft)
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 10
Status : Trained
]
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 21
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 1
Status : Rookie
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 4
Enter tail code >> zz 056
Here is the requested Aircraft
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 5
Enter aircrew call sign >> oof ness
Here is the requested aircrew
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 6
Here is the list of aircraft on deck
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
This aircraft has no aircrew
]
Aircraft
[
Tail Code 94 A 002
Status : on deck
Max capacity 1
This aircraft has 1 aircrew
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
This aircraft has 2 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 7
Here is the list of Aircraft that are airborne
Aircraft
[
Tail Code 2019 T Y
Status : airborne
Max capacity 5
This aircraft has 3 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 5
Enter tail code >> 94 A 002
This aircraft is not airborne
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 3
Enter tail code >> 94 A 002
This aircraft is already at max aircrew, cannot add
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 4
Enter tail code >> 94 A 002
Enter required status >> trained
Aircraft successfully launched
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 2
Here is the list of Aircraft (no aircrew)
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
This aircraft has no aircrew
]
Aircraft
[
Tail Code 94 A 002
Status : airborne
Max capacity 1
This aircraft has 1 aircrew
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
This aircraft has 2 aircrew
]
Aircraft
[
Tail Code 2019 T Y
Status : airborne
Max capacity 5
This aircraft has 3 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 5
Enter tail code >> 2019 t y
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 2
Here is the list of Aircraft (no aircrew)
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
This aircraft has no aircrew
]
Aircraft
[
Tail Code 94 A 002
Status : airborne
Max capacity 1
This aircraft has 1 aircrew
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
This aircraft has 2 aircrew
]
Aircraft
[
Tail Code 2019 T Y
Status : on deck
Max capacity 5
This aircraft has 3 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 3
Enter tail code >> 2019 t y
Enter call sign >> oof ness
Aircrew call signs must be unique, that callSign is already in use
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 3
Enter tail code >> 2019 t y
Enter call sign >> Smashed It
Enter name >> Almost There
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 1
Here is the list of Aircraft
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
No aircrew present
]
Aircraft
[
Tail Code 94 A 002
Status : airborne
Max capacity 1
List of Air Crew
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 11
Status : Veteran
]
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
]
Aircraft
[
Tail Code 2019 T Y
Status : on deck
Max capacity 5
List of Air Crew
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 21
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 1
Status : Rookie
]
Aircrew
[ Name: Almost There Call Sign: Smashed It
Missions : 0
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 6
Enter output file name >> b.dat
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 7
> java Carrier
Enter input file name >> b.dat
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 1
Here is the list of Aircraft
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
No aircrew present
]
Aircraft
[
Tail Code 94 A 002
Status : airborne
Max capacity 1
List of Air Crew
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 11
Status : Veteran
]
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
]
Aircraft
[
Tail Code 2019 T Y
Status : on deck
Max capacity 5
List of Air Crew
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 21
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 1
Status : Rookie
]
Aircrew
[ Name: Almost There Call Sign: Smashed It
Missions : 0
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 7
Fistored in the text file.
When an Aircrew member first joins the carrier, they have not been part of any missions, their status is rookie. The status is exactly the same as Assignment C.
As an Aircrew member carries out more missions, their status increases.
If the (individual) Aircrew has been on between 0 and 5 missions (inclusive),
then their status is Rookie
If the (individual) Aircrew has been on between 6 and 10 missions (inclusive),
then their status is Trained
If the (individual) Aircrew has been on between 11 and 16 missions (inclusive),
then their status is Veteran
If the (individual) Aircrew has been on more than 16 missions,
then their status is Ace pilot
To be assigned a mission, that is, to be launched, firstly, the user enters the tail code of the requested Aircraft. Provided that that Aircraft is found in the array, then that Aircraft must have at least one Aircrew and not be on a mission. That is, the Aircraft status must be "on deck".
Secondly, the status required for the mission must be within the status of the overall Aircrew for that Aircraft. An Aircrew group with a higher overall status can undertake a mission that requires a lesser overall status, but an Aircrew group with an overall lesser status cannot undertake a mission that requires a higher status.
The Aircrew (all of them together) must have the required overall status before being assigned the mission.
Each time an Aircraft is assigned a mission, the number of missions that the Aircrew (each individual Aircrew member) is incremented by one. The program must then check if the (individual) Aircrew has accumulated enough missions to move to the next status. This applies to all the individual Aircrew members.
When the Aircraft is on a mission, all the Aircrew of that Aircraft are involved in the mission.
To end a mission, (recover an Aircraft), the Aircraft must actually be on a mission.
Further changes from Assignment C
As stated above, the user must identify which Aircraft they want to attempt to assign a mission to, using the tail code. An Aircraft can only take a Mission (be launched) if the overall status of the whole Aircrew group of that Aircraft has a greater than, or equal to, overall status compared to the user entered status.
How is this overall status calculated?
One way of doing it is to assign 0 to a local int variable. This will be the final, overall, status of the group. This local variable will accumulate a total as you go through the array of Aircrew.
Then go through the array of Aircrews, one by one. (This is, of course, after you have selected
and found, the relevant Aircraft)
If the status of an individual Aircrew is the same as the user entered status, add 0 to an accumulating total, that is, that local int variable that you just declared.
If the status of an individual Aircrew is one above the user entered status, then add 1, if it is 2 levels above the user entered status, then add 2 and so on.
If the status of an individual Aircrew is 1 level below the user entered status, then subtract 1, if the status of the particular Aircrew is 2 levels below, subtract 2 and so on.
As before, if the user entered status of the Mission is rookie, then every Aircraft,
with at least one (individual) Aircrew, can undertake that Mission, provided, of course, that the Aircraft is not already on a Mission.
In a bit more detail
It is slightly more complicated if the user entered status is above rookie. One way
to do this is to assign a local int variable for the required overall status, with the starting value of 0.
Then go through the whole array of Aircrew (one by one) in that Aircraft.
If the required status (the one entered by the user) is "Ace pilot"
If the status of an individual Aircrew is "Rookie", then subtract 3 from
the local required overall status int variable.
(You could stop here and return false, just one Aircrew below
"Ace pilot" means there is no way this overall Aircrew can do the Mission)
If the status of an individual Aircrew is "Trained", then subtract 2 from
the local required overall status int variable.
If the status of an individual Aircrew is "Veteran", then subtract 1
from the local required overall status int variable
If the status of an individual Crew is "Ace pilot", then subtract 0
from the local required overall level status int variable.
If the required status (the one entered by the user) is "Veteran"
If the status of an individual Aircrew is "Rookie", then subtract 2 from
the local required overall level status int variable.
If the status of an individual Aircrew is "Trained", then subtract 1 from
the local required overall level status int variable.
If the status of an individual Aircrew is "Veteran", then subtract 0
from the local required overall level status int variable
If the status of an individual Aircrew is "Ace pilot", then add 1 to the
local required overall level status int variable.
If the required status (the one entered by the user) is "Trained"
If the status of an individual Aircrew is "Rookie", then subtract 1 from
the local required overall status int variable.
If the status of an individual Aircrew is "Trained", then subtract 0 from
the local required overall status int variable.
If the status of an individual Aircrew is "Veteran", then add 1
to the local required overall status int variable
If the status of an individual Crew is "Ace pilot", then add 2 to
the local required overall level status int variable.
After doing this for all the Aircrew(s) in the selected Aircraft, if the final overall required
status local int variable is greater than or equal to 0, then the Aircrew(s) in that
Aircraft have an overall status that is equal to or better than the required
status, as entered by the user, and so can take the mission.
As always, provided an Aircraft with the user entered tail code exists and has at least
one Aircrew and the Aircraft is not already on a Mission.
To end a mission, (recover) the Aircraft identified by the user entered tail code must actually exist in the array of Aircraft and be on a mission.
Program Requirements
You have been asked to write an interactive program, in Java, to aid in monitoring and maintaining all aspects of Carrier Operations.
This program expands on the earlier work done in Assignment Part C and now needs to
handle 90 Aircraft. Each Aircraft can now have more than one Aircrew associated with it.
To aid in the rapid development of this program, 3 Java files and 1 sample input file are provided for you:
Aircrew.java, Aircraft.java, Carrier.java and a sample input file a.dat
Copy them from the unit library area into your current directory using:
cp /home/1st/csilib/cse1oof/prog/* . Don't forget the .
WARNING
You can re-use large parts of your Assignment Part C Aircrew.java and Aircraft.java files and some parts of Carrier.java.
Before you copy the start-up files for this assignment from the directory listed below, MAKE SURE THAT YOU CREATE A SEPARATE DIRECTORY FOR THIS ASSIGNMENT! Change into this new directory first, then enter the copy command listed below.
If you do not create a separate directory and run the copy command, you will overwrite your Assignment Part C Aircraft.java and Aircrew.java and we cannot recover these files. You will have to start all over again.
After you have copied the start-up files, compile them and run the program to see how the expanded menu structure fits together. The Aircraft.java and Aircrew.java files from the library area are empty, just to get the driver class, Carrier.java, to compile.
After you compile and run the program, begin by reading the changes that are required in Aircrew.java (not many) and Aircraft.java (quite a few) then copy your Assignment Part C Aircrew.java and Aircraft.java into your new directory and re-compile the program, it should still compile, but won't do anything yet, but show the menus.
In order to further speed up the development of this program, some of the files listed above have been partially implemented for you, read the comments in the files and in this document.
Aircrew.java
(almost the same as Assignment Part C)
(this is still for one individual Aircrew)
All Aircrew objects have the following object attributes:
 name This is a String (text) and is the name of the Aircrew, may be more
than one word
 call sign This is a String (text) and is the unique call sign of the Aircrew, may be
more than one word
 missions This is an integer and is the number of missions that the Aircrew
has participated in.(See the explanation below)
 status This is a String and is one of the four status levels, as described above. The
status level is always based on the number of missions that the Aircrew
has participated in, and must be set by the program.
The user must NEVER be able to enter the status level, nor is it ever
read from, or stored in a file.
The Aircrew class requires the following functionality:
A constructor that takes name, call sign, and missions as parameters. This is the constructor that is called when a new Aircrew is added from the text file. From the file, all three of these parameters have values.
The format of the input text file is shown on pages 11 - 12
Recall that it is the number of missions that determines the status, so there has to be a way for the constructor to set the status. If this constructor is also used for keyboard input, then the number of missions must be set to 0 as the Aircrew has just been created.
Alternatively, you could write an overloaded constructor, just for use with the keyboard, this just takes the first two values (name and call sign) as parameters and assigns 0 to the number of missions.
Either way, the status must be set by the constructor, not the user.
This is where you write a private helper method in the Aircrew class, similar to the setCategory method in lab 7. Call it setStatus( ) for example.
The Aircrew class also requires accessor methods as you deem appropriate.
The Aircrew class also requires a method to increment the number of missions. Calling this method adds one to the number of missions for that Aircrew in the Aircraft. This method should then check whether that moves that Aircrew to the next status.
It is suggested that you add a method to the Aircrew class that takes a PrintWriter object as a parameter. This will be useful when you write the contents of the whole Aircraft array
back to a text file. There are other ways of doing this, for example, calling all the public get methods of Aircrew in Aircraft (or even Carrier). There is no "right answer".
Finally the Aircrew class requires a toString method which returns a String with information about the Aircrew object.
Please note that this time you are free to format the screen output in any way, provided only that the user of the program can easily understand the information being displayed.
This is Carrier operations after all, the users need to be able to take in the information at a glance, not spend time trying to decipher poorly formatted output.
Carrier operations don't stop while the user tries to read information.
Aircraft.java
(some major changes)
The Aircraft class now has the following attributes:
 tail code This is a String (text) and may consist of more than one word
The tail code is the unique identifier for an Aircraft
 status This is a String variable, the value "on deck" indicates that the
Aircraft is NOT on a Mission. The value "airborne" indicates that the
Aircraft is on a Mission
 crew This is now an array of Aircrew class object references for the
Aircrew objects associated with this Aircraft.
(when the Aircrew objects are added and instantiated)
 capacity This is the maximum number of Aircrew(s) that can be in this Aircraft.
This is set by the user when the Aircraft object is created, or read from
the input text file.
 aircrewNumbers
This is the current number of Aircrew(s) actually in the Aircraft,
starts at 0 when the Aircraft is instantiated, both from the keyboard and
the file.
The Aircraft class still requires at least 2 overloaded constructors.
An overloaded constructor, for keyboard input for an Aircraft. This constructor would take just the tail code and the capacity attributes as parameters. Since we have just created the Aircraft object the value of status must be "on deck" (it cannot be on a Mission) and as there are no Aircrew(s) associated with this Aircraft, the aircrewNumbers is 0.
A second, overloaded, constructor would be used when reading from a text file. When reading from a text file, the tail code is in the file as is the capacity. In addition there is a value for status. The number of Aircrew will also be in the file and will be read out but not stored in the Aircraft object
For both constructors, only Aircraft information is passed in, no Aircrew information.
In both constructors, do not forget to correctly deal with the array of Aircrew.
The Aircraft class will require accessor methods as you deem appropriate.
One of those accessor methods may be a method to return a copy of the Aircrew array. If you decide to write this accessor, remember to take privacy leaks into consideration.
The Aircraft class also requires a toString method that returns a String with information about the state of that Aircraft object, including any Aircrew and mission status. As with the Aircrew screen output, this time you are free to format the output anyway you want. (Provided that it is easy to read, output all on one line is NOT acceptable)
The Aircraft class requires at least one method to add an Aircrew to an Aircraft.
This method takes all of the relevant parameters for instantiating an Aircrew object from the keyboard, that is, call sign and name. Using the information (which comes from Carrier) in these parameters, instantiate an Aircrew object which is stored in the Aircrew array, (of the Aircraft that the user has selected and checked that it exists) provided that there is a free space. As before, the program first needs to check that the Aircrew call sign entered by the user is indeed unique. (Across all Aircrew's in all Aircraft, this has to be done in Carrier).
A second, overloaded method to add an Aircrew should be considered. This method will take all the information for adding an Aircrew from the text file. The difference is that, from the file, in addition to the call sign and name, the number of missions is included, whereas when reading the information from the keyboard, the number of missions is, of course, 0.
There will be a number of mutator methods that you will find you need to write, amongst them a method to increase the number of missions (add 1) for all the Aircrew(s), in that Aircraft, every time the Aircraft starts a new mission. This should be just one method.
As with the Aircrew class, you may want to consider writing a method that writes the details of the Aircraft object, including all the associated Aircrew, to a text file. Remember to write the actual number of Aircrews figure (aircrewNumbers) into the text file. This is required so that when we use that output file as an input file, the program knows how many Aircrew records it needs to read before the next Aircraft record starts.
As discussed above, the overall status of all the Aircrew, in an Aircraft, must be greater than or equal to the status of the Mission as entered by the user. You may want to consider writing a method that takes the user entered status as a parameter and returns true or false whether, or not, the overall status of the Aircrew is sufficient for the Aircraft to be assigned the mission (provided, first, that all the other conditions are met). This could make use of the algorithm that was described above on page 6.
The Aircrew and Aircraft classes do NOT ask the user for any input, either keyboard or file. There must not be any input objects in these classes such as Scanner or BufferedReader but not limited to these 2. Another way of saying this is that these classes are not interactive.
loading the array of Aircraft from a text file
The program now starts by asking the user for the name of a text file, see pages 11 - 12 for the format. This file will contain a number of Aircraft/Aircrew records. The file name will always exist, and this time will not be empty.
The contents of this file is used to populate the array of Aircraft, in Carrier. Once the contents of this file have been read into the array of Aircraft, the file is closed. The only time that a file is opened again is if the user selects it in the save option. Save can use an entirely different file name than the input file name.
Where the Aircraft has at least one Aircrew (meaning any number of Aircrew(s) greater than 0) then you want to call your overloaded addAircrew method from the Aircraft class, the one that takes all the Aircrew attributes, for one Aircrew at a time. Use this method to add a Aircrew to the correct Aircraft, one at a time.
There is a slightly different menu.
The program must work with any file name entered by the user (of the correct format), that is, the file name must not be hard coded.
An example of the information, in the text file, on each Aircraft consists of 4 lines. (3 lines for the Aircraft object and one additional line to indicate the number of Aircrew records that follow). There may be any number of 3 line Aircrew records after the Aircraft information. The Aircraft and Aircrew information is collectively known as a record:
An example of an input file:
94 A 001 unique tail code of the Aircraft
On deck
indicates the Aircraft is not on a Mission (status)
4
the maximum number (capacity) of Aircrew(s) for this Aircraft
0
the actual number of Aircrew in this Aircraft
94 A 002 unique tail code of the Aircraft
on deck
indicates the Aircraft is not on a Mission (status)
1
the maximum number (capacity) of Aircrew(s) for this Aircraft
1
the actual number of Aircrew in this Aircraft
Nav 01 Aviator
name of the Aircrew
panda bear
unique call sign of the Aircrew (unique across all Aircrew in all Aircraft)
10
number of missions this Aircrew has undertaken
ZZ 056 unique tail code of the Aircraft
On deck
indicates the Aircraft is not on a Mission (status)
3
the maximum number (capacity) of Aircrew(s) for this Aircraft
2
the actual number of Aircrew in this Aircraft
Pete Mitchell
name of the Aircrew
Maverick
unique call sign of the Aircrew (unique across all Aircrew in all Aircraft)
5
number of missions this Aircrew has undertaken
Nick Bradshaw
name of the Aircrew
Goose
unique call sign of the Aircrew (unique across all Aircrew in all Aircraft)
5
number of missions this Aircrew has undertaken
In the example above, the first 3 lines are required to instantiate the Aircraft object reference, (which is added to the array of Aircraft in Carrier, if there is space) the fourth line indicates the number of Aircrew objects to read, followed by this number of groups of 3 lines, which are required to instantiate the Aircrew object references in that Aircraft object.
The file may contain any number of records.
Given that this method is called before the user gets to see the main menu, there is now no need to worry about unique Aircrew call signs and Aircraft tail code's conflicting with anything that the user may enter.
The driver program, Carrier.java then presents the user with a menu, as follows:
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >>
Implement the functionality of each menu choice as follows (assume user input is always an integer):
1. Add Aircraft (very much the same as Assignment C)
This menu option is chosen when the user attempts to add an Aircraft object from the keyboard.
This time the difference is the program must first check if there is a free space in the Aircraft array.
Provided there is space, the first thing that the user will enter is the tail code of the Aircraft to add. The program must check that this tail code is not already assigned to any Aircraft in the array of Aircraft.
(Hint: write a search method, in Carrier.java, that searches through the array of Aircraft and returns the index of the requested Aircraft (using the tail code as the parameter)
or -1 if the Aircraft with the requested tail code is not found. See Lecture/Workshop 10)
If there is space in the array and the tail code is unique, the user is asked for all the relevant Aircraft information (which is the maximum number (capacity) of Aircrew this Aircraft can accommodate) and the resultant Aircraft object is added to the next free space in the array of Aircraft. If there is no free space in the array, the program returns to the main menu without asking the user for any information.
Note: Carrier class must NOT have Aircrew object attribute(s) or Aircrew object references. All interactions involving Aircrew will still be through the relevant Aircraft object.
If the tail code is already assigned to an Aircraft, the user is informed via a message to the screen and the program returns to the main menu.
Still NO Crew information is entered in this menu choice.
2. Display Menu
This menu choice displays the contents of the non-null Aircraft object references to the screen. The format is shown in the sample run of the program on page 18. This time you are free to format the output any way you see fit, with a reminder that the output must be easy for the user of the program to quickly understand. Calling any of these menu choices must not result in the program crashing (for example, NullPointerException)
This is now the top level menu for display. When the user selects this top level option, another sub menu will be presented.
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >>
1. Display All
Choosing this menu option, all of the Aircraft, with all their Aircrews, are
displayed to the screen.
2. Display Aircraft only - no aircrew
Choosing this menu option, all of the Aircraft, this time without any
Aircrew information, are displayed to the screen.
3. Display Aircrew only, no Aircraft
Choosing this menu option, all of the Aircrews, this time without any
Aircraft information, are displayed to the screen.
4. Display single aircraft
Choosing this menu option, the user is prompted (asked) for the
tail code of an Aircraft. If the Aircraft with that tail code is found in
the array, then all the information about that Aircraft, including its
Aircrew(s), are displayed to the screen. If the Aircraft with that tail code
is not found in the array, then an appropriate message is displayed to the screen.
5. Display single aircrew
Choosing this menu option, the user is prompted (asked) for the call sign of
an Aircrew. If the Aircrew with that call sign is found, then the information
for that one Aircrew is displayed to the screen. (Only Aircrew information,
no Aircraft information).If the Aircrew with the requested call sign
is not found, then an appropriate message is displayed to the screen.
6. Display Aircraft on deck
Choosing this menu option, all the Aircraft that are NOT on a Mission
are displayed to the screen. Just the Aircraft information is shown,
no Aircrew information.
7. Display airborne Aircraft
Choosing this menu option, all the Aircraft that ARE on a Mission
are displayed to the screen. Just the Aircraft information is shown,
no Aircrew information.
8. Return to main menu
3. Add Crew (basically the same as Assignment C, except it uses an array)
This menu choice adds an Aircrew to an Aircraft, using information from the keyboard. First, of course, the program must check that there is actually at least one Aircraft in the array. If there are no Aircraft (that is, the array of Aircraft is empty), then the user is informed with a message to the screen and the program returns to the main menu. The user is not asked for any further information.
If there is at least one Aircraft object in the array, then the user is asked for the tail code of an Aircraft. The program tries to find the Aircraft with this tail code. (Hint: use your search method again)
If the Aircraft with the user entered tail code is found, then there is one further check. This is to check that that Aircraft does not already have its maximum number (capacity) of Aircrews. If the Aircraft already has its maximum number of Aircrew, then the user is informed via a message to the screen, no further information is asked from the user, and the program returns to the main menu.
If the Aircraft with the user entered tail code is found and is not at its capacity of Aircrews, then the user is asked to enter the call sign of an Aircrew. There is one final check. The program must check that this user entered Aircrew call sign is not already in use. If the user entered call sign is already in use, then the user is informed, via a message to the screen, no further information is requested from the user, and the program returns to the main menu.
This is a more complex problem than in Assignment C, although it is still the same condition. As each Aircraft now has an array of Aircrew, the program has to go through all the Aircraft objects in the array of Aircraft and check through the array of Aircrew(s) in each Aircraft. Only when this has been done and the call sign for that Aircrew (the one entered by the user) has not been found, in any of the Aircraft, do we know that the call sign entered by the user is indeed unique.
There are 2 basic strategies for doing this, the first is to return a (privacy leak free) copy of the Aircrew array for an individual Aircraft to the main driver program (Carrier). The program can then go through this array comparing the call sign's in that array with the call sign entered by the user. If the call sign is not found and there is another Aircraft in the array of Aircraft, the program moves to the next Aircraft, gets a copy of the Aircrew array for that Aircraft and searches through that array.
The alternative is to write a method in the Aircraft class that takes the user entered call sign as a parameter. The method in the Aircraft class searches through the Aircrew array and returns true or false as to whether the call sign passed in as a parameter was found.
Either method is acceptable, write the one that you feel most comfortable with.
If the program gets to this point, then there is an Aircraft object with the user entered tail code and the user entered call sign is unique. The user is then asked to enter the name of the Aircrew (you already know the call sign) and the Aircrew object is added to the crew array for that Aircraft object. (The number of missions must be 0, as we have just instantiated the Aircrew and the status is worked out by the Aircrew constructor, based on the number of missions).
If there is not an Aircraft with the user entered tail code, then a message is displayed to the screen and the program returns to the main menu, without asking for any more information.
4. Launch Aircraft
This menu choice first checks that there is at least one Aircraft in the array. If not, then an appropriate message is displayed to the screen and the program returns to the main menu. If there is at least one Aircraft in the array, then the user is prompted (asked) for the tail code of an Aircraft.
The program must then find the Aircraft with this tail code, again, you could use the search method. The Aircraft we are looking for could be anywhere in the array. If the Aircraft with that tail code is not found, then an appropriate message is displayed to the screen and the program returns to the main menu.
If the Aircraft with that tail code is found, then the program must check that this Aircraft is available for a mission.
To be available for a mission, the Aircraft must not be on a mission and the Aircraft must have at least one Aircrew. If this is true, the user enters the required status of the mission. The Aircrew(s) (the whole group of Aircrew in this Aircraft) must have an overall status greater than or equal to the status entered by the user. This is explained in detail above.
If the Aircraft is not available for a mission, then an appropriate message is displayed to the screen and the program returns to the main menu.
If the Aircraft can be launched, that is, assigned a mission, then the appropriate changes are made to the Aircraft object. This includes changing the status of the Aircraft to "airborne" and incrementing the number of missions, by one, for all the Aircrew, of that Aircraft. Do not forget to check whether the increased number of missions crosses one of the boundaries of the Aircrew status, resulting in a change in Aircrew status.
The program always returns to the main menu at the end of the menu choice, regardless of the action taken or not taken.
5. Land Aircraft
This menu choice prompts (asks) the user for the tail code of an Aircraft, after making the same checks as in Launch Aircraft, that is, there is actually at least one Aircraft. As with Launch Aircraft appropriate messages should be displayed to the screen if the Aircraft with the user entered tail code is not found, the array of Aircraft is empty, or if the tail code is found but that Aircraft is not already on a mission. (You can't end a mission unless the Aircraft is currently on a mission.)
If any of the above are true, then the program returns to the main menu.
If the Aircraft with the user entered tail code exists and the Aircraft is on a mission, then the status attribute is set to "on deck", indicating that the Aircraft is not on a mission.
After the conclusion of any and all actions in this menu choice, the program returns to the main menu.
6. Save to file (see page 32 for how to do this)
Choosing this menu option, the user is prompted (asked) for the name of an output text file
and all the information in the array of Aircraft (including all Aircrews) is written to this text file.
File names must NOT be hard coded.
Also recall that this output file must be able to be used as input file the next time that
the program is run, so the output file needs to be written to the file in the format as shown on pages 11 - 12. (Do not forget to write the number of Aircrew associated with an Aircraft to the text file)
7. Shut down ops
This menu choice closes the program, without asking the user if they would like to save their
changes.
Example run of the program (NOTE not all functionality and error checks/messages are shown)

Enter input file name >> a.dat
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 1
Here is the list of Aircraft
How the assignment is marked
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
No aircrew present
]
Aircraft
[
Tail Code 94 A 002
Status : on deck
Max capacity 1
List of Air Crew
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 10
Status : Trained
]
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
]
Aircraft
[
Tail Code 2019 T Y
Status : On deck
Max capacity 5
List of Air Crew
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 20
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 10
Status : Trained
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 0
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 4
Enter tail code >> 2019 t y
Enter required status >> veteran
The Aircrew of this Aircraft does NOT have the required status for this mission.
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 4
Enter tail code >> ZZ Top
No Aircraft with the tail code ZZ Top was found
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 4
Enter tail code >> 2019 t y
Enter required status >> trained
Aircraft successfully launched
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 1
Here is the list of Aircraft
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
No aircrew present
]
Aircraft
[
Tail Code 94 A 002
Status : on deck
Max capacity 1
List of Air Crew
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 10
Status : Trained
]
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
]
Aircraft
[
Tail Code 2019 T Y
Status : airborne
Max capacity 5
List of Air Crew
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 21
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 1
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 2
Here is the list of Aircraft (no aircrew)
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
This aircraft has no aircrew
]
Aircraft
[
Tail Code 94 A 002
Status : on deck
Max capacity 1
This aircraft has 1 aircrew
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
This aircraft has 2 aircrew
]
Aircraft
[
Tail Code 2019 T Y
Status : airborne
Max capacity 5
This aircraft has 3 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 3
Here is the list of Aircrew only (no aircraft)
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 10
Status : Trained
]
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 21
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 1
Status : Rookie
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 4
Enter tail code >> zz 056
Here is the requested Aircraft
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 5
Enter aircrew call sign >> oof ness
Here is the requested aircrew
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 6
Here is the list of aircraft on deck
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
This aircraft has no aircrew
]
Aircraft
[
Tail Code 94 A 002
Status : on deck
Max capacity 1
This aircraft has 1 aircrew
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
This aircraft has 2 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 7
Here is the list of Aircraft that are airborne
Aircraft
[
Tail Code 2019 T Y
Status : airborne
Max capacity 5
This aircraft has 3 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 5
Enter tail code >> 94 A 002
This aircraft is not airborne
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 3
Enter tail code >> 94 A 002
This aircraft is already at max aircrew, cannot add
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 4
Enter tail code >> 94 A 002
Enter required status >> trained
Aircraft successfully launched
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 2
Here is the list of Aircraft (no aircrew)
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
This aircraft has no aircrew
]
Aircraft
[
Tail Code 94 A 002
Status : airborne
Max capacity 1
This aircraft has 1 aircrew
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
This aircraft has 2 aircrew
]
Aircraft
[
Tail Code 2019 T Y
Status : airborne
Max capacity 5
This aircraft has 3 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 5
Enter tail code >> 2019 t y
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 2
Here is the list of Aircraft (no aircrew)
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
This aircraft has no aircrew
]
Aircraft
[
Tail Code 94 A 002
Status : airborne
Max capacity 1
This aircraft has 1 aircrew
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
This aircraft has 2 aircrew
]
Aircraft
[
Tail Code 2019 T Y
Status : on deck
Max capacity 5
This aircraft has 3 aircrew
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 3
Enter tail code >> 2019 t y
Enter call sign >> oof ness
Aircrew call signs must be unique, that callSign is already in use
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 3
Enter tail code >> 2019 t y
Enter call sign >> Smashed It
Enter name >> Almost There
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 1
Here is the list of Aircraft
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
No aircrew present
]
Aircraft
[
Tail Code 94 A 002
Status : airborne
Max capacity 1
List of Air Crew
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 11
Status : Veteran
]
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]
]
Aircraft
[
Tail Code 2019 T Y
Status : on deck
Max capacity 5
List of Air Crew
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 21
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 1
Status : Rookie
]
Aircrew
[ Name: Almost There Call Sign: Smashed It
Missions : 0
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 6
Enter output file name >> b.dat
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 7

Enter input file name >> b.dat
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 2
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 1
Here is the list of Aircraft
Aircraft
[
Tail Code 94 A 001
Status : On deck
Max capacity 4
No aircrew present
]
Aircraft
[
Tail Code 94 A 002
Status : airborne
Max capacity 1
List of Air Crew
Aircrew
[ Name: Nav 01 Aviator Call Sign: panda bear
Missions : 11
Status : Veteran
]
]
Aircraft
[
Tail Code ZZ 056
Status : On deck
Max capacity 3
List of Air Crew
Aircrew
[ Name: Pete Mitchell Call Sign: Maverick
Missions : 5
Status : Rookie
]
Aircrew
[ Name: Nick Bradshaw Call Sign: Goose
Missions : 5
Status : Rookie
]

]
Aircraft
[
Tail Code 2019 T Y
Status : on deck
Max capacity 5
List of Air Crew
Aircrew
[ Name: Mike Metcalf Call Sign: Viper
Missions : 21
Status : Ace pilot
]
Aircrew
[ Name: Undefined Symbol Call Sign: OOF Ness
Missions : 11
Status : Veteran
]
Aircrew
[ Name: First Person Call Sign: Compiles
Missions : 1
Status : Rookie
]
Aircrew
[ Name: Almost There Call Sign: Smashed It
Missions : 0
Status : Rookie
]
]
Display Menu
1. Display All
2. Display Aircraft only - no aircrew
3. Display Aircrew only - no Aircraft
4. Display single aircraft
5. Display single aircrew
6. Display aircraft on deck
7. Display airborne aircraft
8. Return to main menu
Enter choice >> 8
Ops Main Menu
1. Add aircraft
2. Display Menu
3. Add air crew
4. Launch Aircraft
5. Land Aircraft
6. Save to file
7. Shut down ops
Enter choice >> 7
