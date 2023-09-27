# OpenWeather App

App for watching the predictions on weather from openweather.org site. 


# Project structure

This project is developed with MVVM architecture (as suggested by Google) having these layers:

* Data: it has two directories, "model" for data clases that hold data from API and "network" for managing the API requests with Retrofit.
* Domain: it has the use cases of the project
* Views: Containing oll the presentation features of the project, views, viemodels, adapters, interfaces, etc.
* DI: it contains the necessary resources for implementing dependency inversion with Dagger Hilt.
