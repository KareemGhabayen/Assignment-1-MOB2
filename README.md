# Onboarding Screens - MOB2

## Project Overview
This project is an Android application that demonstrates a professional onboarding flow using **Fragments** and **View Binding**. It focuses on safe data communication between components using **Interfaces**.

## Features
* **Fragment 1:** Welcome screen to start the flow.
* **Fragment 2:** User input screen (Name, Email, Age, Gender).
* **Fragment 3:** Summary screen that displays the passed data and includes a dynamic confirmation logic (Checkbox/Button interaction).

## Technical Implementation
* **Interface Communication:** Used `OnFragment2DataListener` to pass data from Fragment2 to MainActivity without static variables.
* **Fragment Navigation:** Managed via `FragmentManager` with BackStack support.
* **Dynamic UI:** The "Finish" button in Fragment 3 is enabled/disabled based on a CheckBox state.

## Developer
**Kareem Ghabayen**
