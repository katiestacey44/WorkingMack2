# Abstract
The Mackinac building is used by hundreds of students everyday, and includes more than a few different departments. Many of these students are freshmen, not used to such a large building to navigate. Not to mention, the Mackinac building doesn't have the simplest layout of classroom to easily memorize and interrupt. The idea for our app is hoping to give students the ability to quickly navigate through the Mack. building and possibly taking away one more thing to stress about. A student would input their current location by typing in the classroom they happened to be closest to and then inputting their desired classroom to which the app will present a graphic and some directions that will show students exactly where to go. The earliest version of the project will just have the ability to show a path with in the C building on the first floor   

# Introduction
Using a graphic of the Mackinac floor plans the App will give directions from one classroom to the next to help students navigate through the building. The app utilizes DFS through an array of adjacency lists that connect the rooms together in a tree like fashion that represent rooms within the Mackinac building and calculate a path to give students direction towards their desired classroom.
# Architectual design


# Use Case Diagram
<img width="1090" alt="image" src="https://github.com/katiestacey44/WorkingMack/assets/117104997/b9fff579-356f-466f-b292-44730a94b4fd">
<img width="508" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/15e7e5ff-6b69-47c8-a351-695990bf618d">
<img width="589" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/ac06413e-ee9f-4ca4-8874-cc3e3041d268">
<img width="582" alt="image" src="https://github.com/katiestacey44/WorkingMack2/assets/117104997/816e2476-bdf0-4a5a-b8bc-52ec57fa22ac">




# Risk analysis and Retrospective
For the risks of the project, it was risky to use Android Studio as it was something that both project members had no experience with but were lucky able to get the hang of in time to finish the project, with many youtube tutorials. There were a lot of problems with timing and when to start or finish a certain step in the planning process. It probably would have been better to start coding earlier but it also would have been nice to have done some more research on implementations of different search algorithms. Formulating the implementation for a map took the most time. Google API is not free, leaflet is html based, figuring out what would work with java in Android Studio IDE. There were also issues with testing android graphics. When it came to learning everything, it ended up being mostly a result of trial and error for the most part.
For the solutions to a lot of the issues we ran into, based on an idea of a non-geographic map from leaflet, our team decided to implement a graph structure of points with xy-coordinates mapped to an image to allow the program to draw paths between rooms. A cleaned blueprint of the C1 wing of Mack was used for the map display. A Depth-First-Search method was used for finding the path between 2 arbitrary rooms in the graph. And also Android Studio’s methods Canvas and drawPath/drawLines were used to visualize the path on the UI using these xy-coordinates. A stronger set plan may have allowed for more time in research and learning of Android Studio but overall the project met the requirement and expectations we were hoping for. 




# UI
<img width="277" alt="image" src="https://github.com/katiestacey44/WorkingMack/assets/117104997/a42731e0-8d62-4771-8d9f-da038114c82e">
<img width="336" alt="image" src="https://github.com/katiestacey44/WorkingMack/assets/117104997/a665f8a4-2adc-447d-84f8-3d92422168cf">




