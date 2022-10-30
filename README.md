# BasicRoomExample
Steps to implement Room in Project-
1. module or app/build.gradle file - 
    1.1 add plugin kotlin kapt - "id 'kotlin-kapt'"
    1.2 add dependency to execute compiler "kapt 'androidx.room:room-compiler:2.4.3'"
    1.3 add dependency for library code "implementation 'androidx.room:room-runtime:2.4.3'"
2. database package
    1. dao package for queries
    2. entity package for Models/Beans
        2.1 always set primary key
    3. AppDatabase class to initialise database