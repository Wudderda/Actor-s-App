To run the Actor's App follow these steps:
1-Run the Android Studio and File->new->new Project
2-Choose Basic Activity then next 
3-Name can be any name you want, Package name = com.hasan.actorsapp ,Language:Java , minimum api level :API 14 then finish.
4-Copy activity_listview,activity_main,content_main files and paste to app/res/layout path. Overwrite forall
5-Copy  strings file and paste to app/res/values path
6-Copy LinkedList.java and MainActivity.java files and paste to app/java/com.hasan.actorsapp path.
7-Now you can run the project on virtual device(preferrably 5.5 inches) or on a smartphone via usb cable connection.

Design Choices: 
All the information is stored on a sorted linked list.The sorting operation was done on insertion function to reduce
overall complexity of the application.To have properly alligned display over the actor information, we have a display
function that arranges indentations of the infos. All the methods are defined in the LinkedList.java file and it is a 
public class.ListView feature of android studio was used to have a better design and scrollable screen.


Since the data for linked list is hardcodded , you can add your own actors to the list or copy and paste the existing ones 
in init() function for testing purposes  . Duplication of actors will not be a problem for design of the application.