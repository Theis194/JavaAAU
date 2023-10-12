# To Do
* Finish ui
    * Reserve Room
* Create pdf(justify stupid questions)

# Getting Started
To Compile the program you need to navigate to the directory of the files. Once in the directory run: 
``` powershell
javac -d ./classes/ ./*.java
```
When the classes have compiled navigate to the classes folder and run the following command:
``` powershell
java BookingSystem
```
The program should now be running in the commandline.

## How does it work
The systems comes with no courses, groups, or rooms. It only comes with 10 users all named peter. You can manually create users, courses, groups, and rooms.

* To create a group you must create a course, add students to the course, and then create a new group.

## Limitations
As the system is currently implemented a student can be part of an "infinite" amount of courses at once.