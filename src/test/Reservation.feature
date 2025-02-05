Feature: Hotel Reservation

  Scenario: User books a hotel room successfully
    Given user starts chrome browser
    And user launch app using url "https://adactinhotelapp.com/"
    When user enters text "reyaz0806" in textbox using xpath "//input[@id='username']"
    And user enters text "reyaz123" in textbox using xpath "//input[@id='password']"
    When user clicks button using xpath "//input[@id='login']"
    And user selects location as "Sydney"
    And user selects hotel as "Hotel Creek"
    And user selects roomType as "Standard"
    And user selects noOfRooms as "1 - One"
    And user sets check-in-date as "31-1-2025"
    And user sets check-out date as "29-12-2024"
    And user selects adults per room as "2 - Two"
    And user clicks submit button
    And user closes browser