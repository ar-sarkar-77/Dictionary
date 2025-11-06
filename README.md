# Android Dictionary App

A simple and intuitive **Android dictionary app** built with Kotlin and SQLite. Search for words, view meanings, examples, parts of speech, and mark your favorites for easy access.

---

## Features

- **Search Functionality**: Live search to quickly find words in the dictionary.  
- **Word Details**: Displays meaning, part of speech, and example usage for each word.  
- **Favorites**: Mark words as favorites to access them later.  
- **SQLite Database**: Uses a local SQLite database (`dictionary.db`) for fast and efficient storage.  
- **Clean UI**: User-friendly interface with `RecyclerView` and custom layouts.  
- **Offline Access**: Fully functional without an internet connection.  

---

## Screenshots

![dictionary](https://github.com/user-attachments/assets/160ec789-f512-48c9-822b-0000e318558f)
## Tech Stack

- **Language**: Kotlin  
- **Database**: SQLite (via SQLiteAssetHelper)  
- **Image Loading**: Glide for dynamic favorite icons  
- **UI Components**: RecyclerView, EditText, TextView, ImageView  

---

## How It Works

1. On startup, the app loads all words from the local SQLite database.  
2. Users can search for words in real-time using the search bar.  
3. Each word displays its meaning, part of speech, and example usage.  
4. Users can toggle the favorite status, which updates both the database and UI instantly.  

---

## Installation

1. Clone the repository:  
   ```bash
   git clone https://github.com/ar-sarkar-77/dictionary-app.git

2. Open the project in Android Studio.

3. Place dictionary.db in the assets/databases/ folder.

4. Build and run the app on an Android device or emulator.

## License

This project is open-source and free to use under the MIT License.
