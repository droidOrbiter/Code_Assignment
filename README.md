# Code Assignment

</br>

### Abstract
The main purpose of the application is to download and process the content from a RESTful API. The actual content is a list of repositories which will be presented by a RecyclerView. At the beginning of the application a ProgressBarView will be displayed with an animation to show the downloaded progress. After the content is downloaded the RecyclerView will be displayed.


</br>

Make use of 
 * MVVM Architecture
 * Dagger 2
 * DataBinding
 * LiveData
 * Animation
 
</br>


* ### App Structure

![appStructure](https://user-images.githubusercontent.com/51214344/72342921-524e8400-36d6-11ea-9bc6-4cab6921198f.png)



####  UI 

> In the UI package are stored all the Views of the application. I have created one View with the name 'MainActivity'. The view is responsible to initialize the ViewModel.


#### ViewModel

> The ViewModel with be responsible to initialize the RecyclerView, the ProgressBarView and handle the UI requests.


#### Domain Layer
> This layer is responsible to initialize the request date from the data layer.


#### Data Layer
> The main purpose in this layer is to downloand and fetch the content from the remote scource.

</br>




