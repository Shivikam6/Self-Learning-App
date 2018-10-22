# Self-Learning-App
A self-learning web application, so that users can create questions, answer questions and see hints and feedbacks.

Objective:
Write a self-learning web application, so that users can create questions, answer questions and see hints and feedbacks.

Functional Requirements:
1. A new user can register with first name, last name, user name (should be unique) password and confirm password.
2. A user can login into system with correct username and password.
3. After login, a user can click a button to logout of the system, the user can’t access the system unless login again.
4. After login, a user can create numerical questions, with a question description (a short paragraph of text), a hint (a short paragraph of text) and a correct answer (a number).
5. After login, a user can create multi-choice questions, with a question description (a short paragraph of text), 4 choices (short paragraphs of text), a hint (a short paragraph of text) and a correct answer (A, B, C or D).
6. After login, a user can view a list of all available questions, there should be a check mark displayed next to each of the questions the user has answered correctly.
7. After login, a user can choose one of the question to answer, by enter his/her choice/number into a text field and click submit. The system will give the user a feedback. If user chose/entered a correct answer, display a congratulation message and a link to go back to question list. If the user chose/entered a wrong answer, display the same question page, and display a hint with the question. Empty answer is not allowed, an error message should be displayed if user didn’t enter anything and click the submit button.
8. After login, in the question list page, user can click a ‘clear history’ button permanently clear the user’s history of answered questions. There should be no check marks next to any questions.
9. Write a function to let user change his/her password, with current password, new password and confirm-new-password.
10. Write a function to edit his/her profile (first/last name), with current password, and new first/last name.

Technical Requirements:
1. Use Servlet and JSP to implement the web application.
2. Use Eclipse (JavaEE) version to create the project, and setup dependencies.
3. You code should complies to MVC architecture
4. Correctly use packages to separate different modules of your Java code.
5. Use MySQL as database to store all users and questions.
6. Users’ passwords must be one-way encrypted before saved to database.
7. You need to submit you whole Eclipse project folder (not your workspace folder!).
8. You need to export your whole database as a SQL file and submit it with your code.
9. Zip the project folder and SQL file into one zip file
10. Name your zip file your_netID_hw4.zip, and submit it on Black Board before deadline.
11. If you want to use environment variables in database connections (preferred way)
    a. Use “ICSI518_DB_HOST” as database host name
    b. Use “ICSI518_DB_PORT” as database port number
    c. Use “ICSI518_DB” as database name
    d. Use “ICSI518_DB_USER” as database user name
    e. Use “ICSI518_DB_PASSWD” as database password
12. If you don’t want to use environment variables, make sure your database connection parameters as following:
    a. Host: “localhost”
    b. Port: “3306”
    c. Database name: “icsi518_hw4”
    d. Database user name: “icsi518”
    e. Database password: “secretICSI518”
