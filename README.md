# Reading-Recommender-System-api
## About :
- A backend REST api for recommending books for reading depending on the number of unique read pages of each book.

## Tools and concepts : 
- Java spring boot, postMan and mySQL.
## How to Use it locally? :
- Install the project.
- Install MYSQL workbench
- Set the username of the local host server of mysql to "root" and the password to "123@123qweasd".
- Run the sql script in "Database" folder 
- follow this path to reach the jar file : 4) Spring boot Rest CRUD Api\crud\target.
- Run this command on the cmd inorder to run the jar file : java -jar crud-0.0.1-SNAPSHOT.jar
- Now you can access the api on http://localhost:8080

## API Functionality :
1- Let the user submit a reading interval of specific book :

![post](https://github.com/MahmoudAdelkamal/Reading-Recommender-System-api/assets/48772371/b687ae26-11ad-4fcf-8d41-372c6827fc2d)

2- Return to the user the top 5 recommended books according to the number of unique read pages :
![1](https://github.com/MahmoudAdelkamal/Reading-Recommender-System-api/assets/48772371/cf886932-23c7-4fae-a831-aed9836dde74)
![2](https://github.com/MahmoudAdelkamal/Reading-Recommender-System-api/assets/48772371/ef740def-5392-4888-aa11-f7aa55020f63)
![3](https://github.com/MahmoudAdelkamal/Reading-Recommender-System-api/assets/48772371/2d842744-d779-486e-9faa-199fc99c7893)
![4](https://github.com/MahmoudAdelkamal/Reading-Recommender-System-api/assets/48772371/8ff6e731-f81c-43a0-a326-f97bda5e9db4)
![5](https://github.com/MahmoudAdelkamal/Reading-Recommender-System-api/assets/48772371/7bc9290b-fd35-40eb-86a7-2b9edb7822ff)

