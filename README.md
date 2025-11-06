Android Dictionary App

A simple and intuitive Android dictionary app built using Kotlin and SQLite. This app allows users to search for words, view their meanings, parts of speech, examples, and mark their favorite words for quick access.

Features

Search Functionality: Quickly search for words in the dictionary using a live search bar.

Word Details: View the meaning, part of speech, and example usage for each word.

Favorites: Mark words as favorites to easily access them later.

SQLite Database: Uses a local SQLite database (dictionary.db) for storing and retrieving word data efficiently.

Clean UI: Simple and user-friendly interface with RecyclerView and custom item layouts.

Offline Access: Fully functional without an internet connection.

Screenshots
![dictionary](https://github.com/user-attachments/assets/160ec789-f512-48c9-822b-0000e318558f)

Tech Stack

Language: Kotlin

Database: SQLite (via SQLiteAssetHelper)

Image Loading: Glide for dynamic favorite icons

UI Components: RecyclerView, EditText, TextView, ImageView

How it Works

The app loads all words from the local SQLite database on startup.

Users can search words in real-time using the search bar.

Each word displays its meaning, part of speech, and example.

Users can toggle favorite status, which updates the database and UI instantly.

Installation

Clone the repository:
git clone https://github.com/ar-sarkar-77/Dictionary.git

Open the project in Android Studio.

Place dictionary.db in the assets/databases/ folder.

Build and run the app on an Android device or emulator.

License

This project is open-source and free to use under the MIT License.
