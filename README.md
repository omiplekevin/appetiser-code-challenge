# AppetiserPlay #
A coding challenge.

*Developer*: **KEVIN OMIPLE**

---

## Discussion ##
### MVP as Architecture
- This architecture provide clear distribution of responsiblities of each classes, easier and convienient maintainability of the code base.
- Modularity is a key also for MVP Acrhitecture. You dont have to change almost everything if you want to switch into other implementation or changes on UI.
- Easy to test, as it is because of the defined scope of every method or module in the architecture.

### Persistence ###

#### Data ####
- The application uses Shared Preference table as a basic storage of information during the runtime. This is used for saving the json string response from the [iTunes Search API query](https://itunes.apple.com/search?term=star&amp;country=au&amp;media=movie) and saving the `last visited` timestamp.

#### UX ####
- The uses default runtime persistence. When the application is brought into background. The runtime lifecycle manages by default the persistence of the elements with the app.

#### Documentation ####
- The application use internal documentation by means of comments. This follows JavaDoc format.

#### Dependencies ####
- [Retrofit](https://square.github.io/retrofit/)
- [Android RecyclerView](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html)
- [Android CardView](https://developer.android.com/reference/android/support/v7/widget/CardView)
- [ButterKnife](http://jakewharton.github.io/butterknife/)
- [Lombok](https://projectlombok.org/)
- [Dagger 2](https://google.github.io/dagger/)
- [RxJava](https://github.com/ReactiveX/RxJava)
- [Picasso](https://square.github.io/picasso/)

#### License ####
Copyright 2019 Kevin Omiple

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

---
## Source Code ##
You may clone this project via:
- SSH: git@github.com:omiplekevin/appetiser-code-challenge.git
- HTTPS: https://github.com/omiplekevin/appetiser-code-challenge.git
