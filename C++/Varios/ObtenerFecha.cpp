#include <ctime>
#include <iostream>

int main() {
       time_t current_time;
    struct tm * time_info;
    char timeString[9];

    time(&current_time);
    time_info = localtime(&current_time);

    strftime(timeString, sizeof(timeString), "%H:%M:%S", time_info);
}