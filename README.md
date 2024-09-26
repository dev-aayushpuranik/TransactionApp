# Banking Application
This is a mobile banking application designed to allow users to manage their bank accounts by depositing and withdrawing money. The app ensures users cannot withdraw more than they have in their accounts, preventing overdrafts. The application is currently live on the Play Store and follows CI/CD practices, allowing for continuous integration and deployment on every push to the repository.

# Features
- **Deposit Funds:** Users can deposit money into their account.
- **Withdraw Funds:** Users can withdraw money from their account as long as they have sufficient funds.
- **Overdraft Protection:** The app prevents users from withdrawing more money than they currently have in their account.
Example:
Deposit: 50.00 (successful)
Withdraw: 25.00 (successful)
Withdraw: 25.00 (successful)
Withdraw: 0.10 (unsuccessful, insufficient funds)

# Tech Stack
- **Android Development:** Built natively using Kotlin/Java.
- **Architecture:** Follows MVVM architecture for separation of concerns and better testability.

# How to Install
- Download the application from the Play Store: Play Store Link
- Open the app and sign in with your credentials to begin managing your account.

# How to Contribute
- Fork the repository.
- Clone your fork locally:
 -- git clone https://github.com/your-username/banking-app.git
- Make your changes and commit them:
 -- git commit -m "Your commit message"
- Push your changes to your fork:
 -- git push origin your-branch
- Open a pull request to merge your changes.

# Running the App Locally
To run the app locally, follow these steps:
- Clone the repository:
 -- git clone https://github.com/your-repository/banking-app.git
- Open the project in Android Studio.
- Sync the project with Gradle files.
- Build and run the project on an Android emulator or physical device.

# License
This project is licensed under the Apache License - see the LICENSE file for details.
