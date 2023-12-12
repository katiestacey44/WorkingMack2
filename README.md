# Abstract
The Mackinac building is used by hundreds of students everyday, and includes more than a few different departments. Many of these students are freshmen, not used to such a large building to navigate. Not to mention, the Mackinac building doesn't have the simplest layout of classroom to easily memorize and interrupt. The idea for our app is hoping to give students the ability to quickly navigate through the Mack. building and possibly taking away one more thing to stress about. A student would input their current location by typing in the classroom they happened to be closest to and then inputting their desired classroom to which the app will present a graphic and some directions that will show students exactly where to go. The earliest version of the project will just have the ability to show a path with in the C building on the first floor   

# 1. Introduction
Using a graphic of the Mackinac floor plans the **MakPath** App will give directions from one classroom to the next to help students navigate through the building. The app utilizes DFS through an array of adjacency lists that connect the rooms together in a tree like fashion that represent rooms within the Mackinac building and calculate a path to give students direction towards their desired classroom.
# 2. Architectual design
<p align="center">
<img width="343" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/1e2dbc06-d6a4-4313-915f-3ec2b31eb8ef">
<p/>
<br/>
  
The app allows the user to interact with a simple Android user interface to input data which is sent to the logic layer of the program to process for path generation. The logic layer contains functions for interacting with a graph structure of points containing xy-coordinates to generate a path for the user<br/>
The interface on the second screen displays the results of the path generation performed by the logic and data layers.
<br/>
<p align="center">
  <br/>A visualization of the points in the graph structure from which paths are drawn<br/>
  <img width="100"alt="points" src="https://github.com/katiestacey44/WorkingMack2/assets/146682121/bdb80ba2-7baf-47fe-b988-3bf4ae88fa32">
<p/>




## 2.1 Use Case Diagram
<img width="1090" alt="image" src="https://github.com/katiestacey44/WorkingMack/assets/117104997/b9fff579-356f-466f-b292-44730a94b4fd">
<img width="508" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/15e7e5ff-6b69-47c8-a351-695990bf618d">
<br/>

## 2.3 UML Sequence Diagram
<img width="589" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/ac06413e-ee9f-4ca4-8874-cc3e3041d268">

## 2.4 Class Diagram
<img width="582" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/816e2476-bdf0-4a5a-b8bc-52ec57fa22ac">


# 3. User Interface
## 3.1 First Screen's Interface
<p align="center">
  <img width="333" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/b6e861fd-5f6d-4a73-9c00-320b4f784b76">
  <img width="300" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/146682121/0cf0b22b-c2e5-4c37-8298-a6554da39d6e"><br/>
<p/>
  
## 3.2 Second Screen's Interface
<br/>
<img height="630" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/02736e62-5833-4625-8e74-9731f7c9afc3">
<img height="630" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/9e07390a-69af-4905-bcbf-03da548eefad">
<img height="630" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/f4d3601b-15c6-4b2a-af00-1f0af932a1cf">







# 4. Risk analysis and Retrospective
## Risk Analysis
Developing in Android Studio, an IDE the team was unfamiliar with and had no prior experience using, was one risk in completely the project in time. The team used youtube tutorials and the android develoeprs website to learn how to implement their ideas in Android mobile development. There were a lot of problems with timing and when to start or finish a certain step in the planning process.  More research on implementations of different search algorithms for path creation could have proved beneficial for higher performance. Formulating the implementation for a map was the most time-consuming part of the app's development. The team ran into several roadblocks in searching for a way to display a visual map within the our program's constraints: Google API is not free, leaflet is html based and would be difficult to implement in java. There were also issues with implementing the test cases that use android graphics. The development of MakPath was filled with trial and error as the code was improved over the semester.
## Retrospective on solutions to issues

### Solution to the map
- Based on an idea of a non-geographic map from leaflet, our team decided to implement a graph structure of points with xy-coordinates mapped to an image to allow the program to draw paths between rooms. A cleaned blueprint of the C1 wing of Mack was used for the map display.
- A Depth-First-Search method was used for finding the path between 2 arbitrary rooms in the graph to prvide a list of visited points between the rooms.
- Android Studio’s methods Canvas and drawPath/drawLines were used to display the path on the UI using xy-coordinates once we had a path.
<br/>
In conclusion, A stronger set plan may have allowed for more time in research and learning of Android Studio, but overall, the project met the requirement and expectations we had hoped for. 






