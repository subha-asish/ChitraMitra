# ChitaMitra - A Movie Searching App

ChitaMitra is a movie searching app developed using Android Java, Retrofit, OMDB API, UI/UX design, and Picasso for image rendering. This app provides users with movie posters, ratings, reviews, casts, descriptions, and year of release.
![loginF](https://user-images.githubusercontent.com/82257697/225701117-b9d209e2-3b64-430a-9e93-dc36b53d8003.jpg)
![signupF](https://user-images.githubusercontent.com/82257697/225701202-a1bd8895-9eaa-4fde-a2e3-206743d67a05.jpg)
![Screenshot 2023-07-29 115935](https://github.com/subha-asish/ChitraMitra/assets/82257697/fb6cbdce-5f7f-4411-a7f4-94c209e8f3d5)
![Screenshot 2023-07-29 115853](https://github.com/subha-asish/ChitraMitra/assets/82257697/ae7a5cae-f8dc-4a43-86d6-e5355816fb03)
![Screenshot 2023-07-29 120028](https://github.com/subha-asish/ChitraMitra/assets/82257697/3a6f68fb-96f6-4146-9e7b-5feef1211472)


# Features
1. Users can search for movies by their titles.
2. Users can view movie details such as posters, ratings, reviews, casts, descriptions, and year of release.
3. The app uses OMDB API and TMDB API to fetch movie data.
4. The app uses Retrofit to make API requests.
5. The app uses Picasso to render images.
6. The app uses Firebase authentication.

# Technical Details
## Authentication
ChitaMitra uses Firebase realtime database based authentication. 
## Architecture
ChitaMitra uses the Model-View-ViewModel (MVVM) architecture. This architecture separates the user interface (View) from the business logic and data (ViewModel) and the data storage (Model).

## API
ChitaMitra uses the Open Movie Database (OMDB) API to fetch movie data. OMDB is a RESTful web service to obtain movie information, including plot, ratings, reviews, trailers, and more.

## Networking
ChitaMitra uses Retrofit to make API requests. Retrofit is a type-safe HTTP client for Android and Java. It simplifies the process of making network requests by abstracting away the details of HTTP protocol and providing a simple interface for defining API endpoints.
##  Image Rendering
ChitaMitra uses Picasso to render images. Picasso is a powerful image downloading and caching library for Android. It simplifies the process of downloading and displaying images by handling image loading and caching automatically.


# UI/UX Design
ChitaMitra's UI/UX design was carefully crafted to provide a seamless and intuitive user experience. The app's design is inspired by Material Design guidelines, which provide a set of principles for designing beautiful and consistent interfaces.

# Installation

To install ChitaMitra, you can follow these steps:

1. Clone the repository: git clone https://github.com/subha-asish/ChitraMitra/
2. Open the project in Android Studio.
3. Build the project.

# Usage
To use ChitaMitra, you can follow these steps:

1. Open the app.
2. Enter a movie title in the search bar and press enter.
3. The app will fetch movie data from OMDB API and display it on the screen.


# Contributing

We welcome contributions to ChitaMitra! If you find a bug or want to add a new feature, please create a pull request. Before contributing, please read our  [contributing guidelines for this project](/CONTRIBUTING.md).

# Support
If you encounter any issues while using ChitaMitra, please create an issue in the issue tracker. We'll do our best to help you resolve the issue.

# Acknowledgements
We would like to thank the following individuals and organizations for their contributions to ChitaMitra:

1. The developers of OMDB API, Retrofit, and Picasso.
2. The designers who created the Material Design guidelines.
3. The contributors who helped improve ChitaMitra.
