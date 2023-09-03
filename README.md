
# User Feed Application

This Android application is designed to display a user feed on a single screen. The feed data is fetched from a remote API and stored locally using Room Database for offline access. Pagination is implemented using Paging3 library for smooth scrolling, and images are loaded using Coil library. The project follows MVVM Clean Architecture and uses Kotlin, Navigation Component, Hilt for dependency injection, and Jetpack Compose for UI.

## Features

- Display a user feed with data such as author, post type, likes, comments, content, and media.
- Offline access to previously fetched feed data using Room Database.
- Smooth and efficient scrolling through the feed with Paging3.
- Efficient image loading and caching with Coil library.
- MVVM architecture for clean and organized code.
- Dependency injection with Hilt for easy testing and maintainability.
- Navigation between different screens using Navigation Component.

## Technologies and Libraries Used

- **Kotlin**: The primary programming language for Android development.
- **Jetpack Compose**: Used for building the user interface with a declarative and modern approach.
- **Room Database**: Provides offline access to feed data and handles local data storage.
- **Paging3 Library**: Implements pagination for efficient loading of large datasets.
- **Retrofit**: Used for making network requests to fetch feed data from a remote API.
- **Coil**: An image loading library for displaying images efficiently.
- **Navigation Component**: Handles navigation between different screens and components.
- **Hilt**: A dependency injection library for managing and injecting dependencies.
- **MVVM (Model-View-ViewModel)**: Architecture pattern used to separate concerns and ensure clean and testable code.
- **Mocki.io**: A platform used to create and host mock APIs for testing and development purposes.

## Project Structure

The project follows a modular structure to maintain separation of concerns and organization. The main modules include:

- `app`: The main Android application module containing UI components, navigation, and view models.
- `data`: The data module responsible for data sources, repository, and database setup.
- `domain`: The domain module holds the use cases and business logic.
- `di`: Contains dependency injection modules for Hilt.

## Setup and Usage

1. Clone the repository: `git clone https://github.com/Dhananjay57/UserFeed.git
2. Open the project in Android Studio.
3. Build and run the application on an emulator or physical device.

## How to Contribute

Contributions to this project are welcome. To contribute, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b feature-name`
3. Make your changes and commit them: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature-name`
5. Create a pull request to the `main` branch of the original repository.

Please ensure your code follows coding standards and includes appropriate tests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or inquiries, please feel free to contact me and follow my updates on Instagram @dro.iddreamer, Medium Dhananjay Yadav on Medium, and LinkedIn Dhananjay Yadav on LinkedIn.
![image](https://github.com/Dhananjay57/UserFeed/assets/13062553/4283c1fc-c80e-4354-a6f5-5c2eeccaa1ee)
