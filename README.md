# RecyclerView-MultipleViewType

Up until now we’ve displayed same type of Views within a RecyclerView.

# RecyclerView
RecyclerView with heterogeneous layouts is commonly used in to display section headers and details(Both require different layouts, hence different view type). Also it’s used in a Newsfeed Application(like Facebook, Instagram) that display essentially different views for different types. Example : text, image, gif, video etc. Each of these require a different layout type inside the RecyclerView.

We’ll be implementing two view types (header, child) that are inflated by two different layouts. Each has it’s own implementation specified in the adapter class.

<br></br>
<a href="url"><img src="https://github.com/sambhaji213/RecyclerView-MultipleViewType/blob/master/images/device.png" align="left" height="480" width="300"></a>
